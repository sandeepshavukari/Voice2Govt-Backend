package com.ssd.Voice2Govt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.Voice2Govt.dto.AdminDto;
import com.ssd.Voice2Govt.entity.Admin;
import com.ssd.Voice2Govt.service.AdminService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
	@Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
        AdminDto createdAdmin = adminService.createAdmin(adminDto);
        return ResponseEntity.ok(createdAdmin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id) {
        AdminDto adminDto = adminService.getAdminById(id);
        return ResponseEntity.ok(adminDto);
    }

    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        List<AdminDto> adminList = adminService.getAllAdmins();
        return ResponseEntity.ok(adminList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id, @RequestBody AdminDto updatedAdmin) {
        AdminDto adminDto = adminService.updateAdmin(id, updatedAdmin);
        return ResponseEntity.ok(adminDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully.");
    }
//    @PostMapping("/login")
//    public ResponseEntity<String> loginAdmin(@RequestBody AdminDto adminDto) {
//        boolean isAuthenticated = adminService.authenticateAdmin(adminDto.getAdm_email(), adminDto.getAdm_password());
//        if (isAuthenticated) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid email or password");
//        }
//    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("adminId") Long adminId, @RequestParam("admPassword") String admPassword, HttpSession session) {
        AdminDto admin = adminService.loginAdmin(adminId, admPassword);

        if (admin != null) {
            // Store user details in the session
            session.setAttribute("firstName", admin.getAdm_firstName());
            session.setAttribute("lastName", admin.getAdm_lastName());
            
            // Redirect to a dashboard or home page
            ModelAndView modelAndView = new ModelAndView("welcomePage");
            modelAndView.addObject("firstName", admin.getAdm_firstName());
            modelAndView.addObject("lastName", admin.getAdm_lastName());
            return modelAndView;
        } else {
            // Return login failure message
            return new ModelAndView("loginPage", "message", "Invalid login credentials");
        }
    }

    // Logout method to invalidate the session
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidates the session
        return "redirect:/login"; // Redirect to login page
    }
}


