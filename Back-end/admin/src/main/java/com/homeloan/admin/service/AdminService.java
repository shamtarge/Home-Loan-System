package com.homeloan.admin.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.homeloan.admin.model.Admin;

public interface AdminService {
	//Create
	ResponseEntity<String> addAdmin(Admin admin);
	
	//Read
	ResponseEntity<List<Admin>> getAllAdmins();

	//Read by Id
	ResponseEntity<Admin> getAdminById(long adminId);

	//Update
	ResponseEntity<String> updateAdminById(long adminId, Admin admin);

	//Delete
	ResponseEntity<String> deleteAdminById(long adminId);

	boolean updatePassword(String username, String password);

	boolean searchByUserName(String userName);

	boolean searchByPassword(String password);

	ResponseEntity<Admin> getAdminByUserName(String userName);

	boolean findAdminByPassword(String password, String userName);
}
