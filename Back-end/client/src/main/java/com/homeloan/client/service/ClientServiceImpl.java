package com.homeloan.client.service;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.homeloan.client.model.Client;
import com.homeloan.client.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepo;
	
	//Post
	@Override
	public boolean addNewClient(Client client){
		try {
			clientRepo.save(client);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//Get
	@Override
	public ResponseEntity<List<Client>> getAllClient(){
		List<Client> clientList = clientRepo.findAll();
		return new ResponseEntity<> (clientList, HttpStatus.OK);
	}

	//PUT
	@Override
	public ResponseEntity<String> updateClient(Client newClient, Long clientId) {
		
		Optional<Client> client = clientRepo.findById(clientId);
		if(client.isPresent()){
			newClient.setClient_id(clientId);
			clientRepo.save(newClient);
//		    return new ResponseEntity<> ("Client Updated Successfully", HttpStatus.OK);
		    return ResponseEntity.status(HttpStatus.OK).body("Client Updated Successfully");
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client NOt Found");
		
	}

	//Delete
	@Override
	public ResponseEntity<String> deleteClientById(Long clientId) {
		if (clientRepo.existsById(clientId)) {
			clientRepo.deleteById(clientId);
			return new ResponseEntity<> ("Client Deleted Successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<> ("Client Not Found", HttpStatus.OK);
	}
	
	//Get By Id
	@Override
	public ResponseEntity<Client> getClientById(Long clientId){
		
		Optional<Client> client = clientRepo.findById(clientId);
		
		if(client.isPresent()){
		    return new ResponseEntity<> (client.get(), HttpStatus.OK);
		}

	    return (ResponseEntity<Client>) ResponseEntity.notFound();
	}

	//Get By User Name
	@Override
	public ResponseEntity<Client> getClientByUserName(String userName) {
		Client client = clientRepo.returnClientByUserName(userName);
		return new ResponseEntity<> (client, HttpStatus.OK);
		
	}
	
	@Override
	public boolean findClientByUserName(String userName) {
		try {
			Client client = clientRepo.returnClientByUserName(userName);
			var clientId = client.getClient_id();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	@Override
	public boolean updatePassword(String username, String password) {
		try {
			clientRepo.updateClientpassword(username, password);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean findClientByPassword(String password, String userName) {
		try {
			Client client = clientRepo.findByPassword(password, userName);
			var clientId = client.getClient_id();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
