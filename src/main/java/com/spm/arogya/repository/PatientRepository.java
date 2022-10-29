package com.spm.arogya.repository;

import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Patient repository.
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findFirstByAgeAndPhoneNumberAndGender(Integer age, String phoneNumber, Gender gender);
    Patient findFirstByEmailAndPassword(String email, String password);

}
