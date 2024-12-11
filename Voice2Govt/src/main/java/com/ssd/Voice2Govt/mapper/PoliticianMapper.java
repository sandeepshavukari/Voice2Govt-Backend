package com.ssd.Voice2Govt.mapper;

import com.ssd.Voice2Govt.dto.PoliticianDto;
import com.ssd.Voice2Govt.entity.Politician;

public class PoliticianMapper {

    // Mapping from Politician entity to PoliticianDto
    public static PoliticianDto mapToPoliticianDto(Politician politician) {
        if (politician == null) {
            return null;  // Handle null case
        }
        
        return new PoliticianDto(
                politician.getPol_id(),
                politician.getPol_firstName(),
                politician.getPol_lastName(),
                politician.getPol_email(),
                politician.getPol_phoneNumber(),
                politician.getPol_dob(),
                politician.getPolUsername(),
                politician.getPolPassword(),  // (Consider security for sensitive data)
                politician.getPolConstituency()
               // politician.getIssues()  // Mapping the issues List from Politician to DTO
        );
    }

    // Mapping from PoliticianDto to Politician entity
    public static Politician mapToPolitician(PoliticianDto politicianDto) {
        if (politicianDto == null) {
            return null;  // Handle null case
        }

        return new Politician(
                politicianDto.getPol_id(),
                politicianDto.getPol_firstName(),
                politicianDto.getPol_lastName(),
                politicianDto.getPol_email(),
                politicianDto.getPol_phoneNumber(),
                politicianDto.getPol_dob(),
                politicianDto.getPolUsername(),
                politicianDto.getPolPassword(),  // (Consider security for sensitive data)
                politicianDto.getPolConstituency()
               // politicianDto.getIssues()  // Mapping the issues List from DTO to Politician
        );
    }
}
