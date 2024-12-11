package com.ssd.Voice2Govt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.Voice2Govt.entity.Citizen;
import com.ssd.Voice2Govt.entity.CitizenIssue;
import com.ssd.Voice2Govt.entity.Politician;
import com.ssd.Voice2Govt.repository.CitizenIssueRepository;
import com.ssd.Voice2Govt.repository.CitizenRepository;
import com.ssd.Voice2Govt.repository.PoliticianRepository;
import com.ssd.Voice2Govt.service.CitizenIssueService;


@Service
public class CitizenIssueServiceImpl implements CitizenIssueService {

	@Autowired
	private CitizenIssueRepository citizenIssueRepository;
	private CitizenRepository citizenRepository;
	private PoliticianRepository politicianRepository;

	@Autowired
	public CitizenIssueServiceImpl(CitizenRepository citizenRepository, PoliticianRepository politicianRepository,
			CitizenIssueRepository citizenIssueRepository) {
		this.citizenRepository = citizenRepository;
		this.politicianRepository = politicianRepository;
		this.citizenIssueRepository = citizenIssueRepository;
	}

	@Override
	public CitizenIssue createIssue(String citizenUsername, String issueDescription, byte[] issueImage) {
	    Citizen citizen = citizenRepository.findByCtiUsername(citizenUsername)
	            .orElseThrow(() -> new RuntimeException("Citizen not found"));

	    List<Politician> politicians = politicianRepository.findByPolConstituency(citizen.getCtiConstituency());
	    if (politicians.isEmpty()) {
	        throw new RuntimeException("No politician found for this constituency");
	    }

	    Politician politician = politicians.get(0);

	    CitizenIssue issue = new CitizenIssue();
	    issue.setCitizen(citizen);
	    issue.setPolitician(politician);
	    issue.setIssueDescription(issueDescription);
	    issue.setStatus("Pending");
	    issue.setIssueImage(issueImage);  // Save the image

	    return citizenIssueRepository.save(issue);
	}

	@Override
    public List<CitizenIssue> getIssuesByCitizenCtiId(Long ctiId) {
        return citizenIssueRepository.findByCitizenCtiId(ctiId);
    }
	
	@Override
	public List<CitizenIssue> getIssuesByCitizenUsername(String username) {
	    return citizenIssueRepository.findByCitizenUsername(username);
	}

	

	

}
