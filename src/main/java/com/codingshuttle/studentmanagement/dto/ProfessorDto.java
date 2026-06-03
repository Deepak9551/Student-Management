package com.codingshuttle.studentmanagement.dto;

import com.codingshuttle.studentmanagement.entity.Professor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter

public class ProfessorDto {


    String name;
    String email;
    String address;
    String phone;
    String gender;
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Long> courseIdsToAssign;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<CourseDto> courses;

    public ProfessorDto toEntity(ModelMapper mapper) {
        return mapper.map(this, ProfessorDto.class);
    }
}