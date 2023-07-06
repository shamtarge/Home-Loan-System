package com.homeloan.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.client.model.Account;
import com.homeloan.client.service.AccountService;

//@CrossOrigin(origins = "http://localhost:4200/*")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	public boolean addAccount(@RequestBody Account account) {
		return service.addNewAccount(account);
	}
	
			
	//Update Account
	@PutMapping("/updateAccount/{accountId}")
	public ResponseEntity<String> updateAccount(@RequestBody Account account ,@PathVariable("accountId") Long accountId){
		return service.update(account, accountId);
	}
	
	//Delete Account
	@DeleteMapping("/deleteAccount/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountId") Long accountId) {
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
	public ResponseEntity<String> updateStatus(@RequestBody String status, @PathVariable("accountId") long accountId) {
		return service.updateStatus(status, accountId);
	}
	
	//Update AmountToPay of Account
	@PutMapping("/updateAmount/{accountId}")
	public ResponseEntity<String> updateAmount(@RequestBody long amount, @PathVariable("accountId") long accountId) {
		return service.updateAmountToPay(amount, accountId);
	}
	
	//Update AmountToPay of Account
	@PutMapping("/updatePremium/{accountId}")
	public ResponseEntity<String> updatePremium(@RequestBody long amount, @PathVariable("accountId") long accountId) {
		return service.updatePremiumAmount(amount, accountId);
	}
	
	@PutMapping("/updatePrinciple/{accountId}")
	public ResponseEntity<String> updatePrinciple(@RequestBody long amount, @PathVariable("accountId") long accountId) {
		return service.updatePrincipleAmount(amount, accountId);
	}
}
