package com.ssd.Voice2Govt.service;

import com.ssd.Voice2Govt.dto.CitizenDto;
import com.ssd.Voice2Govt.dto.IssueDto;
import com.ssd.Voice2Govt.dto.PoliticianDto;
import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Citizen;
import com.ssd.Voice2Govt.entity.CitizenIssue;

import java.util.List;

public interface CitizenService {

CitizenDto createCitizen(CitizenDto citizenDto); // Register a citizen
    
//    CitizenDto loginCitizen(String username, String password); // Citizen login
    
    public Citizen authenticateCitizen(String username, String password); // Authenticate citizen (this should ideally return Citizen)
//    public Admin authenticateAdmin(String username, String password);
    
    
}
