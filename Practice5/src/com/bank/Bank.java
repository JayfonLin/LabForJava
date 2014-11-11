package com.bank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank {
	private List<Account> accountList;
	protected int t;
	public Bank(){
		accountList = new ArrayList<Account>();
	}
	/**
	 * type为0信用卡账户,type为1存储卡账户
	 * @param acc
	 * @param name
	 * @param balance
	 * @param type
	 * @return
	 */
	public Account createAccount(String acc, String name, double balance, int type){
		if (!accountExist(acc)){
			Account account = null;
			if (type == 0){
				account = new CreditAccount(acc, name, balance); 
				accountList.add(account);
				return account;
			}else if (type == 1){
				account = new SavingAccount(acc, name, balance);
				accountList.add(account);
				return account;
			}
			return null;
		}
		return null;
	}
	public boolean removeAccount(String acc){
		if (accountExist(acc)){
			for (Account account:accountList){
				if (account.getAccount().equals(acc)){
					accountList.remove(account);
					return true;
				}
			}
			return false;
		}
		return false;
	}
	public boolean accountExist(String acc){
		for (Account account:accountList){
			if (account.getAccount().equals(acc)){
				accountList.remove(account);
				return true;
			}
		}
		return false;
	}
	public double totalBalance(){
		double total = 0.0;
		for (Account account:accountList){
			total += account.query();
		}
		return total;
	}
	public double totalOverdrawn(){
		double total = 0.0;
		for (Account account:accountList){
			if (account.query() < 0){
				total += account.query();
			}
		}
		return -total;
	}
	public int accountNumber(){
		return accountList.size();
	}
	public int numberOfCredit(){
		int num = 0;
		for (Account account:accountList){
			if (account instanceof CreditAccount){
				++num;
			}
		}
		return num;
	}
	public int numberOfSaving(){
		int num = 0;
		for (Account account:accountList){
			if (account instanceof SavingAccount){
				++num;
			}
		}
		return num;
	}
}
