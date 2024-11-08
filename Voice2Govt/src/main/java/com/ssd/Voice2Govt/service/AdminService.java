package com.ssd.Voice2Govt.service;

import java.util.List;


import com.ssd.Voice2Govt.dto.AdminDto;
import com.ssd.Voice2Govt.dto.CitizenDto;
import com.ssd.Voice2Govt.dto.ModeratorDto;
import com.ssd.Voice2Govt.dto.PoliticianDto;
import com.ssd.Voice2Govt.entity.Admin;



public interface AdminService {

	AdminDto createAdmin(AdminDto AdminDto);
    AdminDto getAdminById(Long AdminId);
    List<AdminDto> getAllAdmins();
    AdminDto updateAdmin(Long AdminId,AdminDto updatedAdmin);
    void deleteAdmin(Long AdminId);
//    AdminDto loginAdmin(Long adminId, String password);
//    public Admin authenticate(String adminId, String password);
    public AdminDto loginAdmin(Long adminId, String admPassword) ;
    
    
    //citizen
    CitizenDto createCitizen(CitizenDto CitizenDto);
    CitizenDto getCitizenById(Long CitizenId);
    List<CitizenDto> getAllCitizens();
    CitizenDto updateCitizen(Long CitizenId,CitizenDto updatedCitizen);
    void deleteCitizen(Long CitizenId);
    
    
    //AUthentication
    
//    boolean authenticateAdmin(String email, String password);

    
    //Moderator
    ModeratorDto createModerator(ModeratorDto ModeratorDto);
    ModeratorDto getModeratorById(Long ModeratorId);
    List<ModeratorDto> getAllModerators();
    ModeratorDto updateModerator(Long ModeratorId,ModeratorDto updatedModerator);
    void deleteModerator(Long ModeratorId);
    
    //Politician
    PoliticianDto createPolitician(PoliticianDto PoliticianDto);
    PoliticianDto getPoliticianById(Long PoliticianId);
    List<PoliticianDto> getAllPoliticians();
    PoliticianDto updatePolitician(Long PoliticianId,PoliticianDto updatedPolitician);
    void deletePolitician(Long PoliticianId);
	
}
