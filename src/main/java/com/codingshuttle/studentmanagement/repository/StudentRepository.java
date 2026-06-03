package com.codingshuttle.studentmanagement.repository;

import com.codingshuttle.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}