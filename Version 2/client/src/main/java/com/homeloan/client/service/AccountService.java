package com.homeloan.client.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.homeloan.client.model.Account;

public interface AccountService {

	ResponseEntity<List<Account>> getAllAccounts();

	String addNewAccount(Account account);

	String deleteAccountById(Long accountId);

	ResponseEntity<Account> getAccountById(Long accountId);

	String update(Account newAccount, Long accountId);

	ResponseEntity<Account> getAccountByUserName(String userName);
	
	String updateStatus(String status, Long accountId);

}
