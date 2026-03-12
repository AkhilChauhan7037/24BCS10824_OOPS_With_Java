package com.bank.accounts;

import com.bank.exceptions.InsufficientBalanceException;

public class Account {

    protected int accountNumber;
    protected double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposit successful. Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal amount exceeds balance");
        }

        balance = balance - amount;
        System.out.println("Withdrawal successful. Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}