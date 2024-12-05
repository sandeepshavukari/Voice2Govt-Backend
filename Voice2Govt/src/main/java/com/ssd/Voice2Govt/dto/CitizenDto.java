package com.ssd.Voice2Govt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CitizenDto {

	private Long cti_id;
	private String cti_firstName;
	private String cti_lastName;
	private String cti_email;
	private String cti_phoneNumber;
	private String cti_dob;
	private String ctiUsername;
	private String ctiPassword;
	private String ctiConstituency;
}
