package com.university.academic_managemnt.repository;

import com.university.academic_managemnt.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}