package com.codingshuttle.studentmanagement.repository;

import com.codingshuttle.studentmanagement.entity.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {
}