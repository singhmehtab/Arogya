package com.spm.arogya.repository;

import com.spm.arogya.model.Counselor;
import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Counselor repository.
 */
public interface CounselorRepository extends JpaRepository<Counselor, Integer> {

    /**
     * Find first by age and phone number and gender patient.
     *
     * @param age         the age
     * @param phoneNumber the phone number
     * @param gender      the gender
     * @return the patient
     */
    Counselor findFirstByAgeAndPhoneNumberAndGender(Integer age, String phoneNumber, Gender gender);
    Counselor findFirstByEmailAddressAndPassword(String email, String password);

    /**
     * Find first by email address patient.
     *
     * @param emailAddress the email address
     * @return the patient
     */
    Counselor findFirstByEmailAddress(String emailAddress);

}
