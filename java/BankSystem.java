/*
*   A banking system which allows the user to register/login with their username
    and password and withdraw, deposit and view their balance.
*/

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to HacktoberBank!\n");
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1) Create an Account");
            System.out.println("2) Withdraw Money");
            System.out.println("3) Deposit Money");
            System.out.println("4) View Balance");
            System.out.println("0) Exit");
            System.out.print("> ");
            int choice = scanner.nextInt();
            if (choice==0) break;
            String username;
            String password;
            int amount;
            Account acc;
            switch (choice){
                case 1:
                    System.out.print("Username> ");
                    username = scanner.next();
                    System.out.print("Password> ");
                    password = scanner.next();
                    Account.create(username,password);
                    System.out.println("Successfully created account!");
                    break;
                case 2:
                    System.out.print("Username> ");
                    username = scanner.next();
                    System.out.print("Password> ");
                    password = scanner.next();
                    acc = Account.login(username, password);
                    if(acc==null){
                        break;
                    }
                    System.out.print("Amount> ");
                    amount = scanner.nextInt();
                    boolean check = acc.withdraw(amount);
                    if(check){
                        System.out.println("Withdrew "+amount+" rupees.");                        
                    }
                    break;
                case 3:
                    System.out.print("Username> ");
                    username = scanner.next();
                    System.out.print("Password> ");
                    password = scanner.next();
                    acc = Account.login(username, password);
                    if(acc==null){
                        break;
                    }
                    System.out.print("Amount> ");
                    amount = scanner.nextInt();
                    acc.deposit(amount);
                    System.out.println("Deposited "+amount+" rupees.");
                    break;
                case 4:
                    System.out.print("Username> ");
                    username = scanner.next();
                    System.out.print("Password> ");
                    password = scanner.next();
                    acc = Account.login(username, password);
                    if(acc==null){
                        break;
                    }
                    System.out.println("Balance: "+acc.getBalance());
                    break;
            }
            System.out.println();
        }

    }
}

class Account{
    private String username;
    private String password;
    private int balance;    // In 1/100th of a rupee aka paise.

    public static ArrayList<Account> accounts = new ArrayList<>();
    public static Account create(String username, String password){
        // TODO: Check validity of username and password
        Account account = new Account();
        account.username = username.toLowerCase();
        account.password = password;
        accounts.add(account);
        return account;
    }

    public static Account login(String username1, String password1) {
        username1 = username1.toLowerCase();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).username.equals(username1) && accounts.get(i).password.equals(password1)) {

                return accounts.get(i);
            } else if (!(accounts.get(i).password.equals(password1))) {
                System.out.println("Wrong password.");
                return null;
            } else {
                System.out.println("Could not find that user.");
                return null;
            }
        }return null;

    }



    public boolean withdraw(int amount){
        if(balance<amount){
            System.out.println("Invalid Amount Error!");
            System.out.println("Your Entered amount is less than available balance");
            System.out.println("Your current balance is "+balance);
            System.out.println("Please try again..");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public int getBalance(){
        return balance;
    }
}
