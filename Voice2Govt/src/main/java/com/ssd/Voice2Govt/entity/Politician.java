package com.ssd.Voice2Govt.entity;

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
public class Politician {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pol_id;
	private String pol_firstName;
	private String pol_lastName;
	private String pol_email;
	private String pol_phoneNumber;
	private String pol_dob;
	private String pol_username;
	private String pol_password;

}
