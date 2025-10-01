
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
//        accounts.put("SAV001", new SavingAccount("SAV001", "John Doe", "1234", 10000.0, 2.5));
//        accounts.put("SAV002", new SavingAccount("SAV002", "Alice Smith", "5678", 5000.0, 3.0));
//        accounts.put("CUR001", new CurrentAccount("CUR001", "Bob Johnson", "9999", 2000.0, 15.0));
//        accounts.put("CUR002", new CurrentAccount("CUR002", "Carol Williams", "0000", 15000.0, 15.0));
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
                    createAccount();
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
    
    private static void createAccount(){
        System.out.println("\n === CREATE NEW ACCOUNT ===");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        System.out.print("Choose account type: ");
        
        int type = getIntInput();
        scanner.nextLine();
        
        System.out.print("Enter Account Holder Name: ");
        String holder = scanner.nextLine();
        System.out.print("Set Password: ");
        String password = scanner.nextLine();
        
        String accNumber = generateAccountNumber(type);
        
        switch (type) {
            case 1:
                {
                    //Saving Account
                    System.out.print("Enter Initial Deposit: ₹");
                    double deposit = getDoubleInput();
                    SavingAccount account = new SavingAccount(accNumber, holder, password, deposit, 2.5);
                    accounts.put(accNumber, account);
                    System.out.println("Savings Account created successfully!");
                    System.out.println("Account Number: " + accNumber);
                    break;
                }
            case 2:
                {
                    //Current Account
                    System.out.print("Enter Initial Deposit: ₹");
                    double deposit = getDoubleInput();
                    CurrentAccount account = new CurrentAccount(accNumber, holder, password, deposit, 15.0);
                    accounts.put(accNumber, account);
                    System.out.println("Currents Account created successfully!");
                    System.out.println("Account Number: " + accNumber);
                    break;
                }
            default:
                System.out.println("Invalid Account type!");
                break;
        }
    }    
    
    private static String generateAccountNumber( int type){
        String prefix = (type == 1) ? "SAV" : "CUR";
        int number = accounts.size() + 1;
        
        return prefix + String.format("%03d", number);
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
                    depositeMoney();
                    break;
                case 2:
                    withdrawMoney();
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
                    changePassword();
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
    
    private static void depositeMoney(){
        System.out.print("Enter amount to deposit: ₹");
        double amount = getDoubleInput();
        currentAccount.deposit(amount);
    }
    
    private static void withdrawMoney(){
        System.out.print("Enter amount to withdraw: ₹");
        double amount = getDoubleInput();
        currentAccount.withdraw(amount);
    }   
    
    private static void changePassword(){
        System.out.print("Enter current password: ");
        String currentPass = scanner.nextLine();
        
        if(currentAccount.authenticate(currentPass)){
            System.out.print("Enter new password: ");
            String newPass = scanner.nextLine();
            currentAccount.changePassword(newPass);
            System.out.println("Password changed successfully!");
        }else{
            System.out.println("Current password is incorrect!");
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
    
    private static void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("❌ No accounts found!");
            return;
        }
    
        System.out.println("\n🏦 === ALL BANK ACCOUNTS ===");
        System.out.println("┌─────┬────────────┬──────────────────┬──────────────┬───────────────┐");
        System.out.println("│ No.     │ Account No          │ Account Holder            │ Type                  │ Balance                 │");
        System.out.println("├─────┼────────────┼──────────────────┼──────────────┼──────────────  ┤");
    
        int index = 1;
        for (Account account : accounts.values()) {
            String type = (account instanceof SavingAccount) ? "Savings" : 
            (account instanceof CurrentAccount) ? "Current" : "Basic";
        
            System.out.printf("│ %-3d │ %-10s              │ %-16s                      │ %-12s                 │ RS.%-11.2f              │\n",index++,account.getAccountNumber(),account.getAccountHolder(),
                type,
                account.getBalance());
        }
        System.out.println("└─────┴────────────┴──────────────────┴──────────────┴──────────────┘");
    }
    
}
