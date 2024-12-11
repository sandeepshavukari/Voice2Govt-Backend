package com.ssd.Voice2Govt.mapper;

import com.ssd.Voice2Govt.dto.IssueDto;
import com.ssd.Voice2Govt.entity.Issue;

public class IssueMapper {
    // Method to map Issue entity to IssueDto
    public static IssueDto mapToIssueDto(Issue issue) {
        return new IssueDto(
            issue.getId(),
            issue.getTitle(),
            issue.getDescription(),
            issue.getStatus(),
            issue.getCreatedDate(),
            issue.getUpdatedDate(),
            issue.getCitizen() != null ? issue.getCitizen().getCti_id() : null,
            issue.getPolitician() != null ? issue.getPolitician().getPol_id() : null,
            issue.getModerator() != null ? issue.getModerator().getMod_id() : null
        );
    }

    // Method to map IssueDto to Issue entity
    public static Issue mapToIssue(IssueDto issueDto) {
        Issue issue = new Issue();
        issue.setId(issueDto.getId());
        issue.setTitle(issueDto.getTitle());
        issue.setDescription(issueDto.getDescription());
        issue.setStatus(issueDto.getStatus());
        issue.setCreatedDate(issueDto.getCreatedDate());
        issue.setUpdatedDate(issueDto.getUpdatedDate());
        // Set relationships if needed
        return issue;
    }
}