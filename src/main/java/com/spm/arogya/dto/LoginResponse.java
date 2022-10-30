package com.spm.arogya.dto;

import com.spm.arogya.model.enums.Gender;
import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {
    private String firstName;

    private String lastName;

    private String middleName;

    private String phoneNumber;
    private String emailAddress;
    private Gender gender;
    private Integer age;
    private boolean logged;

}
