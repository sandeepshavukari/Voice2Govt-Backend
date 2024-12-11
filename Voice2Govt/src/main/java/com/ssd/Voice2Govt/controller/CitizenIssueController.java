package com.ssd.Voice2Govt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssd.Voice2Govt.dto.CitizenIssueDto;
import com.ssd.Voice2Govt.entity.CitizenIssue;
import com.ssd.Voice2Govt.service.CitizenIssueService;

@RestController
@RequestMapping("/api/citizenissues")
public class CitizenIssueController {
	
	 private final CitizenIssueService citizenIssueService;
	 public CitizenIssueController(CitizenIssueService citizenIssueService) {
	        this.citizenIssueService = citizenIssueService;
	    }
	 @PostMapping("/create")
	 public ResponseEntity<CitizenIssue> createIssue(
	         @RequestParam("citizenUsername") String citizenUsername,
	         @RequestParam("issueDescription") String issueDescription,
	         @RequestParam(value = "issueImage", required = false) MultipartFile issueImage) {

	     byte[] imageData = null;
	     try {
	         if (issueImage != null && !issueImage.isEmpty()) {
	             imageData = issueImage.getBytes();  // Convert to byte array
	         }
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().build();
	     }

	     CitizenIssue issue = citizenIssueService.createIssue(citizenUsername, issueDescription, imageData);
	     return ResponseEntity.ok(issue);
	 }
	 @GetMapping("/citizen/{ctiId}")
	    public ResponseEntity<List<CitizenIssue>> getCitizenIssuesByCtiId(@PathVariable Long ctiId) {
	        List<CitizenIssue> issues = citizenIssueService.getIssuesByCitizenCtiId(ctiId);
	        if (issues.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(issues);
	    }
	 
	 @GetMapping("/citizen/view/{username}")
	    public List<CitizenIssue> getIssuesByCitizenUsername(@PathVariable String username) {
	        return citizenIssueService.getIssuesByCitizenUsername(username);
	    }
}
