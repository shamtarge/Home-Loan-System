package com.homeloan.admin.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.homeloan.admin.model.Admin;

public interface AdminService {
	//Create
	String addAdmin(Admin admin);
	
	//Read
	ResponseEntity<List<Admin>> getAllAdmins();

	//Read by Id
	ResponseEntity<Admin> getAdminById(long adminId);

	//Update
	String updateAdminById(long adminId, Admin admin);

	//Delete
	String deleteAdminById(long adminId);

	String updatePassword(long adminId, String password);
}
