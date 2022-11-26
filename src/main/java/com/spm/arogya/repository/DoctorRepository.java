package com.spm.arogya.repository;

import com.spm.arogya.model.Counselor;
import com.spm.arogya.model.Doctor;
import com.spm.arogya.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

/**
 * The interface Counselor repository.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    /**
     * Find first by age and phone number and gender patient.
     *
     * @param age         the age
     * @param phoneNumber the phone number
     * @param gender      the gender
     * @return the patient
     */
    Doctor findFirstByAgeAndPhoneNumberAndGender(Integer age, String phoneNumber, Gender gender);
    Doctor findFirstByEmailAddressAndPassword(String email, String password);

    /**
     * Find first by email address patient.
     *
     * @param emailAddress the email address
     * @return the patient
     */
    Doctor findFirstByEmailAddress(String emailAddress);

    List<Doctor> findAll();

}
