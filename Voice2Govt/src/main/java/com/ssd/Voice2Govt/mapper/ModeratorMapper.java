package com.ssd.Voice2Govt.mapper;

import com.ssd.Voice2Govt.dto.ModeratorDto;
import com.ssd.Voice2Govt.entity.Moderator;

public class ModeratorMapper {
	
	public static ModeratorDto mapToModeratorDto(Moderator moderator)
	{
		return new ModeratorDto(
				moderator.getMod_id(),
				moderator.getMod_firstName(),
				moderator.getMod_lastName(),
				moderator.getMod_email(),
				moderator.getMod_phoneNumber(),
				moderator.getMod_dob(),
				moderator.getModUsername(),
				moderator.getModPassword()
		);
	}
	 public static Moderator mapToModerator(ModeratorDto moderatorDto)
	    {
	        return new Moderator(
	                moderatorDto.getMod_id(),
	                moderatorDto.getMod_firstName(),
	                moderatorDto.getMod_lastName(),
	                moderatorDto.getMod_email(),
	                moderatorDto.getMod_phoneNumber(),
	                moderatorDto.getMod_dob(),
	                moderatorDto.getModUsername(),
	                moderatorDto.getModPassword()
	        );
	    }


}
