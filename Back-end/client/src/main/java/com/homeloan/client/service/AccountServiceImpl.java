package com.homeloan.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.homeloan.client.model.Account;
import com.homeloan.client.model.Client;
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
	public boolean addNewAccount(Account account) {
		try {
			accountRepo.save(account);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	//Delete
	@Override
	public ResponseEntity<String> deleteAccountById(Long accountId) {
		if(accountRepo.existsById(accountId)) {
			accountRepo.deleteById(accountId);
			return new ResponseEntity<> ("Account Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<> ("Account Not Found", HttpStatus.OK);
	}

	//Put
	@Override
	public ResponseEntity<String> update(Account newAccount, Long accountId) {
		Optional<Account> account= accountRepo.findById(accountId);
		if(account.isPresent()){
			newAccount.setAccount_Id(accountId);
			accountRepo.save(newAccount);
			return new ResponseEntity<> ("Account Updated Successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<> ("Account Not Found", HttpStatus.OK);
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
	public ResponseEntity<String> updateStatus(String status, Long accountId) {
		if(accountRepo.existsById(accountId)){
			accountRepo.updateStatusOfAccount(accountId,status);
			return new ResponseEntity<> ("Account Status Updated Successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<> ("Account Not Found", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateAmountToPay(long amount, long accountId) {
		if(accountRepo.existsById(accountId)){
			accountRepo.updateTotalAmountToPay(amount,accountId);
			return new ResponseEntity<> ("Amount Updated Successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<> ("Account Not Found", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updatePremiumAmount(long amount, long accountId) {
		if(accountRepo.existsById(accountId)){
			accountRepo.updateMonthlyPremiumAmount(amount,accountId);
			return new ResponseEntity<> ("Premium Amount Updated Successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<> ("Account Not Found", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updatePrincipleAmount(long amount, long accountId) {
		if(accountRepo.existsById(accountId)){
			accountRepo.updateMonthlyPrincipleAmount(amount,accountId);
			return new ResponseEntity<> ("Premium Amount Updated Successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<> ("Account Not Found", HttpStatus.OK);
	}
	
	
}
