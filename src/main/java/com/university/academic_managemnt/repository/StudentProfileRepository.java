package com.university.academic_managemnt.repository;

import com.university.academic_managemnt.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}