package com.spm.arogya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "appointments")
@Getter
@Entity
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseModel{

    @Column(name = "appointment_start_time")
    private Date appointmentStartTime;

    @Column(name = "appointment_end_time")
    private Date appointmentEndTime;

    @Column(name = "question_answers")
    private Questions questions;

    @JsonIgnore
    @JoinColumn(name = "patient_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;



}
