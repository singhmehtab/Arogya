package com.spm.arogya.service.impl;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.dto.ManagerRegistrationRequestDto;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.exception.ManagerRegistrationException;
import com.spm.arogya.model.Manager;
import com.spm.arogya.model.enums.Gender;
import com.spm.arogya.repository.ManagerRepository;
import com.spm.arogya.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The type Patient service.
 */
@Service
public class ManagerServiceImpl extends  UserLogin implements IManagerService {

    private ManagerRepository managerRepository;

    /**
     * Instantiates a new Patient service.
     *
     * @param managerRepository the patient repository
     */
    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager saveManager(ManagerRegistrationRequestDto managerRegistrationRequestDto) throws ManagerRegistrationException {

        if(Objects.nonNull(managerRepository.findFirstByEmailAddress(managerRegistrationRequestDto.getEmailAddress()))){
            throw new ManagerRegistrationException("Manager with same email address already exists");
        }

        Manager manager = Manager.builder()
                .firstName(managerRegistrationRequestDto.getFirstName())
                .middleName(managerRegistrationRequestDto.getMiddleName())
                .lastName(managerRegistrationRequestDto.getLastName())
                .age(managerRegistrationRequestDto.getAge())
                .emailAddress(managerRegistrationRequestDto.getEmailAddress())
                .gender(Gender.getGender(managerRegistrationRequestDto.getGender()))
                .phoneNumber(managerRegistrationRequestDto.getPhoneNumber())
                .password(managerRegistrationRequestDto.getPassword())
                .build();
        managerRepository.save(manager);
        return manager;
    }

    public  LoginResponse getLoginDetails(String email, String password) throws LoginException {
        LoginResponse loginResponse=new LoginResponse();
        Manager manager= managerRepository.findFirstByEmailAddressAndPassword(email, password);
        if(manager==null){
            loginResponse.setLogged(false);
            return loginResponse;
        }
        loginResponse.setLogged(true);
        loginResponse.setAge(manager.getAge());
        loginResponse.setGender(manager.getGender());
        loginResponse.setFirstName(manager.getFirstName());
        loginResponse.setMiddleName(manager.getMiddleName());
        loginResponse.setLastName(manager.getLastName());
        loginResponse.setPhoneNumber(manager.getPhoneNumber());
        loginResponse.setEmailAddress(manager.getEmailAddress());
        return loginResponse;
    }


}
