package com.ssd.Voice2Govt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long>{

	

}
