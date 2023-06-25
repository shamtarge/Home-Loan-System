package com.homeloan.client.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.homeloan.client.model.Client;


public interface ClientService {
	String addNewClient(Client client);

	ResponseEntity<List<Client>> getAllClient();

	ResponseEntity<Client> getClientById(Long clientId);

	String updateClient(Client newClient, Long clientId);

	String deleteClientById(Long clientId);

}
