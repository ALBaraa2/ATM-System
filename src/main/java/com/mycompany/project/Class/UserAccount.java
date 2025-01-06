package com.mycompany.project.Class;


public class UserAccount {

    private String accountNumber;
    private String fullName;
    private String phoneNumber;
    private String password;
    private double balance;
    private int c;
    private int failedAttempts;

    public UserAccount(String accountNumber, String fullName, String phoneNumber,
                       String password, double balance, int failedAttempts) {
        this.accountNumber = accountNumber;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.balance = balance;
        this.failedAttempts = failedAttempts;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public int getC() {
        return c;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }
    public boolean setPassword(String password) {
        if (password.length() >= 6) {
            this.password = password;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return this.getBalance();
    }
}
