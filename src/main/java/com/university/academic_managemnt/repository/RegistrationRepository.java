package com.university.academic_managemnt.repository;

import com.university.academic_managemnt.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}