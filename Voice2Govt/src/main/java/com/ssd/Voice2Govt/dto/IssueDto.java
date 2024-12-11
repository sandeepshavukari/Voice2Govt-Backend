package com.ssd.Voice2Govt.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {
    private Long id; // ID of the issue
    private String title; // Title of the issue
    private String description; // Detailed description of the issue
    private String status; // Status of the issue
    private Date createdDate; // Date when the issue was created
    private Date updatedDate; // Date when the issue was last updated
    private Long citizenId; // ID of the citizen who reported the issue
    private Long politicianId; // ID of the politician who is assigned or reviewing the issue
    private Long moderatorId; // ID of the moderator who forwards the issue
}