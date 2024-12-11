package com.ssd.Voice2Govt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ssd.Voice2Govt.entity.CitizenIssue;

public interface CitizenIssueRepository extends JpaRepository<CitizenIssue,Long> {
	List<CitizenIssue> findByPoliticianPolConstituency(String constituency);
	 Optional<CitizenIssue> findById(Long id);
	 @Query("SELECT ci FROM CitizenIssue ci WHERE ci.citizen.cti_id = :cti_id")
	 List<CitizenIssue> findByCitizenCtiId(@Param("cti_id") Long citizenCtiId);
	 @Query("SELECT ci FROM CitizenIssue ci WHERE ci.politician.pol_id = :polId AND ci.status = :status")
	 List<CitizenIssue> findByPoliticianAndStatus(@Param("polId") Long polId, @Param("status") String status);
	 @Query("SELECT ci FROM CitizenIssue ci WHERE ci.citizen.ctiUsername = :username")
	 List<CitizenIssue> findByCitizenUsername(@Param("username") String username);
	 

}
