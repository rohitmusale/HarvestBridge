package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.Admin;
import com.harvestBridge.repository.AdminRepository;
import com.harvestBridge.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService {
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin createAdmin(Admin admin) {
		Admin adm = adminRepo.save(admin);
		return adm;
	}

	@Override
	public Admin getAdminById(int id) {
		Optional<Admin> adm1 = adminRepo.findById(id);
		
		if(adm1.isPresent()) {
			return adm1.get();		
		}
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Admin existingAdmin = adminRepo.findById(admin.getAID()).get();
		existingAdmin.setAName(admin.getAName());
		existingAdmin.setAEmail(admin.getAEmail());
		existingAdmin.setAMobNo(admin.getAMobNo());
		existingAdmin.setAAddress(admin.getAAddress());
		
		Admin updateAdmin = adminRepo.save(existingAdmin);
		return updateAdmin;
	}

	@Override
	public void deleteAdmin(int id) {
		adminRepo.deleteById(id);
		
	}

}
