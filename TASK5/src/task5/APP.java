
package task5;

import java.util.HashMap;
import java.util.Scanner;

public class APP {
    
    private static HashMap<String, Account> accounts = new HashMap<>();
  
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount = null;
    
    public static void main(String[] args) {
            initializeSampleDate();
            showMainMenu();
    }

    private static void initializeSampleDate() {
        // Create some sample accounts
        accounts.put("SAV001", new SavingAccount("SAV001", "John Doe", "1234", 10000.0, 2.5));
        accounts.put("SAV002", new SavingAccount("SAV002", "Alice Smith", "5678", 5000.0, 3.0));
        accounts.put("CUR001", new CurrentAccount("CUR001", "Bob Johnson", "9999", 2000.0, 50.0));
        accounts.put("CUR002", new CurrentAccount("CUR002", "Carol Williams", "0000", 15000.0, 30.0));
    }
    
    
    private static void showMainMenu() {
        while(true){
            System.out.println("\n === BANK MANAGEMENT SYSTEM ===");
            System.out.println("1. Login to Account");
            System.out.println("2. Create new Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = getIntInput();
            
            switch(choice){
                case 1:
                    login();
                    break;
                case 2:
//                    createAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using our Bank System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }            
        }
    }
    
    private static void login(){
        System.out.println("\n === Account Login ===");
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        if(accounts.containsKey(accNumber)){
            Account account = accounts.get(accNumber);
            if(account.authenticate(password)){
                currentAccount = account;
                System.out.println("Login successful! Welcome, "+ account.getAccountHolder());
                showAccountMenu();
            }else{
                System.out.println("Invalid password!");
            }
        }else{
            System.out.println("Account not found!");
        }
    }
    
    
    
    private static void showAccountMenu(){
        while(currentAccount != null){
            System.out.println("\n === ACCOUNT DASHBOARD ===");
            System.out.println("Welcome, "+currentAccount.getAccountHolder());
            System.out.println("Account: "+currentAccount.getAccountNumber());
            System.out.println("1.Deposite Money");
            System.out.println("2.Withdraw Money");
            System.out.println("3.Check Balance");
            System.out.println("4.View Transaction History");
            System.out.println("5.Calculate Interest");
            System.out.println("6.Change Password");
            System.out.println("7.Logout");
            
            if(currentAccount instanceof SavingAccount){
                System.out.println("Account Type: Saving Account");
            }else if(currentAccount instanceof CurrentAccount){
                System.out.println("Account Type: Current Account");
            }
            
            System.out.print("Choose an option:");
            int choice  = getIntInput();
            
            switch(choice){
                case 1:
//                    depositeMoney();
                    break;
                case 2:
//                    withdrawMoney();
                    break;
                case 3:
                    currentAccount.checkBalance();
                    break;
                case 4:
                    currentAccount.showTransactionHistory();
                    break;
                case 5:
                    currentAccount.calculateInterest();
                    break;
                case 6:
//                    changePassword();
                    break;
                case 7:
                    System.out.println("Logged out successfully.");
                    currentAccount = null;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
    
    
    
    
    
    
    private static int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
    
    private static double getDoubleInput() {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid amount!");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
    
}
