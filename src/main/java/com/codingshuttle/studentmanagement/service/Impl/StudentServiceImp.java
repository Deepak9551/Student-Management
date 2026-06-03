package com.codingshuttle.studentmanagement.service.Impl;

import com.codingshuttle.studentmanagement.dto.StudentDto;
import com.codingshuttle.studentmanagement.entity.Course;
import com.codingshuttle.studentmanagement.entity.Professor;
import com.codingshuttle.studentmanagement.entity.Student;
import com.codingshuttle.studentmanagement.exception.ResourceNotFoundException;
import com.codingshuttle.studentmanagement.repository.CourseRepository;
import com.codingshuttle.studentmanagement.repository.ProfessorRepository;
import com.codingshuttle.studentmanagement.repository.StudentRepository;
import com.codingshuttle.studentmanagement.service.StudentService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImp implements StudentService {

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    private ProfessorRepository professorRepository;

    @Autowired
  private ModelMapper studentMapper;

    public StudentServiceImp(StudentRepository studentRepository , CourseRepository courseRepository , ProfessorRepository professorRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public List<StudentDto> getAllStudents(String pageNo, String size, String sort) {
        Page<Student> page = studentRepository.findAll(PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(size), Sort.by(sort)));
     return    page.getContent().stream().map(student -> student.toDto(studentMapper)).toList();
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        System.out.println("DTO"+studentDto);
        List<Course> courses = courseRepository.findAllById(studentDto.getCoursesIds());
        List<Professor> professors = professorRepository.findAllById(studentDto.getProfessorsIds());
        Student studentEntity = studentDto.toEntity(studentMapper);
        studentEntity.setCourses(courses);
        studentEntity.setProfessors(professors);

        System.out.println("Entity"+studentEntity);
       return studentRepository.save(studentEntity).toDto(studentMapper);

    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentRepository.findById(id).map(student -> student.toDto(studentMapper)).orElse(null);
    }

    @Override
    public StudentDto updateStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    updates.forEach((fieldName,value)->{
        Field field = ReflectionUtils.findField(Student.class, fieldName);
        ReflectionUtils.setField(field, student, value);
    });
 return   studentRepository.save(student).toDto(studentMapper);
    }

    @Override
    public boolean deleteStudent(Long id) {

        studentRepository.findById(id).ifPresent(student -> studentRepository.delete(student));
        return true;
    }


}
