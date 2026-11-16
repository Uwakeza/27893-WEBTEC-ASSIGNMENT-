package com.university.academic_managemnt;

import com.university.academic_managemnt.model.*;
import com.university.academic_managemnt.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EntityMappingTest {

    @Autowired DepartmentRepository departmentRepository;
    @Autowired LecturerRepository lecturerRepository;
    @Autowired CourseRepository courseRepository;
    @Autowired StudentRepository studentRepository;
    @Autowired StudentProfileRepository studentProfileRepository;
    @Autowired RegistrationRepository registrationRepository;

    @Test
    void allRelationshipsWork() {
        Department d = new Department();
        d.setName("Computer Science");
        d.setCode("CS");
        d = departmentRepository.save(d);

        Lecturer l = new Lecturer();
        l.setFirstName("Ann");
        l.setLastName("Uwase");
        l.setEmail("ann@uni.test");
        l.setDepartment(d);
        l = lecturerRepository.save(l);

        d.setHead(l);                       // one-to-one: department head
        departmentRepository.save(d);

        Course c = new Course();
        c.setCode("CS101");
        c.setTitle("Intro to Programming");
        c.setCredits(3);
        c.setDepartment(d);
        c = courseRepository.save(c);

        l.getCourses().add(c);              // many-to-many: join table
        lecturerRepository.save(l);

        Student s = new Student();
        s.setFirstName("Jean");
        s.setLastName("Mugisha");
        s.setEmail("jean@uni.test");
        s.setRegistrationNumber("REG001");
        s.setDepartment(d);
        s = studentRepository.save(s);

        StudentProfile p = new StudentProfile();   // one-to-one: profile
        p.setDateOfBirth(LocalDate.of(2003, 5, 1));
        p.setGender("Male");
        p.setPhoneNumber("0788000000");
        p.setAddress("Kigali");
        p.setStudent(s);
        p = studentProfileRepository.save(p);

        Registration r = new Registration();       // join entity
        r.setStudent(s);
        r.setCourse(c);
        r.setRegistrationDate(LocalDate.now());
        r.setAcademicYear("2026/2027");
        r.setSemester("Semester 1");
        r.setStatus(RegistrationStatus.APPROVED);
        r.setGrade(78.5);
        r = registrationRepository.save(r);

        assertNotNull(r.getId());
        assertNotNull(p.getId());
        assertEquals(l.getId(), departmentRepository.findById(d.getId()).get().getHead().getId());
        assertEquals(1, lecturerRepository.findById(l.getId()).get().getCourses().size());
        assertEquals(RegistrationStatus.APPROVED, registrationRepository.findById(r.getId()).get().getStatus());
    }
}
