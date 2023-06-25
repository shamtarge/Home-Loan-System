package com.homeloan.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.homeloan.admin.model.Admin;
import com.homeloan.admin.repository.AdminRepository;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepo;
	
	//Get
	@Override
	public ResponseEntity<List<Admin>> getAllAdmins(){
		List<Admin> adminList = adminRepo.findAll();
		return new ResponseEntity<> (adminList,HttpStatus.OK);
	}

	//Post
	@Override
	public String addAdmin(Admin admin) {
		adminRepo.save(admin);
		return "Admin Added SuccessFully";
	}

	//Get By Id
	@Override
	public ResponseEntity<Admin> getAdminById(long adminId) {
		Optional<Admin> admin = adminRepo.findById(adminId);
		if(admin.isPresent()){
		    return new ResponseEntity<> (admin.get(), HttpStatus.OK);
		}
		return (ResponseEntity<Admin>) ResponseEntity.notFound();
	}

	//Put
	@Override
	public String updateAdminById(long adminId, Admin newAdmin) {
		Optional<Admin> admin = adminRepo.findById(adminId); 
		if(admin.isPresent()) {
			newAdmin.setAdminId(adminId);
			adminRepo.save(newAdmin);
			return "Admin Updated Successfully";
		}
		return "Admin not Found";
	}

	//Delete
	@Override
	public String deleteAdminById(long adminId) {
		Optional<Admin> admin = adminRepo.findById(adminId); 
		if(admin.isPresent()) {
			adminRepo.deleteById(adminId);
			return "Admin Deleted Successfully";
		}
		return "Admin not Found";
	}
	
}
