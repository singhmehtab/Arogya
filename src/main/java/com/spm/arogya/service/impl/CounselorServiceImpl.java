package com.spm.arogya.service.impl;

import com.spm.arogya.dto.Counsellor.CounselorHomepageResponseDto;
import com.spm.arogya.dto.CounselorRegistrationRequestDto;
import com.spm.arogya.dto.GetAppointmentResponseDto;
import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.CounselorHomepageException;
import com.spm.arogya.exception.CounselorRegistrationException;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.model.Appointment;
import com.spm.arogya.model.Counselor;
import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import com.spm.arogya.repository.AppointmentRepository;
import com.spm.arogya.repository.CounselorRepository;
import com.spm.arogya.service.IAppointmentService;
import com.spm.arogya.service.ICounselorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Counselor service.
 */
@Service
public class CounselorServiceImpl   extends UserLogin implements ICounselorService {

    private CounselorRepository counselorRepository;
    private AppointmentRepository appointmentRepository;
    /**
     * Instantiates a new Patient service.
     *
     * @param counselorRepository the counselor repository
     */
    @Autowired
    public CounselorServiceImpl(CounselorRepository counselorRepository, AppointmentRepository appointmentRepository){
        this.counselorRepository = counselorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Counselor saveCounselor(CounselorRegistrationRequestDto counselorRegistrationRequestDto) throws CounselorRegistrationException {

        if (Objects.isNull(counselorRegistrationRequestDto.getEmailAddress())) throw new CounselorRegistrationException("Email Address is required");
        else if(Objects.isNull(counselorRegistrationRequestDto.getPassword())) throw new CounselorRegistrationException("Password is required");

        if(Objects.nonNull(counselorRepository.findFirstByEmailAddress(counselorRegistrationRequestDto.getEmailAddress()))){
            throw new CounselorRegistrationException("Counselor with same email address already exists");
        }

        Counselor counselor = Counselor.builder()
                .firstName(counselorRegistrationRequestDto.getFirstName())
                .middleName(counselorRegistrationRequestDto.getMiddleName())
                .lastName(counselorRegistrationRequestDto.getLastName())
                .age(counselorRegistrationRequestDto.getAge())
                .emailAddress(counselorRegistrationRequestDto.getEmailAddress())
                .gender(Gender.getGender(counselorRegistrationRequestDto.getGender()))
                .phoneNumber(counselorRegistrationRequestDto.getPhoneNumber())
                .password(counselorRegistrationRequestDto.getPassword())
                .registrationNumber(counselorRegistrationRequestDto.getRegistrationNumber())
                .build();
        counselorRepository.save(counselor);
        return counselor;
    }

    @Override
    public CounselorHomepageResponseDto getHomePage(String counsellorId) throws CounselorHomepageException{
        try {
            GetAppointmentResponseDto pendingAppointments = null;
            GetAppointmentResponseDto scheduledAppointments = null;
            GetAppointmentResponseDto cancelledAppointments = null;
            pendingAppointments=transformAppointmentToAppointmentResponseDto(appointmentRepository.findByStatus(0));
            if(counsellorId!=null && !counsellorId.isEmpty()){
                    scheduledAppointments = transformAppointmentToAppointmentResponseDto(appointmentRepository.findByStatusAndCounsellorRegistrationNumber(2, counsellorId));
                    cancelledAppointments =  transformAppointmentToAppointmentResponseDto(appointmentRepository.findByStatusAndCounsellorRegistrationNumber(1, counsellorId));
            }
            return CounselorHomepageResponseDto.builder()
                    .pendingAppointments(pendingAppointments)
                    .scheduledAppointments(scheduledAppointments)
                    .cancelledAppointments(cancelledAppointments)
                    .build();
        }catch (Exception ex){
            throw new CounselorHomepageException("Exception occurred."+ex.getMessage());
        }


    }

    @Override
    public List<Counselor> getCounselorsList() {
        return counselorRepository.findAll();
    }

    private GetAppointmentResponseDto transformAppointmentToAppointmentResponseDto(List<Appointment> ls){
        List<GetAppointmentResponseDto.AppointmentDetails> transformedLs=new ArrayList<>();
        ls.forEach(appointment -> {

            GetAppointmentResponseDto.AppointmentDetails details = GetAppointmentResponseDto.AppointmentDetails.builder()
                    .appointmentStartTime(appointment.getAppointmentStartTime())
                    .appointmentEndTime(appointment.getAppointmentEndTime())
                    .counsellorRegistrationNumber(appointment.getCounsellorRegistrationNumber())
                    .doctorRegistrationNumber(appointment.getDoctorRegistrationNumber())
                    .patient(appointment.getPatient())
                    .questions(appointment.getQuestions())
                    .selfAssessment(true).build();
            transformedLs.add(details);
        });
        return GetAppointmentResponseDto.builder().appointmentDetails(transformedLs).selfAssessment(true).build();
    }
    public  LoginResponse getLoginDetails(String email, String password) throws LoginException{
        LoginResponse loginResponse=new LoginResponse();
        Counselor counselor=counselorRepository.findFirstByEmailAddressAndPassword(email, password);
        if(counselor==null){
            loginResponse.setLogged(false);
            return loginResponse;
        }
        loginResponse.setId(counselor.getId());
        loginResponse.setLogged(true);
        loginResponse.setAge(counselor.getAge());
        loginResponse.setGender(counselor.getGender());
        loginResponse.setFirstName(counselor.getFirstName());
        loginResponse.setMiddleName(counselor.getMiddleName());
        loginResponse.setLastName(counselor.getLastName());
        loginResponse.setPhoneNumber(counselor.getPhoneNumber());
        loginResponse.setEmailAddress(counselor.getEmailAddress());
        return loginResponse;
    }


}
