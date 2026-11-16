package com.university.academic_managemnt.repository;

import com.university.academic_managemnt.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}