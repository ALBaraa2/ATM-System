package com.mycompany.project.Class;

import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<UserAccount> loadUserAccounts() {
        List<UserAccount> userAccounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String accountNumber = data[0];
                String fullName = data[1];
                String phoneNumber = data[2];
                String password = data[3];
                double balance = Double.parseDouble(data[4]);
                userAccounts.add(new UserAccount(accountNumber, fullName, phoneNumber, password, balance));
            }
        } catch (IOException e) {
            System.out.println("Error loading user accounts: " + e.getMessage());
        }
        return userAccounts;
    }

    public static void saveUserAccounts(List<UserAccount> userAccounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", false))) {  // false للتأكد من الكتابة فوق الملف بالكامل
            for (UserAccount user : userAccounts) {
                writer.write(user.getAccountNumber() + "," +
                        user.getFullName() + "," +
                        user.getPhoneNumber() + "," +
                        user.getPassword() + "," +
                        user.getBalance());  // كتابة الرصيد المعدل
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving user accounts: " + e.getMessage());
        }
    }

    public static void addTransaction(String accountNumber, String transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {  // true لتمكين append
            writer.write("Account number: " + accountNumber + ", Transaction: " + transaction);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    public static void viewTransactionHistory(String accountNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String[] accountNumberi = data[0].split(": ");
                if (accountNumberi[1].equals(accountNumber)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("This user doesn't make any transaction ");
        }
    }
}
