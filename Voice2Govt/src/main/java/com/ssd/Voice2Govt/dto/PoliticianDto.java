package com.ssd.Voice2Govt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PoliticianDto {

	private Long pol_id;
	private String pol_firstName;
	private String pol_lastName;
	private String pol_email;
	private String pol_phoneNumber;
	private String pol_dob;
	private String pol_username;
	private String pol_password;
}
