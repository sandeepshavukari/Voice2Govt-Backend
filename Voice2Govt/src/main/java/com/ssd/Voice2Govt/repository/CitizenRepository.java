package com.ssd.Voice2Govt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

//    Optional<Citizen> findByCtiUsername(String username);// Return Optional<Citizen> instead of Optional<Admin>
//	Optional<Citizen> findByCtiUsername(String username); 
//	Optional<Citizen> findByCtiUsername(String username); 
	
	
//	@Query("SELECT c FROM Citizen c WHERE c.ctiUsername = :username")
//	 Optional<Citizen> findByCtiUsername(String username); // This will automatically generate the query
	Optional<Citizen> findByCtiUsername(String username);
	}
