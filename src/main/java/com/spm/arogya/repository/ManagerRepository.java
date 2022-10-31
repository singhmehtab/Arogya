package com.spm.arogya.repository;

import com.spm.arogya.model.Manager;
import com.spm.arogya.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface Manager repository.
 */
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    /**
     * Find first by age and phone number and gender patient.
     *
     * @param age         the age
     * @param phoneNumber the phone number
     * @param gender      the gender
     * @return the patient
     */
    Manager findFirstByAgeAndPhoneNumberAndGender(Integer age, String phoneNumber, Gender gender);

    /**
     * Find first by email address and password manager.
     *
     * @param email    the email
     * @param password the password
     * @return the manager
     */
    Manager findFirstByEmailAddressAndPassword(String email, String password);

    /**
     * Find first by email address patient.
     *
     * @param emailAddress the email address
     * @return the patient
     */
    Manager findFirstByEmailAddress(String emailAddress);

}
