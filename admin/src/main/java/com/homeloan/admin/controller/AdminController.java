package com.homeloan.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.admin.model.Admin;
import com.homeloan.admin.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
	
	//Get
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins(){
		return service.getAllAdmins();
	}
	
	//Post
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody Admin admin) {
		return service.addAdmin(admin);
	}
	
	//Get By Id
	@GetMapping("/admin/{adminId}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("adminId") long adminId) {
		return service.getAdminById(adminId);
	}
	
	//Put
	@PutMapping("/updateAdmin/{adminId}")
	public String updateAdmin(@PathVariable("adminId") long adminId, @RequestBody Admin admin) {
		return service.updateAdminById(adminId, admin);
	}
	
	//Delete
	@DeleteMapping("/deleteAdmin/{adminId}")
	public String deleteAdmin(@PathVariable("adminId") long adminId) {
		return service.deleteAdminById(adminId);
	}
	
}
