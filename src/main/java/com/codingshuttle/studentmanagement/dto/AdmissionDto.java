package com.codingshuttle.studentmanagement.dto;

import com.codingshuttle.studentmanagement.entity.Course;
import com.codingshuttle.studentmanagement.entity.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder

@AllArgsConstructor
@NoArgsConstructor
public class AdmissionDto {

    private Long studentId;
    private LocalDate admissionDate;
    private Double fees;
 }
