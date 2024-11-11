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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adm_id;
	private String adm_firstName;
	private String adm_lastName;
	private String adm_email;
	private String adm_phoneNumber;
	private String adm_dob;
	@Column(name = "adm_username")
	private String admUsername;
	private String admPassword;
}
