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
public class Moderator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mod_id;
	private String mod_firstName;
	private String mod_lastName;
	private String mod_email;
	private String mod_phoneNumber;
	private String mod_dob;
	private String modUsername;
	private String modPassword;
}
