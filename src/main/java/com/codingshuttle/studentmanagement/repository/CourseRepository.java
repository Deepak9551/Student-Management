package com.codingshuttle.studentmanagement.repository;

import com.codingshuttle.studentmanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}