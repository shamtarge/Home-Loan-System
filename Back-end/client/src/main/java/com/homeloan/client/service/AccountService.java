package com.homeloan.client.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.homeloan.client.model.Account;

public interface AccountService {

	ResponseEntity<List<Account>> getAllAccounts();

	boolean addNewAccount(Account account);

	ResponseEntity<String> deleteAccountById(Long accountId);

	ResponseEntity<Account> getAccountById(Long accountId);

	ResponseEntity<String> update(Account newAccount, Long accountId);

	ResponseEntity<Account> getAccountByUserName(String userName);
	
	ResponseEntity<String> updateStatus(String status, Long accountId);

	ResponseEntity<String> updateAmountToPay(long amount, long accountId);

	ResponseEntity<String> updatePremiumAmount(long amount, long accountId);

	ResponseEntity<String> updatePrincipleAmount(long amount, long accountId);

}
