package com.homeloan.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.homeloan.client.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	
	@Query(value = "SELECT * FROM client WHERE user_Name = :userName", nativeQuery = true)
	public Client findByUserName(@Param("userName") String userName);

	@Modifying
	@Transactional
	@Query(value = "update client set password = :password where client_id = :clientId", nativeQuery = true)
	public void updateClientpassword(@Param("clientId")long clientId, @Param("password")String password);

}
