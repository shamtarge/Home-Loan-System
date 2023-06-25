package com.homeloan.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.client.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
