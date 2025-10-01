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
        // Format to 2 decimal places
        String formattedInterest = String.format("%.2f", interest);
        double roundedInterest = Double.parseDouble(formattedInterest);
    
        System.out.println("Interest calculated: ₹" + roundedInterest);
        deposit(roundedInterest);
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
