package com.codingshuttle.studentmanagement.dto;

import com.codingshuttle.studentmanagement.entity.Course;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class CourseDto {
    String name;
    String description;
    String code;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long professorId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<Long> studentId;

    public Course toDto(ModelMapper courseMapper) {
        return courseMapper.map(this,Course.class);
    }
}