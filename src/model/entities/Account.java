package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public Double deposit(Double amount) {
		return this.balance += amount;
	}
	
	public Double withdraw(Double amount) {
		if(amount > withdrawLimit) {
			throw new DomainException("Withdraw error: the amount exceds withdraw limit");
		}
		if(amount > balance) {
			throw new DomainException("Withdraw error: not enough balance");
		}
		
		this.balance -= amount;
		return null;
	}

	@Override
	public String toString() {
		return "Account number: " + number + ", holder: " + holder + ", balance: " + balance + ", withdrawLimit "
				+ withdrawLimit;
	}
	
	
	

}
