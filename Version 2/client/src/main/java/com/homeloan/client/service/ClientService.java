package com.homeloan.client.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.homeloan.client.model.Client;


public interface ClientService {
	String addNewClient(Client client);

	ResponseEntity<List<Client>> getAllClient();

	String updateClient(Client newClient, Long clientId);

	String deleteClientById(Long clientId);

	ResponseEntity<Client> getClientById(Long clientId);
	
	ResponseEntity<Client> getClientByUserName(String userName);
	
	String updatePassword(long clientId, String password);

}
