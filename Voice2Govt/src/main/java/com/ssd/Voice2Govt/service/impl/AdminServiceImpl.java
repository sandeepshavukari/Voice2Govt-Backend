package com.ssd.Voice2Govt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ssd.Voice2Govt.dto.AdminDto;
import com.ssd.Voice2Govt.dto.CitizenDto;
import com.ssd.Voice2Govt.dto.ModeratorDto;
import com.ssd.Voice2Govt.dto.PoliticianDto;
import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.entity.Citizen;
import com.ssd.Voice2Govt.entity.Moderator;
import com.ssd.Voice2Govt.entity.Politician;
import com.ssd.Voice2Govt.mapper.AdminMapper;
import com.ssd.Voice2Govt.mapper.CitizenMapper;
import com.ssd.Voice2Govt.mapper.ModeratorMapper;
import com.ssd.Voice2Govt.mapper.PoliticianMapper;
import com.ssd.Voice2Govt.repository.AdminRepository;
import com.ssd.Voice2Govt.repository.CitizenRepository;
import com.ssd.Voice2Govt.repository.ModeratorRepository;
import com.ssd.Voice2Govt.repository.PoliticianRepository;
import com.ssd.Voice2Govt.service.AdminService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{
	
	private AdminRepository adminRepository;
	private CitizenRepository citizenRepository;
	private ModeratorRepository moderatorRepository;
	private PoliticianRepository politicianRepository;

									/*Admin
	----------------------------------------------------------------------------------------------*/
	@Override
	public AdminDto createAdmin(AdminDto adminDto) {
		Admin admin= AdminMapper.mapToAdmin(adminDto);
		Admin savedAdmin=adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(savedAdmin);
	}

	@Override
	public AdminDto getAdminById(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + adminId));
        return AdminMapper.mapToAdminDto(admin);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(AdminMapper::mapToAdminDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto updateAdmin(Long adminId, AdminDto updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + adminId));

        // Update fields
        existingAdmin.setAdm_firstName(updatedAdmin.getAdm_firstName());
        existingAdmin.setAdm_lastName(updatedAdmin.getAdm_lastName());
        existingAdmin.setAdm_email(updatedAdmin.getAdm_email());
        existingAdmin.setAdm_phoneNumber(updatedAdmin.getAdm_phoneNumber());
        existingAdmin.setAdm_dob(updatedAdmin.getAdm_dob());
        existingAdmin.setAdm_password(updatedAdmin.getAdm_password());

        Admin savedAdmin = adminRepository.save(existingAdmin);
        return AdminMapper.mapToAdminDto(savedAdmin);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        Admin existingAdmin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + adminId));
        adminRepository.delete(existingAdmin);
    }
									/*Citizen 
	----------------------------------------------------------------------------------------------*/
	@Override
	public CitizenDto createCitizen(CitizenDto citizenDto) {
	    Citizen citizen = CitizenMapper.mapToCitizen(citizenDto);
	    Citizen savedCitizen = citizenRepository.save(citizen);
	    return CitizenMapper.mapToCitizenDto(savedCitizen);
	}

    @Override
    public CitizenDto getCitizenById(Long citizenId) {
        Citizen citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found with id: " + citizenId));
        return CitizenMapper.mapToCitizenDto(citizen);
    }

    @Override
    public List<CitizenDto> getAllCitizens() {
        List<Citizen> citizens = citizenRepository.findAll();
        return citizens.stream()
                .map(CitizenMapper::mapToCitizenDto)
                .collect(Collectors.toList());
    }

    @Override
    public CitizenDto updateCitizen(Long citizenId, CitizenDto updatedCitizen) {
        Citizen existingCitizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found with id: " + citizenId));

        // Update fields
        existingCitizen.setCti_firstName(updatedCitizen.getCti_firstName());
        existingCitizen.setCti_lastName(updatedCitizen.getCti_lastName());
        existingCitizen.setCti_email(updatedCitizen.getCti_email());
        existingCitizen.setCti_phoneNumber(updatedCitizen.getCti_phoneNumber());
        existingCitizen.setCti_dob(updatedCitizen.getCti_dob());
        existingCitizen.setCti_password(updatedCitizen.getCti_password());

        Citizen savedCitizen = citizenRepository.save(existingCitizen);
        return CitizenMapper.mapToCitizenDto(savedCitizen);
    }

    @Override
    public void deleteCitizen(Long citizenId) {
        Citizen existingCitizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found with id: " + citizenId));
        citizenRepository.delete(existingCitizen);
    }

										/*Moderator
	----------------------------------------------------------------------------------------------*/
	@Override
	public ModeratorDto createModerator(ModeratorDto moderatorDto) {
	    Moderator moderator = ModeratorMapper.mapToModerator(moderatorDto);
	    Moderator savedModerator = moderatorRepository.save(moderator);
	    return ModeratorMapper.mapToModeratorDto(savedModerator);
	}

	@Override
	public ModeratorDto getModeratorById(Long ModeratorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModeratorDto> getAllModerators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModeratorDto updateModerator(Long ModeratorId, ModeratorDto updatedModerator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModerator(Long ModeratorId) {
		// TODO Auto-generated method stub
		
	}
										/*Politician
----------------------------------------------------------------------------------------------*/
	
	@Override
	public PoliticianDto createPolitician(PoliticianDto politicianDto) {
	    Politician politician = PoliticianMapper.mapToPolitician(politicianDto);
	    Politician savedPolitician = politicianRepository.save(politician);
	    return PoliticianMapper.mapToPoliticianDto(savedPolitician);
	}

	@Override
	public PoliticianDto getPoliticianById(Long PoliticianId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticianDto> getAllPoliticians() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PoliticianDto updatePolitician(Long PoliticianId, PoliticianDto updatedPolitician) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePolitician(Long PoliticianId) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public boolean authenticateAdmin(String email, String password) {
//		 Admin admin = adminRepository.findByAdmEmail(email);
//	        return admin != null && admin.getAdm_password().equals(password);
//	}

}
