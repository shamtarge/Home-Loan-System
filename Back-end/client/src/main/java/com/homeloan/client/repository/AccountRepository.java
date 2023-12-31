package com.homeloan.client.repository;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homeloan.client.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query(value = "select * from account where client_id = (select client_id from client where user_name = :userName);", nativeQuery = true)
	public Account findByUserName(@Param("userName") String userName);
	
	@Modifying
	@Transactional
	@Query(value = "update account set status = :status where account_id = :accountId", nativeQuery = true)
	public void updateStatusOfAccount(@Param("accountId") long accountId, @Param("status") String status);

	@Modifying
	@Transactional
	@Query(value = "update account set amount_to_pay = :amount where account_id = :accountId", nativeQuery = true)
	public void updateTotalAmountToPay(@Param("amount")long amount,@Param("accountId") long accountId);

	@Modifying
	@Transactional
	@Query(value = "update account set premium_amount = :amount where account_id = :accountId", nativeQuery = true)
	public void updateMonthlyPremiumAmount(@Param("amount")long amount,@Param("accountId") long accountId);
	
	@Modifying
	@Transactional
	@Query(value = "update account set principle_ammount = :amount where account_id = :accountId", nativeQuery = true)
	public void updateMonthlyPrincipleAmount(@Param("amount")long amount,@Param("accountId") long accountId);
}
