package com.ssd.Voice2Govt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cti_id;
    private String cti_firstName;
    private String cti_lastName;
    private String cti_email;
    private String cti_phoneNumber;
    private String cti_dob;
    @Column(name = "cti_username")
    private String ctiUsername; // Ensure this is lowercase 'c'
    private String ctiPassword;
    private String ctiConstituency;
}