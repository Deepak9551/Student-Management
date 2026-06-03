package com.codingshuttle.studentmanagement.service;

import com.codingshuttle.studentmanagement.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {



    List<StudentDto> getAllStudents(String page, String size, String sort);

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);

    StudentDto updateStudent(Long id, Map<String, Object> updates);

    boolean deleteStudent(Long id);
}
