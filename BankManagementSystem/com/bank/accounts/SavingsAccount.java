package com.bank.accounts;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {

        double interest = balance * interestRate / 100;

        System.out.println("Interest: " + interest);

        return interest;
    }
}