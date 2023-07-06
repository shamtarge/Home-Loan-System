package com.homeloan.client.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long account_Id;
	private String home_address;
	private long loan_ammount;
	private long period;
	private double interest;
	private long salary;
	private String status;
	private long amount_to_pay;
	private long premium_amount;
	private long principle_ammount;

	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Client client_id;
	
	public Account() {}

	public Account(long account_Id, String home_address, long loan_ammount, long period, double interest, long salary,
			Client client_id) {
		super();
		this.account_Id = account_Id;
		this.home_address = home_address;
		this.loan_ammount = loan_ammount;
		this.period = period;
		this.interest = interest;
		this.salary = salary;
		this.client_id = client_id;
		this.status = "Pending";
		this.amount_to_pay = 0;
		this.setPremium_amount(0);
		this.setPrinciple_ammount(0);
	}
	

	public Account(long account_Id, String home_address, long loan_ammount, long period, double interest, long salary,
			String status, long amountToPay,long premiumAmount, long principle, Client client_id) {
		super();
		this.account_Id = account_Id;
		this.home_address = home_address;
		this.loan_ammount = loan_ammount;
		this.period = period;
		this.interest = interest;
		this.salary = salary;
		this.status = status;
		this.client_id = client_id;
		this.amount_to_pay = amountToPay;
		this.setPremium_amount(premiumAmount);
		this.setPrinciple_ammount(principle);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public long getAccount_Id() {
		return account_Id;
	}

	public void setAccount_Id(long account_Id) {
		this.account_Id = account_Id;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public long getLoan_ammount() {
		return loan_ammount;
	}

	public void setLoan_ammount(long loan_ammount) {
		this.loan_ammount = loan_ammount;
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Client getClient_id() {
		return client_id;
	}

	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}

	public long getAmount_to_pay() {
		return amount_to_pay;
	}

	public void setAmount_to_pay(long amount_to_pay) {
		this.amount_to_pay = amount_to_pay;
	}

	public long getPremium_amount() {
		return premium_amount;
	}

	public void setPremium_amount(long premium_amount) {
		this.premium_amount = premium_amount;
	}

	public long getPrinciple_ammount() {
		return principle_ammount;
	}

	public void setPrinciple_ammount(long principle_ammount) {
		this.principle_ammount = principle_ammount;
	};
	
}
