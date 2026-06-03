package com.codingshuttle.studentmanagement.controller;

import com.codingshuttle.studentmanagement.dto.StudentDto;
import com.codingshuttle.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents(@RequestParam(value = "pageNo", defaultValue = "0") String pageNo,
                                                           @RequestParam(value = "size", defaultValue = "10") String size,
                                                           @RequestParam(value = "sort", defaultValue = "id") String sort) {
        List<StudentDto> students = studentService.getAllStudents(pageNo, size, sort);
        return ResponseEntity.ok(students);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

        StudentDto createdStudent = studentService.createStudent(studentDto);

        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto student = studentService.getStudentById(id);
        return student == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        StudentDto updatedStudent = studentService.updateStudent(id, updates);
        return updatedStudent == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
