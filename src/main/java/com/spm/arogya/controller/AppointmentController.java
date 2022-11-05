package com.spm.arogya.controller;

import com.spm.arogya.constants.UriConstants;
import com.spm.arogya.dto.AppointmentRequestDto;
import com.spm.arogya.dto.ResponseDto;
import com.spm.arogya.exception.AppointmentRegistrationException;
import com.spm.arogya.model.Appointment;
import com.spm.arogya.service.IAppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(UriConstants.BASE_URL)
public class AppointmentController {

    private final IAppointmentService iAppointmentService;

    @Autowired
    public AppointmentController(IAppointmentService iAppointmentService){
        this.iAppointmentService = iAppointmentService;
    }

    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_APPOINTMENT)
    public ResponseDto<String> registerAppointment(@RequestBody AppointmentRequestDto appointmentRegistrationRequestDto){
        try {
            iAppointmentService.saveAppointment(appointmentRegistrationRequestDto);
        } catch (AppointmentRegistrationException e) {
            log.error("Appointment Failed for email address : " + appointmentRegistrationRequestDto.getPatient_email());
            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
        }
        return new ResponseDto("Appointment Registered Successfully");
    }

    @RequestMapping(method = RequestMethod.GET, value = UriConstants.GET_APPOINTMENTS)
    public ResponseDto<List<Appointment>> getAppointments(@RequestParam(name = "email_address")String emailAddress){
        try {
            return new ResponseDto<>(iAppointmentService.getAppointments(emailAddress));
        }
        catch (AppointmentRegistrationException e){
            log.error("Appointment Get for email address : " + emailAddress);
            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
        }
    }

}
