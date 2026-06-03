package com.codingshuttle.studentmanagement.dto;

import com.codingshuttle.studentmanagement.entity.Course;
import com.codingshuttle.studentmanagement.entity.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class StudentDto {
    String name;
    String email;
    String address;
    String phone;
    String gender;
    List<Long> coursesIds;

    List<Long> professorsIds;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<CourseDto> courses;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<ProfessorDto> professors;


    public Student toEntity(ModelMapper mapper) {

        return mapper.map(this, Student.class);
    }

}