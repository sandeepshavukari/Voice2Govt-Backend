package com.ssd.Voice2Govt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CitizenIssueDto {
	private String citizenUsername;
	private String issueDescription;
	private String issueImage;  // Change from byte[] to String for Base64
    private String status;
 
}
