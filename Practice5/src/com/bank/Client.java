package com.bank;

public class Client {
	public static Bank create(){
		Bank bank = new Bank();
		bank.createAccount("100000000000", "John0", 10, 0);
		bank.createAccount("100000000001", "John1", 10, 0);
		bank.createAccount("100000000002", "John2", 10, 0);
		bank.createAccount("100000000003", "John3", 10, 0);
		
		bank.createAccount("100000000004", "John4", 10, 1);
		bank.createAccount("100000000005", "John5", 10, 1);
		bank.createAccount("100000000006", "John6", 10, 1);
		bank.createAccount("100000000007", "John7", 10, 1);
		
		bank.createAccount("100000000008", "John8", 10, 0);
		bank.createAccount("100000000009", "John9", 10, 0);
		
		return bank;
	}
	public static void main(String args[]){
		Bank bank = create();
		
		Account a1 = bank.createAccount("100000000019", "John9asdf", 10, 0);
		a1.deposit(20);
		a1.withdrawl(400);
		
		bank.removeAccount("100000000002");
		bank.removeAccount("asdfasdfadsf");
		
		Account a2 = bank.createAccount("100000000453", "John856", 10, 1);
		a2.deposit(100);
		a2.withdrawl(30);
		
		bank.removeAccount("100000000003");
		bank.removeAccount("100000000007");
		
		System.out.println("Account number: "+ bank.accountNumber());
		System.out.println("exist: "+bank.removeAccount("100000000008"));
		System.out.println("total balance: "+ bank.totalBalance());
		System.out.println("total overdrawn: "+ bank.totalOverdrawn());
		System.out.println("credit account number: "+ bank.numberOfCredit());
		System.out.println("saving account number: "+ bank.numberOfSaving());
	}
}
