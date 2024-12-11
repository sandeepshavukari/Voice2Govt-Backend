package com.ssd.Voice2Govt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ssd.Voice2Govt.entity.Issue;
import com.ssd.Voice2Govt.entity.Politician;

public interface IssueRepository extends JpaRepository<Issue, Long> {
//    List<Issue> findByPoliticianId(Long politicianId);
    //List<Issue> findByPolitician(Politician politician); // Find issues by politician

}