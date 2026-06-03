package com.codingshuttle.studentmanagement.controller;

import com.codingshuttle.studentmanagement.dto.CourseDto;
import com.codingshuttle.studentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @RequestMapping("/all")
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses("0", "courseName"));
    }

    @RequestMapping("/add")
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok(courseService.addCourse(courseDto));
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id,@RequestBody CourseDto courseDto){
        return ResponseEntity.ok(courseService.updateCourse(id, courseDto));
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }
}
