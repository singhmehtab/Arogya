package com.spm.arogya.repository;

import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Patient repository.
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    /**
     * Find first by age and phone number and gender patient.
     *
     * @param age         the age
     * @param phoneNumber the phone number
     * @param gender      the gender
     * @return the patient
     */
    Patient findFirstByAgeAndPhoneNumberAndGender(Integer age, String phoneNumber, Gender gender);
    Patient findFirstByEmailAddressAndPassword(String email, String password);

    /**
     * Find first by email address patient.
     *
     * @param emailAddress the email address
     * @return the patient
     */
    Patient findFirstByEmailAddress(String emailAddress);

    List<Patient> findAll();

    void deleteAllByEmailAddress(String emailAddress);

}
