package com.codingshuttle.studentmanagement.service;

import com.codingshuttle.studentmanagement.dto.ProfessorDto;

import java.util.List;

public interface ProfessorService {

    List<ProfessorDto> getAllProfessors();
    ProfessorDto createProfessor(ProfessorDto professorDto);
    ProfessorDto getProfessorById(Long id);
    ProfessorDto updateProfessor(Long id, ProfessorDto professorDto);
    void deleteProfessor(Long id);
}
