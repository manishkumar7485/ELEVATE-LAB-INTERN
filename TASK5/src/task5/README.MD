## Task 5: Bank Account Simulation

* *** Objective: *** Simulate basic bank operations using Java OOP.
* *** Tools: *** Java, VS Code, Terminal.
* *** Deliverables: *** Class-based Java program with transactions.

### Features of This Project:

*** 🔐 Authentication System ***
* Login with account number and password
* Secure password management

### 🏦 Account Management
* Create new savings or current accounts
* Automatic account number generation
* Account type-specific features

### 💰 Banking Operations
* Deposit money
* Withdraw money with validation
* Check balance
* View transaction history
* Calculate interest (for savings accounts)

### 🛡️ Security Features
* Password protection
* Password change functionality
* Input validation

### 📊 Sample Data
* Pre-loaded with 4 sample accounts for testing: 

```Test Accounts:```
* Savings: SAV001/1234, SAV002/5678
* Current: CUR001/9999, CUR002/0000

*** Sample Usage Flow: ***
```java
text
🏦 === BANK MANAGEMENT SYSTEM ===
1. Login to Account
2. Create New Account
3. Exit
Choose an option: 1

🔐 === ACCOUNT LOGIN ===
Enter Account Number: SAV001
Enter Password: 1234

✅ Login successful! Welcome, John Doe

💼 === ACCOUNT DASHBOARD ===
Welcome, John Doe
Account: SAV001
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. View Transaction History
5. Calculate Interest
6. Change Password
7. Logout
Account Type: Savings Account
Choose an option: 1

Enter amount to deposit: $500
✅ Successfully deposited: $500.0
```

### OOP Concepts Demonstrated:
* Encapsulation - Private fields with public methods
* Inheritance - SavingsAccount and CurrentAccount extend Account
* Polymorphism - Method overriding for withdraw and calculateInterest
* Abstraction - Hide complex implementation details
* Constructor Overloading - Multiple ways to create accounts

### Outcomes:

*** 1. Core Java OOP Implementation ***
* ✅Successfully implemented class-based Java program with multiple classes
* ✅Created inheritance hierarchy (Account → SavingsAccount, CurrentAccount)
* ✅Applied encapsulation with private fields and public getters
* ✅ Demonstrated method overriding and polymorphism

*** 2. Banking System Features ***
* ✅ Account Management: Create, login, and manage multiple account types
* ✅ Transaction Processing: Deposit, withdraw with validation
* ✅ Balance Management: Real-time balance updates and checks
* ✅ Transaction History: Complete audit trail of all operations
* ✅ Interest Calculation: Automated interest for savings accounts
* ✅ Overdraft Facility: Limited overdraft for current accounts

*** 3. Security & Validation ***
* ✅ Authentication System: Password-protected account access
* ✅ Input Validation: Robust error handling for invalid inputs
* ✅ Business Rules: Minimum balance, overdraft limits enforcement
* ✅ Password Management: Secure password change functionality