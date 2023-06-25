package com.homeloan.client.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long client_id;
	
	private String userName;
	private String password;
	
	public Client() {}
	
	public Client(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public long getClient_id() {
		return client_id;
	}

	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
