package com.spm.arogya.service.impl;

import com.spm.arogya.dto.CounselorRegistrationRequestDto;
import com.spm.arogya.dto.DoctorRegistrationRequestDto;
import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.CounselorRegistrationException;
import com.spm.arogya.exception.DoctorRegistrationException;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.model.Appointment;
import com.spm.arogya.model.Counselor;
import com.spm.arogya.model.Doctor;
import com.spm.arogya.model.enums.Gender;
import com.spm.arogya.repository.AppointmentRepository;
import com.spm.arogya.repository.CounselorRepository;
import com.spm.arogya.repository.DoctorRepository;
import com.spm.arogya.service.ICounselorService;
import com.spm.arogya.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * The type Counselor service.
 */
@Service
public class DoctorServiceImpl extends UserLogin implements IDoctorService {

    private DoctorRepository doctorRepository;

    private AppointmentRepository appointmentRepository;
    /**
     * Instantiates a new Patient service.
     *
     * @param doctorRepository the counselor repository
     */
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository){
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Doctor saveDoctor(DoctorRegistrationRequestDto doctorRegistrationRequestDto) throws DoctorRegistrationException {

        if (Objects.isNull(doctorRegistrationRequestDto.getEmailAddress())) throw new DoctorRegistrationException("Email Address is required");
        else if(Objects.isNull(doctorRegistrationRequestDto.getPassword())) throw new DoctorRegistrationException("Password is required");

        if(Objects.nonNull(doctorRepository.findFirstByEmailAddress(doctorRegistrationRequestDto.getEmailAddress()))){
            throw new DoctorRegistrationException("Doctor with same email address already exists");
        }

        Doctor doctor = Doctor.builder()
                .firstName(doctorRegistrationRequestDto.getFirstName())
                .middleName(doctorRegistrationRequestDto.getMiddleName())
                .lastName(doctorRegistrationRequestDto.getLastName())
                .age(doctorRegistrationRequestDto.getAge())
                .emailAddress(doctorRegistrationRequestDto.getEmailAddress())
                .gender(Gender.getGender(doctorRegistrationRequestDto.getGender()))
                .phoneNumber(doctorRegistrationRequestDto.getPhoneNumber())
                .password(doctorRegistrationRequestDto.getPassword())
                .registrationNumber(doctorRegistrationRequestDto.getRegistrationNumber())
                .build();
        doctorRepository.save(doctor);
        return doctor;
    }
    public  LoginResponse getLoginDetails(String email, String password) throws LoginException{
        LoginResponse loginResponse=new LoginResponse();
        Doctor doctor=doctorRepository.findFirstByEmailAddressAndPassword(email, password);
        if(doctor==null){
            loginResponse.setLogged(false);
            return loginResponse;
        }
        loginResponse.setId(doctor.getId());
        loginResponse.setLogged(true);
        loginResponse.setAge(doctor.getAge());
        loginResponse.setGender(doctor.getGender());
        loginResponse.setFirstName(doctor.getFirstName());
        loginResponse.setMiddleName(doctor.getMiddleName());
        loginResponse.setLastName(doctor.getLastName());
        loginResponse.setPhoneNumber(doctor.getPhoneNumber());
        loginResponse.setEmailAddress(doctor.getEmailAddress());
        return loginResponse;
    }

    @Override
    public List<Doctor> getDoctorsList() {
        return doctorRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteDoctor(String emailAddress) {
        Doctor doctor = doctorRepository.findFirstByEmailAddress(emailAddress);
        doctorRepository.deleteAllByEmailAddress(emailAddress);
        List<Appointment> appointmentList = appointmentRepository.findAllByDoctorRegistrationNumber(doctor.getId().toString());
        appointmentList.forEach(appointment -> {appointment.setDoctorRegistrationNumber(null);appointment.setStatus(0);appointment.setAppointmentStartTime(null);appointment.setCounsellorRegistrationNumber(null);});
        appointmentRepository.saveAll(appointmentList);
    }

    @Override
    public Doctor findById(Integer id) {
        return doctorRepository.findFirstById(id);
    }


}
