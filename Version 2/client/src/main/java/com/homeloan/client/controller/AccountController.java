package com.homeloan.client.controller;

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

import com.homeloan.client.model.Account;
import com.homeloan.client.service.AccountService;

@RestController
public class AccountController {


	@Autowired
	AccountService service;
	
	//All Account
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAccounts() {
		return service.getAllAccounts();
	}
	
	//Add account
	@PostMapping("/addAccount")
	public String addAccount(@RequestBody Account account) {
		return service.addNewAccount(account);
	}
	
			
	//Update Account
	@PutMapping("/updateAccount/{accountId}")
	public String updateAccount(@RequestBody Account account ,@PathVariable("accountId") Long accountId){
		return service.update(account, accountId);
	}
	
	//Delete Account
	@DeleteMapping("/deleteAccount/{accountId}")
	public String deleteAccount(@PathVariable("accountId") Long accountId) {
		return service.deleteAccountById(accountId);
	}
			
	//Get Account by id
	@GetMapping("/accountId/{accountId}")
	public ResponseEntity<Account> getById(@PathVariable("accountId") Long accountId) {
		return service.getAccountById(accountId);
	}
	
	//Get Client by userName
	@GetMapping("/account/{userName}")
	public ResponseEntity<Account> getByUserName(@PathVariable("userName") String userName) {
		return service.getAccountByUserName(userName);
	}
	
	//Update status of Account
	@PutMapping("/updateStatus/{accountId}")
	public String updateStatus(@RequestBody String status, @PathVariable("accountId") long accountId) {
		return service.updateStatus(status, accountId);
	}
	
}
