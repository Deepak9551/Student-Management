package com.codingshuttle.studentmanagement.repository;

import com.codingshuttle.studentmanagement.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}