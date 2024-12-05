package com.ssd.Voice2Govt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ModeratorDto {

	private Long mod_id;
	private String mod_firstName;
	private String mod_lastName;
	private String mod_email;
	private String mod_phoneNumber;
	private String mod_dob;
	private String modUsername;
	private String modPassword;
}
