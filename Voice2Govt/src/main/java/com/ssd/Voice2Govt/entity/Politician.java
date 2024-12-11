package com.ssd.Voice2Govt.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @Column(name = "pol_username")
    private String polUsername;
    private String polPassword;
    private String polConstituency;
	// @OneToMany(mappedBy = "politician")
	  //  private List<Issue> issues;
}
