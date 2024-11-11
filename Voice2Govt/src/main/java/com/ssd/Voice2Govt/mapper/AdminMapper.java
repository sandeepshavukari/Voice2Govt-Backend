package com.ssd.Voice2Govt.mapper;

import com.ssd.Voice2Govt.dto.AdminDto;
import com.ssd.Voice2Govt.entity.Admin;

public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin) {
        return new AdminDto(
            admin.getAdm_id(),
            admin.getAdm_firstName(),
            admin.getAdm_lastName(),
            admin.getAdm_email(),
            admin.getAdm_phoneNumber(),
            admin.getAdm_dob(),
            admin.getAdmUsername(),
            admin.getAdmPassword()
        );
    }

    public static Admin mapToAdmin(AdminDto adminDto) {
        return new Admin(
            adminDto.getAdm_id(),
            adminDto.getAdm_firstName(),
            adminDto.getAdm_lastName(),
            adminDto.getAdm_email(),
            adminDto.getAdm_phoneNumber(),
            adminDto.getAdm_dob(),
            adminDto.getAdmUsername(),
            adminDto.getAdmPassword()
        );
    }
}
