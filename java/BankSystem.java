/*
*   A banking system which allows the user to register/login with their username
    and password and withdraw, deposit and view their balance.
*/

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Boolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to HacktoberBank!\n");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1) Create an Account");
            System.out.println("2) Withdraw Money");
            System.out.println("3) Deposit Money");
            System.out.println("4) View Balance");
            System.out.println("0) Exit");
            System.out.print("> ");
            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            String username;
            String password;
            int amount;
            Account acc;
            switch (choice) {
            case 1:
                System.out.print("Username> ");
                username = scanner.next();
                System.out.print("Password> ");
                password = scanner.next();
                Account.create(username, password);

                break;
            case 2:
                System.out.print("Username> ");
                username = scanner.next();
                System.out.print("Password> ");
                password = scanner.next();
                acc = Account.login(username, password);
                if (acc == null) {
                    break;
                }
                System.out.print("Amount> ");
                amount = scanner.nextInt();
                if (acc.withdraw(amount) == true)
                    System.out.println("Withdrew " + amount + " rupees.");
                break;
            case 3:
                System.out.print("Username> ");
                username = scanner.next();
                System.out.print("Password> ");
                password = scanner.next();
                acc = Account.login(username, password);
                if (acc == null) {
                    break;
                }
                System.out.print("Amount> ");
                amount = scanner.nextInt();
                acc.deposit(amount);
                System.out.println("Deposited " + amount + " rupees.");
                break;
            case 4:
                System.out.print("Username> ");
                username = scanner.next();
                System.out.print("Password> ");
                password = scanner.next();
                acc = Account.login(username, password);
                if (acc == null) {
                    break;
                }
                System.out.println("Balance: " + acc.getBalance());
                break;
            }
            System.out.println();
        }

    }
}

class Account {
    private String username;
    private String password;
    private int balance; // In 1/100th of a rupee aka paise.

    public static ArrayList<Account> accounts = new ArrayList<>();

    public static Account create(String username, String password) {
        if (validate(username, password)) {

            Account account = new Account();
            account.username = username.toLowerCase();
            account.password = password;
            accounts.add(account);
            System.out.println("Successfully created account!");
            return account;
        }

        System.out.println("\nFailed to create account!");
        return null;
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
        }
        return null;

    }

    public Boolean withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Operation Failed due to insufficient account balance");
            return false;
        } else {
            balance -= amount;
        }
        return true;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public static boolean validate(String username1, String password1) {

        username1 = username1.toLowerCase();

        Pattern pattern = Pattern.compile("^(?=.{3,15}$)(?![0-9])[a-zA-Z0-9_]*$");
        Matcher matcher = pattern.matcher(username1);
        boolean valusn = matcher.find();

        if (valusn) {
        
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).username.equals(username1)) {
    
                    System.out.println("\nUsername already exists");
                    return false;
    
                }
            }

            pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-.\\/:;<=>?@\\[\\]\\^\\_`{\\|\\}~])(?=\\S+$).{8,30}$");
            matcher = pattern.matcher(password1);
            boolean valpas = matcher.find();

            if (valpas) {
                return true;
            }
            else
            {
                System.out.println("\nPassword should be 8 to 30 characters long, \nmust contain atleast one uppercase letter, one lowercase letter, one number, \nand one special character from !\"#$%&'()*+,-./:;<=>?@[]^_`{|}~");
                return false;
            }

        }
        else
        {
            System.out.println("Username should be 3 to 15 characters long, cannot start with a number and can only contain alphanumerics and _");
            return false;
        }
        
    }
}
