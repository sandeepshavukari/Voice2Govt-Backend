package com.ssd.Voice2Govt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CitizenIssue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long issueId;
	private String issueDescription;
	
	@Lob
	@Column(name = "issue_image", columnDefinition = "LONGBLOB")
	private byte[] issueImage;
	@ManyToOne
	@JoinColumn(name="cti_id",nullable=false)
	private Citizen citizen;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pol_id",nullable=false)
	private Politician politician;
	
	 private String status;

}
