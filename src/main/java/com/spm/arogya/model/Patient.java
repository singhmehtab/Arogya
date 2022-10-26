package com.spm.arogya.model;

import com.spm.arogya.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Patient.
 */
@Entity
@Table(name = "patients")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseModel{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "email_address", unique = true)
    private String emailAddress;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "age", nullable = false)
    private Integer age;

}
