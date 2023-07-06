package com.homeloan.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.client.model.Client;
import com.homeloan.client.service.ClientService;

//@CrossOrigin(origins = "http://localhost:4200/*")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	public boolean addClient(@RequestBody Client client) {
		return service.addNewClient(client);
	}
	
			
	//Update Client
	@PutMapping("/updateClient/{clientId}")
	public ResponseEntity<String> updateClient(@RequestBody Client client ,@PathVariable("clientId") Long clientId){
		return service.updateClient(client, clientId);
	}
	
	//Delete Client
	@DeleteMapping("/deleteClient/{clientId}")
	public ResponseEntity<String> deleteClient(@PathVariable("clientId") Long clientId) {
		return service.deleteClientById(clientId);
	}
			
	//Get Client by id
	@GetMapping("/clientId/{clientId}")
	public ResponseEntity<Client> getById(@PathVariable("clientId") Long clientId) {
		return service.getClientById(clientId);
	}
	
	//Get Client by userName
	@GetMapping("/client/{userName}")
	public ResponseEntity<Client> getByUserName(@PathVariable("userName") String userName) {
		return service.getClientByUserName(userName);
	}
	
	@GetMapping("/searchUserName/{userName}")
	public boolean findByUserName(@PathVariable("userName") String userName) {
		return service.findClientByUserName(userName);
	}
	
	@PostMapping("/searchPassword/{password}")
	public boolean findByPassword(@PathVariable("password") String password,@RequestBody String userName) {
		return service.findClientByPassword(password, userName);
	}
	
	//Update Password
	@PutMapping("/updatePassword/{username}")
	public boolean updatePassword(@PathVariable("username") String username, @RequestBody String password) {
		return service.updatePassword(username,password);
	}
	
}
