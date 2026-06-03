package com.codingshuttle.studentmanagement.service;


import com.codingshuttle.studentmanagement.dto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto addCourse(CourseDto courseDto);

    CourseDto updateCourse(Long id,CourseDto courseDto);

    void deleteCourse(Long id);

    CourseDto getCourseById(Long id);

    List<CourseDto> getAllCourses(String pageNo,String sort);
}
