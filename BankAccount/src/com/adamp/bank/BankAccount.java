package com.adamp.bank;
import java.util.Random;
// recreated BankAccount Project and pasted in previous work as unable to rename default package

public class BankAccount {
	
	//member variables
	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;

	//class variables
	
	protected static int totalAccounts = 0;
	protected static double totalUserHoldings = 0;
	
	public BankAccount(double checkingBalance, double savingsBalance) {
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		this.accountNumber = accountGenerate(); // In the constructor, call the private method from above so that each user has a random ten digit account.
	}
	
	private static String accountGenerate() {
		Random rand = new Random();
		String numpool = "0123456789";
		String newaccount = "";
		for(int x=0; x < 10; x++) {
			int num = rand.nextInt(10);
			newaccount = newaccount + numpool.charAt(num);
		}
		totalAccounts++;
		return newaccount;
	}
	
	protected double checkingBalance() {
		System.out.println("Your current balance is " + checkingBalance);
		return checkingBalance;
	}
	
	protected double savingsBalance() {
		System.out.println("Your current balance is " + savingsBalance);
		return savingsBalance;
	}
	
	protected double depositSavings(double deposit) {
		savingsBalance += deposit;
		System.out.println("You have deposited $" + deposit + ". Your balance is $" + savingsBalance);
		totalUserHoldings = totalUserHoldings + deposit;
		return savingsBalance;
	}
	
	protected double depositChecking(double deposit) {
		checkingBalance += deposit;
		System.out.println("You have deposited $" + deposit + ". Your balance is $" + checkingBalance);
		totalUserHoldings = totalUserHoldings + deposit;
		return checkingBalance;
	}

	protected double withdrawlSavings(double withdrawl) {
		if(savingsBalance < withdrawl) {
			System.out.println("Insuffecient Funds");
		}
		
        else {
        	savingsBalance -= withdrawl;
    		totalUserHoldings = totalUserHoldings - withdrawl;
        	System.out.println("You have withdrawn $" + withdrawl + ". Your balance is $" + savingsBalance);
        }
		return savingsBalance;
	}

	protected double withdrawlChecking(double withdrawl) {
		if(checkingBalance < withdrawl) {
			System.out.println("Insuffecient Funds");
		}
		
        else {
        	checkingBalance -= withdrawl;
    		totalUserHoldings = totalUserHoldings - withdrawl;
        	System.out.println("You have withdrawn $" + withdrawl + ". Your balance is $" + checkingBalance);
        }
		return checkingBalance;
	}
	
	protected double accountBalance() {
		double accountBalance = savingsBalance + checkingBalance;
		System.out.println("Your account balance is $" + accountBalance);
		return accountBalance;
	}
	
	protected String accountNum() {
		return this.accountNumber;
	}
	
	protected static int totalAccts() {
		return totalAccounts;
	}
}