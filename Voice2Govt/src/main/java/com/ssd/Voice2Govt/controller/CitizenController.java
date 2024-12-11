package com.ssd.Voice2Govt.controller;

import com.ssd.Voice2Govt.dto.AdminDto;
import com.ssd.Voice2Govt.dto.CitizenDto;
import com.ssd.Voice2Govt.dto.IssueDto;
import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Citizen;
import com.ssd.Voice2Govt.entity.CitizenIssue;
import com.ssd.Voice2Govt.mapper.CitizenMapper;
import com.ssd.Voice2Govt.service.CitizenIssueService;
import com.ssd.Voice2Govt.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;
    
    @Autowired
    private CitizenIssueService citizenIssueService;

    // Endpoint to create a new citizen
    @PostMapping("/register")
    public ResponseEntity<CitizenDto> createCitizen(@RequestBody CitizenDto citizenDto) {
        CitizenDto createdCitizen = citizenService.createCitizen(citizenDto);
        return new ResponseEntity<>(createdCitizen, HttpStatus.CREATED);
    }

    // Endpoint for citizen login
    @PostMapping("/login")
    public ResponseEntity<String> loginCitizen(@RequestBody CitizenDto citizenDto) {
        Citizen citizen = citizenService.authenticateCitizen(citizenDto.getCtiUsername(), citizenDto.getCtiPassword());
        if (citizen != null) {
        	String welcomeMessage = "Welcome, " + citizen.getCti_firstName() + " " + citizen.getCti_lastName() + "!";
            return ResponseEntity.ok(welcomeMessage);  // Return personalized welcome message
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
   
    

    
     
    // Endpoint to get all issues
//    @GetMapping("/ctiissues")
//    public ResponseEntity<List<IssueDto>> getAllIssues() {
//        List<IssueDto> allIssues = citizenService.getAllIssues();
//        return new ResponseEntity<>(allIssues, HttpStatus.OK);
//    }
    
    // Endpoint to create a new issue
  //  @PostMapping("/{citizenId}/issues")
//    public ResponseEntity<IssueDto> createIssue(@RequestBody IssueDto issueDto, @PathVariable Long citizenId) {
//        IssueDto createdIssue = citizenService.createIssue(issueDto, citizenId);
//        return new ResponseEntity<>(createdIssue, HttpStatus.CREATED);
//    }

//    // Endpoint to update an existing issue
//    @PutMapping("/issues/{issueId}")
//    public ResponseEntity<IssueDto> updateIssue(@PathVariable Long issueId, @RequestBody IssueDto issueDto) {
//        IssueDto updatedIssue = citizenService.updateIssue(issueId, issueDto);
//        return new ResponseEntity<>(updatedIssue, HttpStatus.OK);
//    }

//    // Endpoint to delete an issue
//    @DeleteMapping("/issues/{issueId}")
//    public ResponseEntity<Void> deleteIssue(@PathVariable Long issueId) {
//        citizenService.deleteIssue(issueId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    
    
    
}
