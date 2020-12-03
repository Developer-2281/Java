package com.adamp.bank;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			BankAccount account1 = new BankAccount(1000, 1000);
			System.out.println(account1.accountNum());
			System.out.println(account1.savingsBalance());
			System.out.println(account1.checkingBalance());
			System.out.println(account1.depositChecking(1000000));
			System.out.println(account1.depositSavings(1000000));
			System.out.println(account1.accountBalance());
			System.out.println(account1.withdrawlChecking(500000));
			System.out.println(account1.withdrawlSavings(500000));
			System.out.println(account1.withdrawlChecking(5000000));
			System.out.println(account1.withdrawlSavings(5000000));
			System.out.println(account1.accountNum());
			System.out.println(BankAccount.totalAccts());
			BankAccount account2 = new BankAccount(1000, 1000);
			System.out.println(account2.depositSavings(1000000));
			System.out.println(BankAccount.totalAccts());
	}

}
