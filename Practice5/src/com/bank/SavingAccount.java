package com.bank;

public class SavingAccount extends Account{
	public SavingAccount(String acc, String na, double bal){
		super(acc, na, bal);
	}
	public boolean withdrawl(double m){
		if (balance <= 0 || m < 0)
			return false;
		if (balance >= m){
			balance -= m;
			return true;
		}
		return false;
	}
	
}
