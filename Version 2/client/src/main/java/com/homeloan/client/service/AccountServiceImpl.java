package com.homeloan.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.homeloan.client.model.Account;
import com.homeloan.client.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepo;
	
	//Get
	@Override
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> account = accountRepo.findAll();
		return new ResponseEntity<> (account, HttpStatus.OK);
	}
	
	//Post
	@Override
	public String addNewAccount(Account account) {
		accountRepo.save(account);
		return "New Account Added Successfully";
	}

	//Delete
	@Override
	public String deleteAccountById(Long accountId) {
		if(accountRepo.existsById(accountId)) {
			accountRepo.deleteById(accountId);
			return "Account Deleted Successfully";
		}
		return "Account Not Found";
	}

	//Put
	@Override
	public String update(Account newAccount, Long accountId) {
		Optional<Account> account= accountRepo.findById(accountId);
		if(account.isPresent()){
			newAccount.setAccount_Id(accountId);
			accountRepo.save(newAccount);
		    return "Account Updated Successfully";
		}
		
		return "Account Not Found";
	}

	//Get by ID
	@Override
	public ResponseEntity<Account> getAccountById(Long accountId) {
		Optional<Account> account= accountRepo.findById(accountId);
		if(account.isPresent()){
			return new ResponseEntity<> (account.get(), HttpStatus.OK);
		}
		return (ResponseEntity<Account>) ResponseEntity.notFound();
	}

	//Get by client username
	@Override
	public ResponseEntity<Account> getAccountByUserName(String userName) {
		Account account = accountRepo.findByUserName(userName); 
		return new ResponseEntity<> (account, HttpStatus.OK);
	}

	@Override
	public String updateStatus(String status, Long accountId) {
		if(accountRepo.existsById(accountId)){
			accountRepo.updateStatusOfAccount(accountId,status);
		    return "Account Status Updated Successfully";
		}
		
		return "Account Not Found";
	}
	
	
}
