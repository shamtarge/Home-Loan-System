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
	public String addNewClient(Client client){
		clientRepo.save(client);
		return "Client Added Successfully";
	}
	
	//Get
	@Override
	public ResponseEntity<List<Client>> getAllClient(){
		List<Client> clientList = clientRepo.findAll();
		return new ResponseEntity<> (clientList, HttpStatus.OK);
	}

	//PUT
	@Override
	public String updateClient(Client newClient, Long clientId) {
		
		Optional<Client> client = clientRepo.findById(clientId);
		if(client.isPresent()){
			newClient.setClient_id(clientId);
			clientRepo.save(newClient);
		    return "Client Updated Successfully";
		}
		
		return "Client Not Found";
		
	}

	//Delete
	@Override
	public String deleteClientById(Long clientId) {
		if (clientRepo.existsById(clientId)) {
			clientRepo.deleteById(clientId);
			return "Client Deleted Successfully";
		}
		
		return "Client Not Found";
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
		Client client = clientRepo.findByUserName(userName);
		return new ResponseEntity<> (client, HttpStatus.OK);
		
//		if(client.isPresent()){
//		    return new ResponseEntity<> (client.get(), HttpStatus.OK);
//		}
//
//		return (ResponseEntity<Client>) ResponseEntity.notFound();
	}

	@Override
	public String updatePassword(long clientId, String password) {
		if(clientRepo.existsById(clientId)) {
			clientRepo.updateClientpassword(clientId, password);
			return "Password Updated Successfully";
		}
		return "Client Not Found";
	}
}
