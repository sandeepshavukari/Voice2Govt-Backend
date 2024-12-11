package com.ssd.Voice2Govt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Title of the issue
    private String description; // Detailed description of the issue
    private String status; // Status of the issue (e.g., "Pending", "Resolved", "In Progress")
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate; // Date when the issue was created
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate; // Date when the issue was updated

    @ManyToOne
    @JoinColumn(name = "citizen_id") // Corrected column name
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "politician_id")  // Corrected column name
    private Politician politician;

    @ManyToOne
    @JoinColumn(name = "moderator_id") // Corrected column name
    private Moderator moderator; // The moderator who forwards the issue

    @PrePersist
    protected void onCreate() {
        // Set the createdDate to the current time when the entity is first persisted
        createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        // Set the updatedDate to the current time every time the entity is updated
        updatedDate = new Date();
    }
}
