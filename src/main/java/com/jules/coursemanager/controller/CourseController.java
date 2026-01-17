package com.jules.coursemanager.controller;

import com.jules.coursemanager.model.Course;
import com.jules.coursemanager.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listCourses(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String category,
                               Model model) {
        List<Course> courses = courseService.search(name, category);
        model.addAttribute("courses", courses);
        model.addAttribute("name", name);
        model.addAttribute("category", category);
        return "courses/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/form";
    }

    @PostMapping("/save")
    public String saveCourse(@Valid @ModelAttribute("course") Course course,
                             BindingResult result,
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "courses/form";
        }

        String message = (course.getId() == null) ? "Curso criado com sucesso!" : "Curso atualizado com sucesso!";
        courseService.save(course);
        redirectAttributes.addFlashAttribute("successMessage", message);
        return "redirect:/cursos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        model.addAttribute("course", course);
        return "courses/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        courseService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Curso excluído com sucesso!");
        return "redirect:/cursos";
    }

    @PatchMapping("/{id}/active")
    @ResponseBody
    public ResponseEntity<Void> toggleActive(@PathVariable Long id) {
        courseService.toggleActive(id);
        return ResponseEntity.ok().build();
    }
}
