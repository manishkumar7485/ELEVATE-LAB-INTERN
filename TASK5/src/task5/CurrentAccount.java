package task5;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, String password, double overdraftLimit) {
        super(accountNumber, accountHolder, password);
        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccount(String accountNumber, String accountHolder, String password, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolder, password, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if( amount > 0 && (balance - amount) >= -overdraftLimit){
            balance-=amount;
            addTransaction("Withdrawal: -₹" + amount);
            System.out.println("Successfully withdrew: ₹"+ amount);
            
            if(balance < 0){
                System.out.println("Warning: Account in overdraft! Current balance: ₹" + balance);
            }
        }else{
            System.out.println("Withdrawal failed! Exceeds overdraft limit.");
        }    
    }    

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    
    
}
