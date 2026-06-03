package com.codingshuttle.studentmanagement.service.Impl;

import com.codingshuttle.studentmanagement.dto.CourseDto;
import com.codingshuttle.studentmanagement.entity.Course;
import com.codingshuttle.studentmanagement.exception.ResourceNotFoundException;
import com.codingshuttle.studentmanagement.repository.CourseRepository;
import com.codingshuttle.studentmanagement.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
@Autowired
    private ModelMapper courseMapper;

    private int PAGE_SIZE = 10;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        Course course = courseMapper.map(courseDto, Course.class);
        Course savedCourse = courseRepository.save(course);
        return savedCourse.toDto(courseMapper);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        isCourseExists(id);
        Course course = courseRepository.findById(id).get();
        if (course != null) {
            courseMapper.map(courseDto, course);
            Course savedCourse = courseRepository.save(course);
            return savedCourse.toDto(courseMapper);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
    isCourseExists(id);
    courseRepository.deleteById(id);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        isCourseExists(id);
        return courseRepository.findById(id).get().toDto(courseMapper);
    }

    @Override
    public List<CourseDto> getAllCourses(String pageNo, String sort) {
        var pageRequest = PageRequest.of(Integer.parseInt(pageNo),PAGE_SIZE,Sort.by(Sort.Direction.ASC, sort));
    return courseRepository.findAll(pageRequest).stream().map(course -> course.toDto(courseMapper)).toList();
    }

    public void isCourseExists(Long id) {
        if (courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with id: " + id);
        }
    }
}
