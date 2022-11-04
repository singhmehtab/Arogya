package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorRegistrationRequestDto {

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
    private String gender;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("password")
    private String password;

    @JsonProperty("registration_number")
    private String registrationNumber;

}
