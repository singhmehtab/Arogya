package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.arogya.model.enums.Gender;
import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty( "last_name")
    private String lastName;

    @JsonProperty( "middle_name")
    private String middleName;

    @JsonProperty( "phone_number")
    private String phoneNumber;

    @JsonProperty( "email_address")
    private String emailAddress;

    @JsonProperty( "gender")
    private Gender gender;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("logged")
    private boolean logged;

}
