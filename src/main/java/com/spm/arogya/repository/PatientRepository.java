package com.spm.arogya.repository;

import com.spm.arogya.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Patient repository.
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {



}
