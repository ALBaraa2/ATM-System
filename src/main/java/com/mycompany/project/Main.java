package com.mycompany.project;

import com.mycompany.project.Class.ATMSystem;
import com.mycompany.project.Class.UserAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ATMSystem atmSystem = new ATMSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to ATM System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter Password: ");
                    String password = scanner.next();
                    UserAccount user = atmSystem.login(accountNumber, password);
                    if (user != null) {
                        System.out.println("You have successfully logged in!");
                        boolean check = true;
                        while (check) {
                            Scanner input = new Scanner(System.in);
                            System.out.println("Welcome " + user.getFullName());
                            System.out.println("1. Deposit Funds.");
                            System.out.println("2. Withdraw Funds.");
                            System.out.println("3. Check Balance.");
                            System.out.println("4. View Transaction History.");
                            System.out.println("5. Logout");
                            System.out.print("Enter your choice: ");

                            switch (input.nextInt()) {
                                case 1:
                                    System.out.print("Enter The amount to deposit: ");
                                    double depositAmount = input.nextDouble();
                                    atmSystem.performTransaction(user, "Deposit", depositAmount);
                                    break;
                                case 2:
                                    System.out.print("Enter The amount to withdraw: ");
                                    double withdrawAmount = input.nextDouble();
                                    atmSystem.performTransaction(user, "Withdraw", withdrawAmount);
                                    break;
                                case 3:
                                    System.out.println("Your Balance is: " + user.checkBalance());
                                    break;
                                case 4:
                                    atmSystem.viewTransactionHistory(user);
                                    break;
                                case 5:
                                    System.out.println("You have successfully logged out. Thank you for using our ATM system!");
                                    check = false;
                                    break;
                                default:
                                    System.out.println("Enter valid choice");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.next();
                    System.out.println("Password: password must at least 6 characters");
                    String newPassword = scanner.next();
                    while (newPassword.length() < 6) {
                        System.out.print("Please add another password: ");
                        newPassword = scanner.next();
                    }
                    UserAccount user1 = atmSystem.register(fullName, phoneNumber, newPassword);
                    break;
                case 3:
                    System.out.println("Exiting ATM System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
