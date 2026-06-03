package com.codingshuttle.studentmanagement.entity;

import com.codingshuttle.studentmanagement.dto.ProfessorDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Professor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String gender;

    @OneToMany(mappedBy = "professor", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)

    private List<Course> courses = new ArrayList<>();

    @ManyToMany(mappedBy = "professors")
    private List<Student> students = new ArrayList<>();

    public ProfessorDto toDto(ModelMapper mapper) {
        return mapper.map(this, ProfessorDto.class);
    }
}
