package task5;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String accountNumber;
    private String accountHolder;
    protected double balance;
    private ArrayList<String> transactionHistory;
    private String password;
    
    
    //Constructors
    public Account(String accountNumber, String accountHolder, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        this.password = password;
        addTransaction("Account created with initial balance: ₹ 0.0");
    }
    
    public Account(String accountNumber, String accountHolder, String password, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.password = password;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial balance: ₹ " + initialBalance);
    }
    
    
    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    
    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    
    public void changePassword(String newPassword) {
        this.password = newPassword;
        addTransaction("Password changed successfully");
    }
    
    public void deposit(double amount){
        if(amount > 0){
            balance +=amount;
            addTransaction("Deposite: +₹"+amount);
            System.out.println("Successfully deposited: ₹ "+amount);
        }else{
            System.out.println("Invalid deposite amount!");
        }
    }
    
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            addTransaction("Withdrawal: -₹"+amount);
            System.out.println("Successfully withdrew: ₹"+amount);
        }else{
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    
    public void checkBalance(){
        System.out.println("Current balance: ₹"+balance);
    }
    
    public void calculateInterest(){
        System.out.println("Interest calculation not available for basic amount.");
    }
    
    
    public void addTransaction(String transaction) {
        String timestamp = new Date().toString();
        transactionHistory.add(timestamp + " - " + transaction);
    }
    
    public void showTransactionHistory(){
        System.out.println("\n === Transaction History for Account: "+ accountNumber + " ===");
        if(transactionHistory.isEmpty()){
            System.out.println("No transaction yet.");
        }else{
            for(int i =0; i< transactionHistory.size(); i++){
                System.out.println((i+1)+". "+transactionHistory.get(i));
            }
        }
    }
    
    
    
}
