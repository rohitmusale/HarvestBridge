package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Admin;

public interface AdminService {
	Admin createAdmin(Admin admin);
	Admin getAdminById(int id);
	List<Admin> getAllAdmin();
	Admin updateAdmin(Admin admin);
	void deleteAdmin(int id);
}
