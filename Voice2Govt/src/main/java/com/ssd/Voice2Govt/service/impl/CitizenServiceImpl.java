package com.ssd.Voice2Govt.service.impl;

import com.ssd.Voice2Govt.dto.CitizenDto;
import com.ssd.Voice2Govt.dto.IssueDto;
import com.ssd.Voice2Govt.dto.PoliticianDto;
import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Citizen;
import com.ssd.Voice2Govt.entity.CitizenIssue;
import com.ssd.Voice2Govt.entity.Issue;
import com.ssd.Voice2Govt.entity.Moderator;
import com.ssd.Voice2Govt.entity.Politician;
import com.ssd.Voice2Govt.mapper.CitizenMapper;
import com.ssd.Voice2Govt.mapper.IssueMapper;
import com.ssd.Voice2Govt.mapper.PoliticianMapper;
import com.ssd.Voice2Govt.repository.CitizenRepository;
import com.ssd.Voice2Govt.repository.IssueRepository;
import com.ssd.Voice2Govt.repository.PoliticianRepository;
import com.ssd.Voice2Govt.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;
//
//    @Autowired
//    private IssueRepository issueRepository;
//
//    @Autowired
//    private PoliticianRepository politicianRepository;

    @Override
    public CitizenDto createCitizen(CitizenDto citizenDto) {
        // Map DTO to Entity
        Citizen citizen = CitizenMapper.mapToCitizen(citizenDto);
        // Save citizen to repository
        Citizen savedCitizen = citizenRepository.save(citizen);
        // Return the saved citizen as DTO
        return CitizenMapper.mapToCitizenDto(savedCitizen);
    }

//    @Override
//    public Citizen loginCitizen(String username, String password) {
//        Optional<Citizen> citizenOptional = citizenRepository.findByCtiUsername(username);  // Search by username
//
//        if (citizenOptional.isPresent() && citizenOptional.get().getCtiPassword().equals(password)) {  // Check if password matches
//            return  citizenOptional.get();   // Return Citizen details if successful
//        }
        
//        return null;  // Return null if authentication fails
//    }
//    @Override
//    public List<IssueDto> getAllIssues() {
//        // Fetch all issues from the repository
//        List<Issue> allIssues = issueRepository.findAll();
//        // Map the issues to IssueDTOs and return the list
//        return allIssues.stream()
//                .map(IssueMapper::mapToIssueDto)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<IssueDto> getPoliticianUpdates() {
//		return null;
//        // Fetch all politicians to get their updates on issues (You can filter based on politician IDs if needed)
//        List<Politician> allPoliticians = politicianRepository.findAll();
//        // Get the list of issues associated with politicians and map to DTOs
//        return allPoliticians.stream()
//                .flatMap(politician -> issueRepository.findByPoliticianId(politician.getId()).stream()) // Fetch issues for each politician
//                .map(IssueMapper::mapToIssueDto)
//                .collect(Collectors.toList());
//    }

    //@Override
//    public IssueDto createIssue(IssueDto issueDto, Long citizenId) {
//        // Map the IssueDTO to Issue entity
//        Issue issue = IssueMapper.mapToIssue(issueDto);
//
//        // Find the citizen who created the issue by ID
//        Citizen citizen = citizenRepository.findById(citizenId)
//                .orElseThrow(() -> new RuntimeException("Citizen not found with ID: " + citizenId));
//
//        // Associate the citizen with the issue
//        issue.setCitizen(citizen);
//
//        // Set the created date
//        issue.setCreatedDate(new java.util.Date());
//
//        // Assign a politician (You may have a rule for assigning politicians based on constituency or issue type)
//        Politician politician = findPoliticianForIssue(issue); // Logic to assign a politician based on the issue
//        issue.setPolitician(politician);
//
//        // Assign a moderator (This can be handled dynamically, maybe based on availability or system rules)
//        Moderator moderator = findModeratorForIssue(); // Logic to assign a moderator to this issue
//        issue.setModerator(moderator);
//
//        // Save the issue
//        Issue savedIssue = issueRepository.save(issue);
//
//        // Return the saved issue as DTO
//        return IssueMapper.mapToIssueDto(savedIssue);
//    }

//
//    private Moderator findModeratorForIssue() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private Politician findPoliticianForIssue(Issue issue) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//    public IssueDto updateIssue(Long issueId, IssueDto updatedIssue) {
//        // Find the issue by its ID
//        Issue existingIssue = issueRepository.findById(issueId)
//                .orElseThrow(() -> new RuntimeException("Issue not found with ID: " + issueId));
//        // Update issue details
//        existingIssue.setTitle(updatedIssue.getTitle());
//        existingIssue.setDescription(updatedIssue.getDescription());
//        existingIssue.setStatus(updatedIssue.getStatus());
//        existingIssue.setUpdatedDate(new java.util.Date());
//        // Save the updated issue
//        Issue savedIssue = issueRepository.save(existingIssue);
//        // Return the updated issue as DTO
//        return IssueMapper.mapToIssueDto(savedIssue);
//    }

    //@Override
//    public void deleteIssue(Long issueId) {
//        // Find the issue by its ID
//        Issue issue = issueRepository.findById(issueId)
//                .orElseThrow(() -> new RuntimeException("Issue not found with ID: " + issueId));
//        // Delete the issue
//        issueRepository.delete(issue);
//    }

//	@Override
//	public Admin authenticateCitizen(String username, String password) {
//		Optional<Citizen> citizen = citizenRepository.findByCtiUsername(username);  // Use updated field name
//	    if (citizen.isPresent() && citizen.get().getCtiPassword().equals(password)) {  // Use updated field name
//	        return citizen.get();  // Return Admin details if authentication is successful
//	    }
//	    return null;
//	}
//
//	@Override
//	public CitizenDto loginCitizen(String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//    @Override
//    public CitizenDto loginCitizen(String username, String password) {
//        Optional<Citizen> citizenOptional = citizenRepository.findByCtiUsername(username); // Use correct username field
//
//        if (citizenOptional.isPresent() && citizenOptional.get().getCtiPassword().equals(password)) {
//            return CitizenMapper.mapToCitizenDto(citizenOptional.get()); // Map Citizen entity to CitizenDto
//        }
//        return null; // Return null if authentication fails
//    }

   @Override
    public Citizen authenticateCitizen(String username, String password) {
        Optional<Citizen> citizen = citizenRepository.findByCtiUsername(username);

        if (citizen.isPresent() && citizen.get().getCtiPassword().equals(password)) {
            // Return Citizen if password matches
            return citizen.get();
        }
        return null; // Return null if authentication fails
    }
   
//   public Admin authenticateAdmin(String username, String password) {
//		Optional<Admin> admin = adminRepository.findByAdmUsername(username);  // Use updated field name
//	    if (admin.isPresent() && admin.get().getAdmPassword().equals(password)) {  // Use updated field name
//	        return admin.get();  // Return Admin details if authentication is successful
//	    }
//	    return null;
//	}
//		
   

}
