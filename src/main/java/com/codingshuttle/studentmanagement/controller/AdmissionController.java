package com.codingshuttle.studentmanagement.controller;

import com.codingshuttle.studentmanagement.dto.AdmissionDto;
import com.codingshuttle.studentmanagement.service.Impl.AdmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admissions")
public class AdmissionController
{
    private AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping
    public ResponseEntity<AdmissionDto> createAdmission(@RequestBody AdmissionDto admissionDto) {
        AdmissionDto createdAdmission = admissionService.admission(admissionDto);
        return ResponseEntity.ok(createdAdmission);
    }
}
