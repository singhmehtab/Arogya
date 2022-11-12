package com.spm.arogya.repository;

import com.spm.arogya.model.Appointment;
import com.spm.arogya.model.Counselor;
import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Counselor repository.
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByStatus(int status);
    List<Appointment> findByStatusAndCounsellorRegistrationNumber(int status, String counsellorId);
    List<Appointment> findAllByStatus(Integer status);
    Appointment findFirstById(int id);
}
