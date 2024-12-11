package com.ssd.Voice2Govt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Issue;
import com.ssd.Voice2Govt.entity.Politician;

@Repository
public interface PoliticianRepository extends JpaRepository<Politician, Long>{
	
	Optional<Politician> findByPolUsername(String username);
	List<Politician> findByPolConstituency(String constituency);
	@Query("SELECT p FROM Politician p WHERE p.pol_id = :pol_id")
    Optional<Politician> findByPolId(@Param("pol_id") Long polId);

	
}
