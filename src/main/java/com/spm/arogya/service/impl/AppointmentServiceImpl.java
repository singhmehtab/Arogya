package com.spm.arogya.service.impl;

import com.spm.arogya.dto.AppointmentRequestDto;
import com.spm.arogya.dto.GetAppointmentResponseDto;
import com.spm.arogya.exception.AppointmentRegistrationException;
import com.spm.arogya.model.Appointment;
import com.spm.arogya.model.Patient;
import com.spm.arogya.repository.AppointmentRepository;
import com.spm.arogya.service.IAppointmentService;
import com.spm.arogya.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Counselor service.
 */
@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private AppointmentRepository appointmentRepository;

    private IPatientService patientService;

    /**
     * Instantiates a new Patient service.
     *
     * @param appointmentRepository the counselor repository
     */
    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, IPatientService iPatientService){
        this.appointmentRepository = appointmentRepository;
        this.patientService = iPatientService;
    }

    @Override
    public Appointment saveAppointment(AppointmentRequestDto appointmentRegistrationRequestDto) throws AppointmentRegistrationException {
        Patient patient = patientService.findByEmailId(appointmentRegistrationRequestDto.getPatient_email());
        if(Objects.isNull(patient)) throw new AppointmentRegistrationException("Please provide a valid email address");
            Appointment appointment = Appointment.builder()
                .patient(patient)
                .questions(appointmentRegistrationRequestDto.getQuestions())
                .status(0)
                .build();
            appointmentRepository.save(appointment);
            return appointment;
    }

    @Override
    public List<GetAppointmentResponseDto> getAppointments(String emailAddress) throws AppointmentRegistrationException {
        List<Appointment> appointmentList = null;
        if(Objects.isNull(emailAddress) || emailAddress.isEmpty()){
            appointmentList = appointmentRepository.findAllByStatus(0);
        }
        else {
            Patient patient = patientService.findByEmailId(emailAddress);
            appointmentList = appointmentRepository.findByPatient(patient);
        }
        List<GetAppointmentResponseDto> getAppointmentResponseDtos = new ArrayList<>();
        appointmentList.forEach(appointment -> {
            getAppointmentResponseDtos.add(GetAppointmentResponseDto.builder()
                            .appointmentStartTime(appointment.getAppointmentStartTime())
                            .appointmentEndTime(appointment.getAppointmentEndTime())
                            .counsellorRegistrationNumber(appointment.getCounsellorRegistrationNumber())
                            .doctorRegistrationNumber(appointment.getDoctorRegistrationNumber())
                            .patient(appointment.getPatient())
                            .questions(appointment.getQuestions())
                            .selfAssessment(true)
                    .build());
        });
       return getAppointmentResponseDtos;
    }
    @Override
    public List<Appointment> getAppointmentsForCounsellor(){
        return appointmentRepository.findByStatus(0);
    }




}
