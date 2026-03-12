package com.bank;

import com.bank.accounts.*;
import com.bank.customers.Customer;
import com.bank.loans.Loan;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.util.BankUtil;

public class BankApplication {

    public static void main(String[] args) {

        try {

            int accNo = BankUtil.generateAccountNumber();

            SavingsAccount account = new SavingsAccount(accNo, 5000, 5);

            Customer customer = new Customer(1, "Akhil");

            customer.linkAccount(account);

            account.deposit(2000);

            account.withdraw(1000);

            account.calculateInterest();

            Loan loan = new Loan(100000, 5, 2);

            loan.calculateEMI();

            customer.displayCustomerDetails();

        } 
        catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        } 
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}