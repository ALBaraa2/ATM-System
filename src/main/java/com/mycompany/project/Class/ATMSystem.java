package com.mycompany.project.Class;


import java.util.*;

public class ATMSystem {

    private List<UserAccount> usersAccounts;

    public ATMSystem() {
        usersAccounts = FileHandler.loadUserAccounts();
    }

    public UserAccount login(String accountNumber, String password) {

        for (int i = 0; i < usersAccounts.size(); i++) {
            if (usersAccounts.get(i).getAccountNumber().equals(accountNumber)) {
                usersAccounts.get(i).setC(i);
                return usersAccounts.get(i);
            }
        }
        System.out.println("Account number or password incorrect");
        return null;
    }

    public UserAccount register(String fullName, String phoneNumber, String password) {
        UserAccount userAccount = new UserAccount(generateAccountNumber(), fullName, phoneNumber, password, 0);
        usersAccounts.add(userAccount);
        FileHandler.saveUserAccounts(usersAccounts);
        System.out.println("Account created successfully. Your account number is: " + userAccount.getAccountNumber());
        return userAccount;
    }

    public void performTransaction(UserAccount userAccount, String transactionType, double amount) {
        switch (transactionType) {
            case "Deposit":
                if (userAccount.deposit(amount)) {
                    usersAccounts.get(userAccount.getC()).setBalance(userAccount.getBalance());
                    FileHandler.saveUserAccounts(usersAccounts);
                    FileHandler.addTransaction(userAccount.getAccountNumber(), "Deposit an amount of: " + amount);
                    System.out.println("Deposit successful! \nYour amount is: " + userAccount.getBalance());
                } else {
                    System.out.println("Deposit failed!");
                }
                break;
            case "Withdraw":
                if (userAccount.withdraw(amount)) {
                    usersAccounts.get(userAccount.getC()).setBalance(userAccount.getBalance());
                    FileHandler.saveUserAccounts(usersAccounts);
                    FileHandler.addTransaction(userAccount.getAccountNumber(), "Withdraw an amount of: " + amount);
                    System.out.println("Withdraw Successful!\nYour amount is: " + userAccount.getBalance());
                } else {
                    System.out.println("Error: Insufficient balance. Your current balance is: " + userAccount.checkBalance());
                }
                break;
            default:
                System.out.println("Invalid transaction type");
        }
    }

    public void viewTransactionHistory(UserAccount user) {
        FileHandler.viewTransactionHistory(user.getAccountNumber());
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }
}
