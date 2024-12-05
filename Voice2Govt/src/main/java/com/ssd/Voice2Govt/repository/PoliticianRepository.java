package com.ssd.Voice2Govt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Issue;
import com.ssd.Voice2Govt.entity.Politician;

public interface PoliticianRepository extends JpaRepository<Politician, Long>{

//	Optional<Admin> findByPolUsername(String username); 
//	List<Issue> findByPolitician_Id(Long politicianId);
	Optional<Politician> findByPolUsername(String username); // Ensure this method exists
    List<Issue> findByPolitician_Id(Long politicianId);
}
