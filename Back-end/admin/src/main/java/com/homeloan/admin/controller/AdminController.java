package com.homeloan.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.admin.model.Admin;
import com.homeloan.admin.service.AdminService;

//@CrossOrigin(origins = "http://localhost:4200/*")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
		return service.addAdmin(admin);
	}
	
	//Get By Id
	@GetMapping("/admin/{adminId}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("adminId") long adminId) {
		return service.getAdminById(adminId);
	}
	@GetMapping("/adminUserName/{userName}")
	public ResponseEntity<Admin> getAdminByName(@PathVariable("userName") String userName) {
		return service.getAdminByUserName(userName);
	}
	
	//Put
	@PutMapping("/updateAdmin/{adminId}")
	public ResponseEntity<String> updateAdmin(@PathVariable("adminId") long adminId, @RequestBody Admin admin) {
		return service.updateAdminById(adminId, admin);
	}
	
	//Delete
	@DeleteMapping("/deleteAdmin/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("adminId") long adminId) {
		return service.deleteAdminById(adminId);
	}
	
	//Update Password
	@PutMapping("/updatePassword/{username}")
	public boolean updatePassword(@PathVariable("username") String username, @RequestBody String password) {
		return service.updatePassword(username, password);
	}
	
	@GetMapping("/searchUserName/{userName}")
	public boolean searchUserName(@PathVariable("userName") String userName) {
		return service.searchByUserName(userName);
	}
	
	@GetMapping("/searchPassword/{password}")
	public boolean searchPassword(@PathVariable("password") String password) {
		return service.searchByPassword(password);
	}
	
	@PostMapping("/searchAdminPassword/{password}")
	public boolean findAdminByPassword(@PathVariable("password") String password, @RequestBody String username) {
		return service.findAdminByPassword(password, username);
	}
}
