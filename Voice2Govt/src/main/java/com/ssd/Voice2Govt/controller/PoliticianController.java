package com.ssd.Voice2Govt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.Voice2Govt.dto.AdminDto;
import com.ssd.Voice2Govt.dto.PoliticianDto;
import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.CitizenIssue;
import com.ssd.Voice2Govt.entity.Politician;
import com.ssd.Voice2Govt.repository.PoliticianRepository;
import com.ssd.Voice2Govt.service.PoliticianService;

@RestController
@RequestMapping("/api/politicians")
public class PoliticianController {
	@Autowired
	 private final PoliticianService politicianService;
	@Autowired
    private PoliticianRepository politicianRepository;
	 public PoliticianController(PoliticianService politicianService) {
	        this.politicianService = politicianService;
	    }
	 @PostMapping("/register")
	    public ResponseEntity<PoliticianDto> createPolitician(@RequestBody PoliticianDto politicianDto) {
	        PoliticianDto createdPolitician = politicianService.createPolitician(politicianDto);
	        return ResponseEntity.ok(createdPolitician);
	    }
	 @PostMapping("/login")
	    public ResponseEntity<String> loginPolitician(@RequestBody PoliticianDto politicianDto) {
	        // Authenticate politician using updated field names
	        Politician politician = politicianService.loginPolitician(politicianDto.getPolUsername(), politicianDto.getPolPassword());
	        
	        if (politician != null) {
	            String welcomeMessage = "Welcome, " + politician.getPol_firstName() + " " + politician.getPol_lastName()+ "!";
	            return ResponseEntity.ok(welcomeMessage);  // Return personalized welcome message
	        } else {
	            return ResponseEntity.status(401).body("Invalid username or password");
	        }
	    }
	 @GetMapping("/{username}/issues")
	 public ResponseEntity<List<CitizenIssue>> getCitizenIssuesByPolitician(@PathVariable String username) {
	     // Check if the politician exists by their username (no need for password)
	     Optional<Politician> politicianOptional = politicianRepository.findByPolUsername(username);

	     if (politicianOptional.isPresent()) {
	         Politician politician = politicianOptional.get();
	         
	         // Now, fetch the citizen issues for this politician (using the politician's constituency)
	         List<CitizenIssue> issues = politicianService.getCitizenIssuesForPolitician(politician.getPolConstituency());
	         return ResponseEntity.ok(issues);
	     }

	     // If the politician is not found, return a 404
	     return ResponseEntity.status(404).body(null);
	 }
	 @PutMapping("/{politicianId}/issues/{issueId}/status")
	 public ResponseEntity<String> updateIssueStatus(
	         @PathVariable Long politicianId,
	         @PathVariable Long issueId,	         @RequestBody String status) {

	     try {
	         politicianService.updateIssueStatus(politicianId, issueId, status);
	         return ResponseEntity.ok("Issue status updated successfully");
	     } catch (RuntimeException e) {
	         return ResponseEntity.status(404).body(e.getMessage());
	     }
	 }
	 @GetMapping("/{politicianId}/issues/inprogress")
	    public List<CitizenIssue> getInProgressIssues(@PathVariable Long politicianId) {
	        return politicianService.getInProgressIssuesForPolitician(politicianId);
	    }
	 @GetMapping("/{politicianId}/issues/resolved")
	    public List<CitizenIssue> getResolvedIssues(@PathVariable Long politicianId) {
	        return politicianService.getResolvedIssuesForPolitician(politicianId);
	    }
	 @GetMapping("/{politicianId}/issues/pending")
	 public List<CitizenIssue> getPendingIssues(@PathVariable Long politicianId){
		 return politicianService.getPendingIssuesForPolitician(politicianId);
	 }




}
