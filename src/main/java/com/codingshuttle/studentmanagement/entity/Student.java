package com.codingshuttle.studentmanagement.entity;

import com.codingshuttle.studentmanagement.dto.StudentDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Entity

@ToString(exclude = {"courses", "professors"} )
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;
    private String phone;
    private String gender;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @Fetch(FetchMode.JOIN)
    private List<Course> courses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_professor", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    @Fetch(FetchMode.JOIN)
    private List<Professor> professors = new ArrayList<>();



    public StudentDto toDto( ModelMapper mapper) {
        return mapper.map(this, StudentDto.class);
    }

}
