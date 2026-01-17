package com.jules.coursemanager;

import com.jules.coursemanager.model.Course;
import com.jules.coursemanager.repository.CourseRepository;
import com.jules.coursemanager.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @MockBean
    private CourseRepository courseRepository;

    @Test
    public void testToggleActive() {
        Course course = Course.builder().id(1L).active(true).build();
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        courseService.toggleActive(1L);

        assertFalse(course.getActive());
        verify(courseRepository, times(1)).save(course);
    }
}
