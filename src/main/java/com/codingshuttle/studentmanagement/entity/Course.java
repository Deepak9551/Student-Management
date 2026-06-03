package com.codingshuttle.studentmanagement.entity;

import com.codingshuttle.studentmanagement.dto.CourseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String code;
    @ManyToOne
    @JoinColumn(name = "professor_id",nullable = true)
    private Professor professor;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;


    public CourseDto toDto(ModelMapper courseMapper) {
        return courseMapper.map(this,CourseDto.class);
    }
}
