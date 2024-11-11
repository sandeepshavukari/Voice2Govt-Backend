package com.ssd.Voice2Govt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private Long adm_id;
    private String adm_firstName;
    private String adm_lastName;
    private String adm_email;
    private String adm_phoneNumber;
    private String adm_dob;
    private String admUsername;
    private String admPassword;
    
}
