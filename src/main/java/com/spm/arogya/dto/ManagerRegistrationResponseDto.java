package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * The type Patient registration response dto.
 */
@Builder
public class ManagerRegistrationResponseDto {

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
    private String gender;

    @JsonProperty("age")
    private Integer age;

}
