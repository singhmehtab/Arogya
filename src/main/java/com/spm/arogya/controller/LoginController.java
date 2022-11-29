//package com.spm.arogya.controller;
//
//import com.spm.arogya.constants.UriConstants;
//import com.spm.arogya.dto.LoginResponse;
//import com.spm.arogya.dto.ResponseDto;
//import com.spm.arogya.exception.LoginException;
//import com.spm.arogya.service.ILoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RestController
//@RequestMapping(UriConstants.BASE_URL)
//public class LoginController {
//    private ILoginService iLoginService;
//
//    @Autowired
//    LoginController(ILoginService iLoginService){
//        this.iLoginService=iLoginService;
//    }
//    @RequestMapping(method= RequestMethod.GET, value= UriConstants.LOGIN_USER)
//    public ResponseDto<LoginResponse> getLoginResponse(@RequestParam(name = "email") String email,
//                                                       @RequestParam(name= "password") String password,
//                                                       @RequestParam(name= "userType") String userType){
//        try{
//            LoginResponse loginResponse=iLoginService.getLoginDetails(email, password, userType);
//            return new ResponseDto<>(loginResponse);
//        }catch (LoginException ex){
//            return new ResponseDto<>(LoginResponse.builder().logged(false).build());
//        }
//    }
//}
