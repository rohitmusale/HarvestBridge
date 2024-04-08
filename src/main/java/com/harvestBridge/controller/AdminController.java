package com.harvestBridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harvestBridge.entity.Admin;
import com.harvestBridge.service.AdminService;

import jakarta.validation.Valid;


@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	@PostMapping("/admin")
	public Admin saveAdmin(@Valid @RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}
	
//	@PostMapping("/admin")
//	public Admin saveAdmin(@Valid @RequestBody Admin admin) {
//		return adminService.createAdmin(admin);
//	}
	
	@GetMapping("/admin/{id}")
	public Admin getAdminById(@PathVariable("id")int id) {
		return adminService.getAdminById(id);
	}
	
	@GetMapping("admin/getAllData")
	public List<Admin> getAllAdmin(){
		List<Admin> admin = adminService.getAllAdmin();
		return admin;
	}
	
	@PutMapping("/admin/update/{id}")
	public Admin updateAdmin(@PathVariable("id") int id, @RequestBody Admin admin) {
		admin.setAID(id);
		Admin updateAdmin = adminService.updateAdmin(admin);
		return updateAdmin;
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public void deleteAdmin(@PathVariable int id) {
		adminService.deleteAdmin(id);
		System.out.println("Delete from admin table Successfully");
	}
}
