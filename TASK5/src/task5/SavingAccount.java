package task5;


class SavingAccount extends Account {
    
    private double interestRate;

    public SavingAccount(String accountNumber, String accountHolder, String password, double interestRate) {
        super(accountNumber, accountHolder, password);
        this.interestRate = interestRate;
    }

    public SavingAccount(String accountNumber, String accountHolder, String password, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, password, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest calculated: ₹" + interest);
        deposit(interest);
        System.out.println("Interest added to account!");
    }

    @Override
    public void withdraw(double amount) {
        if(balance - amount < 0){
            System.out.println("Cannot withdraw! Minimum balance of ₹0 required.");
        }else{
            super.withdraw(amount);
        }
    }
    
    public double getInterestRate(){
        return interestRate;
    }
    
    
}
