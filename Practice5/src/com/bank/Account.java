package com.bank;

public abstract class Account {
	protected String account;
	protected String name;
	protected double balance;
	public Account(){
		balance = 0.0d;
	}
	public Account(String acc, String na, double bal){
		account = acc;
		name = na;
		balance = bal;
	}
	public boolean deposit(double m){
		if (m <= 0)
			return false;
		balance += m;
		return true;
	}
	public abstract boolean withdrawl(double m);
	public double query(){
		return balance;
	}
	public String getAccount() {
		return account;
	}
	public String getName() {
		return name;
	}
	
}
