package com.bank;

public class CreditAccount extends Account{
	protected double overdrawn = 1000.0;
/*	public CreditAccount(){
		super();
	}*/
	public CreditAccount(String acc, String na, double bal){
		super(acc, na, bal);
	}
	public CreditAccount(String acc, String na, double bal, double over){
		super(acc, na, bal);
		overdrawn = over;
	}
	@Override
	public boolean withdrawl(double m){
		if (balance <= -overdrawn || m < 0)
			return false;
		if (balance - m >= -overdrawn){
			balance -= m;
			return true;
		}
		return false;
	}
}
