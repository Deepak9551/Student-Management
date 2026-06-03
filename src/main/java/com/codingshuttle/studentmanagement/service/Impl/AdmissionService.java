package com.codingshuttle.studentmanagement.service.Impl;

import com.codingshuttle.studentmanagement.dto.AdmissionDto;
import com.codingshuttle.studentmanagement.entity.AdmissionRecord;
import com.codingshuttle.studentmanagement.entity.Course;
import com.codingshuttle.studentmanagement.entity.Student;
import com.codingshuttle.studentmanagement.exception.ResourceNotFoundException;
import com.codingshuttle.studentmanagement.repository.AdmissionRecordRepository;
import com.codingshuttle.studentmanagement.repository.CourseRepository;
import com.codingshuttle.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {

    private AdmissionRecordRepository admissionRepository;

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

   public AdmissionService(AdmissionRecordRepository admissionRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.admissionRepository = admissionRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public AdmissionDto admission(AdmissionDto admissionDto) {
        Long studentId = admissionDto.getStudentId();
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        AdmissionRecord admissionRecord = AdmissionRecord.builder()
                .student(student)
                .admissionDate(admissionDto.getAdmissionDate())
                .fees(admissionDto.getFees())

                .build();
        admissionRepository.save(admissionRecord);
        return admissionDto;
    }}
