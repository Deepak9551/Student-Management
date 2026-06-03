package com.codingshuttle.studentmanagement.service.Impl;

import com.codingshuttle.studentmanagement.dto.ProfessorDto;
import com.codingshuttle.studentmanagement.entity.Course;
import com.codingshuttle.studentmanagement.entity.Professor;
import com.codingshuttle.studentmanagement.exception.ResourceNotFoundException;
import com.codingshuttle.studentmanagement.repository.CourseRepository;
import com.codingshuttle.studentmanagement.repository.ProfessorRepository;
import com.codingshuttle.studentmanagement.service.ProfessorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;

    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper professorMapper;


    public ProfessorServiceImpl(ProfessorRepository professorRepository , CourseRepository courseRepository){
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<ProfessorDto> getAllProfessors() {
        return professorRepository.findAll()
                .stream()
                .map(professor -> professor.toDto(professorMapper))
                .toList();

    }

    @Override
    public ProfessorDto createProfessor(ProfessorDto professorDto) {
        List<Long> coursesId = professorDto.getCourseIdsToAssign();
        List<Course> courses = courseRepository.findAllById(coursesId);
        Professor professor = professorMapper.map(professorDto, Professor.class);
        professor.setCourses(courses);
        for(Course course : courses){
            course.setProfessor(professor);
        }
        professor = professorRepository.save(professor);
        return professor.toDto(professorMapper);
    }

    @Override
    public ProfessorDto getProfessorById(Long id) {
        isProfessorExists(id);
        return professorRepository.findById(id).get().toDto(professorMapper);
    }

    @Override
    public ProfessorDto updateProfessor(Long id, ProfessorDto professorDto) {
       isProfessorExists(id);
       Professor professor = professorRepository.findById(id).get();
       professorMapper.map(professorDto, professor);
       professor = professorRepository.save(professor);
       return professor.toDto(professorMapper);
    }

    @Override
    public void deleteProfessor(Long id) {
    isProfessorExists(id);
    professorRepository.deleteById(id);
    }

    private void isProfessorExists(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Professor not found with id: " + id);
        }
    }
}
