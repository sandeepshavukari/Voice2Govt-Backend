package com.ssd.Voice2Govt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.Voice2Govt.dto.PoliticianDto;
import com.ssd.Voice2Govt.entity.CitizenIssue;
import com.ssd.Voice2Govt.entity.Politician;
import com.ssd.Voice2Govt.mapper.PoliticianMapper;
import com.ssd.Voice2Govt.repository.CitizenIssueRepository;
import com.ssd.Voice2Govt.repository.PoliticianRepository;
import com.ssd.Voice2Govt.service.PoliticianService;

@Service
public class PoliticianServiceImpl implements PoliticianService {
	
	 @Autowired
	    private PoliticianRepository politicianRepository;
	 @Autowired
	    private CitizenIssueRepository citizenIssueRepository;


	@Override
	public PoliticianDto createPolitician(PoliticianDto politicianDto) {
		 // Map DTO to Entity
        Politician politician = PoliticianMapper.mapToPolitician(politicianDto);
        // Save politician to repository
        Politician savedPolitician = politicianRepository.save(politician);
        // Return the saved politician as DTO
        return PoliticianMapper.mapToPoliticianDto(savedPolitician);

	}

	@Override
	public Politician loginPolitician(String username, String password) {
		Optional<Politician> politician =politicianRepository.findByPolUsername(username);
		if(politician.isPresent()&&politician.get().getPolPassword().equals(password)) {
			return politician.get();
		}
		return null;
	}

	@Override
	public List<CitizenIssue> getCitizenIssuesForPolitician(String constituency) {
		return citizenIssueRepository.findByPoliticianPolConstituency(constituency);
	}

	@Override
	public void updateIssueStatus(Long politicianId, Long issueId, String status) {
	    // Check if the politician exists
	    Politician politician = politicianRepository.findById(politicianId)
	            .orElseThrow(() -> new RuntimeException("Politician not found"));

	    // Find the issue associated with the politician
	    CitizenIssue issue = citizenIssueRepository.findById(issueId)
	            .orElseThrow(() -> new RuntimeException("Issue not found"));

	    // Verify that the issue belongs to the politician
	    if (!issue.getPolitician().getPol_id().equals(politicianId)) {
	        throw new RuntimeException("Politician is not authorized to update this issue");
	    }

	    // Update the status of the issue
	    issue.setStatus(status);
	    citizenIssueRepository.save(issue);
	}

	@Override
	public List<CitizenIssue> getInProgressIssuesForPolitician(Long politicianId) {
	    return citizenIssueRepository.findByPoliticianAndStatus(politicianId, "inprogress");
	}

	@Override
	public List<CitizenIssue> getResolvedIssuesForPolitician(Long politicianId) {
	    return citizenIssueRepository.findByPoliticianAndStatus(politicianId, "resolved");
	}

	@Override
	public List<CitizenIssue> getPendingIssuesForPolitician(Long politicianId) {
		return citizenIssueRepository.findByPoliticianAndStatus(politicianId, "pending");
	}





	

}