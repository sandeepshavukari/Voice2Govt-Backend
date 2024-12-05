package com.ssd.Voice2Govt.mapper;

import com.ssd.Voice2Govt.dto.CitizenDto;
import com.ssd.Voice2Govt.entity.Citizen;

public class CitizenMapper {
	
	public static CitizenDto mapToCitizenDto(Citizen citizen)
	{
		return new CitizenDto(
				citizen.getCti_id(),
				citizen.getCti_firstName(),
				citizen.getCti_lastName(),
				citizen.getCti_email(),
				citizen.getCti_phoneNumber(),
				citizen.getCti_dob(),
				citizen.getCtiUsername(),
				citizen.getCtiPassword(),
				citizen.getCtiConstituency()
		);
	}
	 public static Citizen mapToCitizen(CitizenDto citizenDto)
	    {
	        return new Citizen(
	                citizenDto.getCti_id(),
	                citizenDto.getCti_firstName(),
	                citizenDto.getCti_lastName(),
	                citizenDto.getCti_email(),
	                citizenDto.getCti_phoneNumber(),
	                citizenDto.getCti_dob(),
	                citizenDto.getCtiUsername(),
	                citizenDto.getCtiPassword(),
	                citizenDto.getCtiConstituency()
	        );
	    }


}
