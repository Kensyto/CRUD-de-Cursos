package com.jules.coursemanager.service;

import com.jules.coursemanager.model.Course;
import com.jules.coursemanager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public List<Course> search(String name, String category) {
        if ((name == null || name.isEmpty()) && (category == null || category.isEmpty())) {
            return courseRepository.findAll();
        }
        if (name != null && !name.isEmpty() && category != null && !category.isEmpty()) {
            return courseRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
        }
        if (name != null && !name.isEmpty()) {
            return courseRepository.findByNameContainingIgnoreCase(name);
        }
        return courseRepository.findByCategoryContainingIgnoreCase(category);
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public void toggleActive(Long id) {
        courseRepository.findById(id).ifPresent(course -> {
            course.setActive(!course.getActive());
            courseRepository.save(course);
        });
    }
}
