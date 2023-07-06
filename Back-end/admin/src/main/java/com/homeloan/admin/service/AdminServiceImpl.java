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
	public ResponseEntity<String> addAdmin(Admin admin) {
		adminRepo.save(admin);
		return new ResponseEntity<>("Admin Added SuccessFully", HttpStatus.OK);
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
	public ResponseEntity<String> updateAdminById(long adminId, Admin newAdmin) {
		Optional<Admin> admin = adminRepo.findById(adminId); 
		if(admin.isPresent()) {
			newAdmin.setAdminId(adminId);
			adminRepo.save(newAdmin);
			return new ResponseEntity<>("Admin Updated Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
	}

	//Delete
	@Override
	public ResponseEntity<String> deleteAdminById(long adminId) {
		Optional<Admin> admin = adminRepo.findById(adminId); 
		if(admin.isPresent()) {
			adminRepo.deleteById(adminId);
			return new ResponseEntity<>("Admin Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
	}
	
	//Update Password
	@Override
	public boolean updatePassword(String username, String password) {
		try {
			adminRepo.updatePasswordByUsername(username,password);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean searchByUserName(String userName) {
		try {
			Admin admin = adminRepo.searchAdminByUserName(userName);
			var adminId = admin.getAdminId();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean searchByPassword(String password) {
		try {
			Admin admin = adminRepo.searchAdminByPassword(password);
			var adminId = admin.getAdminId();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public ResponseEntity<Admin> getAdminByUserName(String userName) {
		try {
			Admin admin = adminRepo.searchAdminByUserName(userName);
			return new ResponseEntity<> (admin, HttpStatus.OK);	
		}
		catch(Exception e){
			return (ResponseEntity<Admin>) ResponseEntity.notFound();
		}
	}
	
	@Override
	public boolean findAdminByPassword(String password, String userName) {
		try {
			Admin admin = adminRepo.findByPassword(password, userName);
			var adminId = admin.getAdminId();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
}
