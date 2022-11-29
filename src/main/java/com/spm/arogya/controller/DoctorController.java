//package com.spm.arogya.controller;
//
//import com.spm.arogya.constants.UriConstants;
//import com.spm.arogya.dto.DoctorRegistrationRequestDto;
//import com.spm.arogya.dto.DoctorRegistrationResponseDto;
//import com.spm.arogya.dto.ResponseDto;
//import com.spm.arogya.exception.DoctorRegistrationException;
//import com.spm.arogya.model.Doctor;
//import com.spm.arogya.service.IDoctorService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.print.Doc;
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
//public class DoctorController {
//
//    private final IDoctorService iDoctorService;
//
//    /**
//     * Instantiates a new Patient controller.
//     *
//     * @param iDoctorService the patient service
//     */
//    @Autowired
//    public DoctorController(IDoctorService iDoctorService){
//        this.iDoctorService = iDoctorService;
//    }
//
//    /**
//     * Register patient response dto.
//     *
//     * @param doctorRegistrationRequestDto the patient registration request dto
//     * @return the response dto
//     */
//    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_DOCTOR)
//    public ResponseDto<DoctorRegistrationResponseDto> registerPatient(@RequestBody DoctorRegistrationRequestDto doctorRegistrationRequestDto){
//        Doctor doctor;
//        try{
//            doctor = iDoctorService.saveDoctor(doctorRegistrationRequestDto);
//        } catch (DoctorRegistrationException e) {
//            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
//        }
//        catch (Exception e){
//            log.error("Error occurred :: " , e);
//            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
//        }
//        return new ResponseDto<>(
//                DoctorRegistrationResponseDto.builder()
//                        .id(doctor.getId())
//                        .firstName(doctor.getFirstName())
//                        .middleName(doctor.getMiddleName())
//                        .lastName(doctor.getLastName())
//                        .age(doctor.getAge())
//                        .emailAddress(doctor.getEmailAddress())
//                        .phoneNumber(doctor.getPhoneNumber())
//                        .gender(doctor.getGender().getGenderDisplay())
//                        .build()
//        );
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = UriConstants.GET_DOCTOR_LIST)
//    public ResponseDto<List<Doctor>> getDoctors(){
//
//        List<Doctor> list;
//        try{
//            list = iDoctorService.getDoctorsList();
//        }
//        catch (Exception e){
//            log.error("Error occurred :: " , e);
//            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
//        }
//        return new ResponseDto<>(list);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = UriConstants.DELETE_DOCTOR)
//    private ResponseDto<String> deleteDoctor(@RequestParam(name = "email_address")String emailAddress){
//        try{
//            iDoctorService.deleteDoctor(emailAddress);
//            return new ResponseDto<>("Record Deleted Successfully");
//        }
//        catch (Exception e){
//            log.error("Error occurred :: " , e);
//            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
//        }
//    }
//
//}
