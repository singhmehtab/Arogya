//package com.spm.arogya.controller;
//
//import com.spm.arogya.constants.UriConstants;
//import com.spm.arogya.dto.Patient.PatientRegistrationRequestDto;
//import com.spm.arogya.dto.Patient.PatientRegistrationResponseDto;
//import com.spm.arogya.dto.ResponseDto;
//import com.spm.arogya.exception.PatientRegistrationException;
//import com.spm.arogya.model.Counselor;
//import com.spm.arogya.model.Patient;
//import com.spm.arogya.service.IPatientService;
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
//import java.util.List;
//
///**
// * The type Patient controller.
// */
//@RestController
//@CrossOrigin
//@Slf4j
//@RequestMapping(UriConstants.BASE_URL)
//public class PatientController {
//
//    private final IPatientService iPatientService;
//
//    /**
//     * Instantiates a new Patient controller.
//     *
//     * @param iPatientService the patient service
//     */
//    @Autowired
//    public PatientController(IPatientService iPatientService){
//        this.iPatientService = iPatientService;
//    }
//
//    /**
//     * Register patient response dto.
//     *
//     * @param patientRegistrationRequestDto the patient registration request dto
//     * @return the response dto
//     */
//    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_PATIENT)
//    public ResponseDto<PatientRegistrationResponseDto> registerPatient(@RequestBody PatientRegistrationRequestDto patientRegistrationRequestDto){
//        Patient patient;
//        try{
//            patient = iPatientService.savePatient(patientRegistrationRequestDto);
//        } catch (PatientRegistrationException e) {
//            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
//        }
//        catch (Exception e){
//            log.error("Error occurred :: " , e);
//            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
//        }
//        return new ResponseDto<>(
//                PatientRegistrationResponseDto.builder()
//                        .id(patient.getId())
//                        .firstName(patient.getFirstName())
//                        .middleName(patient.getMiddleName())
//                        .lastName(patient.getLastName())
//                        .age(patient.getAge())
//                        .emailAddress(patient.getEmailAddress())
//                        .phoneNumber(patient.getPhoneNumber())
//                        .gender(patient.getGender().getGenderDisplay())
//                        .build()
//        );
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = UriConstants.GET_PATIENT_LIST)
//    public ResponseDto<List<Patient>> getPatient(){
//
//        List<Patient> list;
//        try{
//            list = iPatientService.getPatientsList();
//        }
//        catch (Exception e){
//            log.error("Error occurred :: " , e);
//            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
//        }
//        return new ResponseDto<>(list);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = UriConstants.DELETE_PATIENT)
//    private ResponseDto<String> deletePatient(@RequestParam(name = "email_address")String emailAddress){
//        try{
//            iPatientService.deletePatient(emailAddress);
//            return new ResponseDto<>("Record Deleted Successfully");
//        }
//        catch (Exception e){
//            log.error("Error occurred :: " , e);
//            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
//        }
//    }
//
//}
