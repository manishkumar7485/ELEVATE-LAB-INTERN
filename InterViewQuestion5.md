## Interview Questions & Answers

## Task 5: Bank Account Simulation

### 1. What is inheritance in Java?

*** Answer: ***  ``Inheritance`` is an ```OOP concept``` that allows ```one class (child/derived class) to acquire the properties and behaviors of another class (parent/base class).``` It promotes ```code reusability and establishes a relationship between classes.```
```java
class Account {
    double balance;
    void deposit(double amt) { balance += amt; }
}

class SavingsAccount extends Account {
    double interestRate = 0.05;
    double calculateInterest() { return balance * interestRate; }
}
```

---
### 2. Why use this keyword?

*** Answer: *** The ``this`` keyword refers to the current ```object of the class.``` It is used to resolve naming conflicts between ```instance variables and parameters```, ```to call another constructor in the same class, and to return the current object.```

```java
class Customer {
    String name;
    Customer(String name) {
        this.name = name; // resolves conflict between variable and parameter
    }
}
```

---
### 3. What is method overriding vs overloading?

*** Answer: ***

*** Overloading: *** ```Having multiple methods with the same name but different parameter lists within the same class.```

*** Overriding: *** ```Providing a specific implementation of a method in the subclass that is already defined in the superclass.```

```java
class Bank {
    void service() { System.out.println("General bank services"); }
    void loan(int amount) { System.out.println("Loan of " + amount); } // Overloading
}

class HDFCBank extends Bank {
    @Override
    void service() { System.out.println("HDFC specific services"); } // Overriding
}
```

---
### 4. What is object instantiation?

*** Answer: *** ```Object instantiation``` is the process of creating an object from a class using the ``new`` keyword.

```java
Account acc = new Account();  // Object instantiation
acc.deposit(1000);
```

---
### 5. Explain single vs multiple inheritance.

*** Answer: ***

**Single Inheritance:** A class inherits from only ```one superclass```.

**Multiple Inheritance:** A class inherits from ```multiple superclasses```. In Java, multiple inheritance is ```not supported with classes to avoid ambiguity,``` but it is achieved using ```interfaces.```

```java
interface OnlineBanking { void netBanking(); }
interface MobileBanking { void mobileApp(); }

class DigitalBank implements OnlineBanking, MobileBanking {
    public void netBanking() { System.out.println("Net banking active"); }
    public void mobileApp() { System.out.println("Mobile app active"); }
}
```

---
### 6. What is encapsulation?

*** Answer: *** ``Encapsulation`` is the process of ```wrapping data (fields) and methods``` into a ```single unit (class)```. It is achieved using ```private variables and public getter/setter methods``` to control access.

```java
class Account {
    private int pin;
    public void setPin(int pin) { this.pin = pin; }
    public int getPin() { return pin; }
}
```

---
### 7. What is constructor overloading?

*** Answer: *** ``` Constructor overloading ``` is defining multiple constructors in the same class with different parameter lists. It allows objects to be initialized in different ways.

```java
class Account {
    String name; double balance;
    Account(String n) { name = n; balance = 0; }
    Account(String n, double b) { name = n; balance = b; }
}
```

---
### 8. Can we override static methods?

*** Answer: *** `` No,`` ``` static``` methods cannot be overridden because they belong to the class, not to instances. However, they can be hidden by declaring another static method in the subclass.

```java
class Bank {
    static void showBank() { System.out.println("General Bank"); }
}
class ICICIBank extends Bank {
    static void showBank() { System.out.println("ICICI Bank"); } // Hides, not overrides
}
```

---
### 9. What is runtime polymorphism?

*** Answer: *** ``` Runtime polymorphism (dynamic method dispatch) ``` occurs when a method call is resolved at runtime rather than compile time. It is achieved through method ```overriding and upcasting```.

```java
Bank b = new HDFCBank();  
b.service();  // Output: HDFC specific services
```
---

### 10. Difference between class and object?

*** Answer: ***
``` Class: ``` A blueprint or template that defines attributes and behaviors.
``` Object: ``` An instance of a class created in memory at runtime.

```java
class Account { String name; double balance; }
Account acc1 = new Account(); // Object of Account class
```