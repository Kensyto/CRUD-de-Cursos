package com.ken.coursemanager.repository;

import com.ken.coursemanager.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);
    List<Course> findByNameContainingIgnoreCase(String name);
    List<Course> findByCategoryContainingIgnoreCase(String category);
}
