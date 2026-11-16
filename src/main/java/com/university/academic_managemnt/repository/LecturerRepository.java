package com.university.academic_managemnt.repository;

import com.university.academic_managemnt.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
}