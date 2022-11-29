//package com.spm.arogya.controller;
//
//import com.spm.arogya.constants.UriConstants;
//import com.spm.arogya.dto.*;
//import com.spm.arogya.exception.AppointmentRegistrationException;
//import com.spm.arogya.model.Appointment;
//import com.spm.arogya.service.IAppointmentService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collections;
//
//@RestController
//@CrossOrigin
//@Slf4j
//@RequestMapping(UriConstants.BASE_URL)
//public class AppointmentController {
//
//    private final IAppointmentService iAppointmentService;
//
//    @Autowired
//    public AppointmentController(IAppointmentService iAppointmentService){
//        this.iAppointmentService = iAppointmentService;
//    }
//
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_APPOINTMENT)
//    public ResponseDto<String> registerAppointment(@RequestBody AppointmentRequestDto appointmentRegistrationRequestDto){
//        try {
//            iAppointmentService.saveAppointment(appointmentRegistrationRequestDto);
//        } catch (AppointmentRegistrationException e) {
//            log.error("Appointment Failed for email address : " + appointmentRegistrationRequestDto.getPatient_email());
//            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
//        }
//        return new ResponseDto("Appointment Registered Successfully");
//    }
//
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.GET, value = UriConstants.GET_APPOINTMENTS)
//    public ResponseDto<GetAppointmentResponseDto> getAppointments(@RequestParam(name = "email_address", required = false)String emailAddress){
//        try {
//            return new ResponseDto<>(iAppointmentService.getAppointments(emailAddress));
//        }
//        catch (AppointmentRegistrationException e){
//            log.error("Appointment Get for email address : " + emailAddress);
//            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
//        }
//    }
//    @CrossOrigin
//    @RequestMapping(method = RequestMethod.PUT, value = UriConstants.MODIFY_APPOINTMENT)
//    public ResponseDto<String> modifyAppointment(@RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
//        try {
//            AppointmentUpdateResponse appointmentUpdateResponse = iAppointmentService.modifyAppointment(appointmentUpdateRequest);
//            return new ResponseDto<>(appointmentUpdateResponse.getMessage());
//        }
//        catch (Exception e){
//            log.error("Modify Appointment failed for :" + appointmentUpdateRequest.toString());
//            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
//        }
//    }
//
//}
