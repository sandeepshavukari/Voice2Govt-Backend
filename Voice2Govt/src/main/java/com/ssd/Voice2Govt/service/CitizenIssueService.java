package com.ssd.Voice2Govt.service;

import java.util.List;

import com.ssd.Voice2Govt.entity.CitizenIssue;

public interface CitizenIssueService {
	CitizenIssue createIssue(String citizenUsername, String issueDescription, byte[] issueImage);
	List<CitizenIssue> getIssuesByCitizenCtiId(Long ctiId);
	List<CitizenIssue> getIssuesByCitizenUsername(String username);
	
}
