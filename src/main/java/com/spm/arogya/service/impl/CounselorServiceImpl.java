package com.spm.arogya.service.impl;

import com.spm.arogya.dto.CounselorRegistrationRequestDto;
import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.CounselorRegistrationException;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.model.Counselor;
import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import com.spm.arogya.repository.CounselorRepository;
import com.spm.arogya.service.ICounselorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The type Counselor service.
 */
@Service
public class CounselorServiceImpl   extends UserLogin implements ICounselorService {

    private CounselorRepository counselorRepository;

    /**
     * Instantiates a new Patient service.
     *
     * @param counselorRepository the counselor repository
     */
    @Autowired
    public CounselorServiceImpl(CounselorRepository counselorRepository){
        this.counselorRepository = counselorRepository;
    }

    @Override
    public Counselor saveCounselor(CounselorRegistrationRequestDto counselorRegistrationRequestDto) throws CounselorRegistrationException {

        if(Objects.isNull(counselorRegistrationRequestDto.getAge())) throw new CounselorRegistrationException("Age is Required");
        else if(Objects.isNull(counselorRegistrationRequestDto.getGender())) throw new CounselorRegistrationException("Gender is Required");
        else if(Objects.isNull(counselorRegistrationRequestDto.getLastName())) throw new CounselorRegistrationException("Last name is Required");
        else if (Objects.isNull(counselorRegistrationRequestDto.getEmailAddress())) throw new CounselorRegistrationException("Email Address is required");
        else if(Objects.isNull(counselorRegistrationRequestDto.getPassword())) throw new CounselorRegistrationException("Password is required");

        if(Objects.nonNull(counselorRepository.findFirstByAgeAndPhoneNumberAndGender(counselorRegistrationRequestDto.getAge(), counselorRegistrationRequestDto.getPhoneNumber(), Gender.getGender(counselorRegistrationRequestDto.getGender())))){
            throw new CounselorRegistrationException("Counselor with same age, phone number and gender already exists");
        }
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
    public  LoginResponse getLoginDetails(String email, String password) throws LoginException{
        LoginResponse loginResponse=new LoginResponse();
        Counselor counselor=counselorRepository.findFirstByEmailAddressAndPassword(email, password);
        if(counselor==null){
            loginResponse.setLogged(false);
            return loginResponse;
        }
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
