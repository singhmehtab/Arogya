package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.arogya.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * The type Patient registration request dto.
 */
@Builder
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientRegistrationRequestDto {

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

}
