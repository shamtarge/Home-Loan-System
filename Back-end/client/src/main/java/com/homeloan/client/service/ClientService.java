package com.homeloan.client.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.homeloan.client.model.Client;


public interface ClientService {
	boolean addNewClient(Client client);

	ResponseEntity<List<Client>> getAllClient();

	ResponseEntity<String> updateClient(Client newClient, Long clientId);

	ResponseEntity<String> deleteClientById(Long clientId);

	ResponseEntity<Client> getClientById(Long clientId);
	
	ResponseEntity<Client> getClientByUserName(String userName);
	
	boolean updatePassword(String username, String password);

	boolean findClientByUserName(String userName);

	boolean findClientByPassword(String password, String userName);

}
