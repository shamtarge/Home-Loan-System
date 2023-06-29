package com.homeloan.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.client.model.Client;
import com.homeloan.client.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	ClientService service;
	
	//All Clients
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getClient() {
		return service.getAllClient();
	}
	
	//Add client
	@PostMapping("/addClient")
	public String addClient(@RequestBody Client client) {
		service.addNewClient(client);
		return "Client Added Successfully";
	}
	
			
	//Update Client
	@PutMapping("/updateClient/{clientId}")
	public String updateClient(@RequestBody Client client ,@PathVariable("clientId") Long clientId){
		return service.updateClient(client, clientId);
	}
	
	//Delete Client
	@DeleteMapping("/deleteClient/{clientId}")
	public String deleteClient(@PathVariable("clientId") Long clientId) {
		return service.deleteClientById(clientId);
	}
			
	//Get Client by id
	@GetMapping("/clientId/{clientId}")
	public ResponseEntity<Client> getById(@PathVariable("clientId") Long clientId) {
		return service.getClientById(clientId);
	}
	
	//Get Client by userName
	@GetMapping("/clientName/{userName}")
	public ResponseEntity<Client> getByUserName(@PathVariable("userName") String userName) {
		return service.getClientByUserName(userName);
	}
	
	//Update Password
	@PutMapping("/updatePassword/{clientId}")
	public String updatePassword(@PathVariable("clientId") long clientId, @RequestBody String password) {
		return service.updatePassword(clientId,password);
	}
	
}
