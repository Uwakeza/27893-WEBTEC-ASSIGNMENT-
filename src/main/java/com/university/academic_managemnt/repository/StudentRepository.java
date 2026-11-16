package com.university.academic_managemnt.repository;

import com.university.academic_managemnt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}