# Java Developer Internship - Interview Questions & Answers

## Task 1: Java Console Calculator


### 1. What is method overloading?

**Answer:** Method overloading is a feature in Java that allows a class to have multiple methods with the same name but different parameters. The difference can be in the number of parameters, data types of parameters, or order of parameters. The compiler determines which method to call based on the method signature.

**Example:**
```java
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c) { return a + b + c; }
}
```

---
### 2. How do you handle divide-by-zero?
*** Answer: ***Divide-by-zero is handled using exception handling. In Java, division by zero for integers throws an ArithmeticException, while for floating-point numbers it returns Infinity or NaN. We can use try-catch blocks to handle this gracefully.

*** Example: ***
```java
public static double divide(double num1, double num2) {
    if (num2 == 0) {
        throw new ArithmeticException("Error: Division by zero is not allowed!");
    }
    return num1 / num2;
}
```
---
### 3. Difference between == and .equals()?
*** Answer: ***
*** == operator:*** Compares primitive values for equality or checks if two object references point to the same memory location.

*** .equals() method:*** Compares the actual content/values of objects (mainly used for String comparison).

*** Example: ***
```java
String str1 = new String("hello");
String str2 = new String("hello");

System.out.println(str1 == str2);      // false (different objects)
System.out.println(str1.equals(str2)); // true (same content)
```
---
### 4. What are the basic data types in Java?
*** Answer: *** Java has 8 primitive data types:
- byte: 8-bit integer (-128 to 127)
- short: 16-bit integer (-32,768 to 32,767)
- int: 32-bit integer (most commonly used)
- long: 64-bit integer
- float: 32-bit floating point
- double: 64-bit floating point (most commonly used for decimals)
- char: 16-bit Unicode character
- boolean: true/false values

---
### 5. How is Scanner used for input?
*** Answer: *** Scanner is a class in java.util package used to read input from various sources like keyboard, files, etc.
*** Basic usage: ***
```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = scanner.nextInt();
double decimal = scanner.nextDouble();
String text = scanner.nextLine();
scanner.close();
```
----
### 6. Explain the role of a loop.
*** Answer: *** A loop is a control structure that allows repeated execution of a block of code until a specific condition is met. It helps in reducing code repetition and automating repetitive tasks.

***Types of loops in Java: ***
- for loop: When number of iterations is known

- while loop: When number of iterations is unknown

- do-while loop: Executes at least once before checking condition

---

### 7. Difference between while and for loop?
*** Answer: ***
- for loop: Used when the number of iterations is known beforehand. It has initialization, condition, and increment/decrement in one line.

- while loop: Used when the number of iterations is unknown. It only has a condition.

***Example:***
```java
// for loop - known iterations
for(int i = 0; i < 5; i++) {
    System.out.println(i);
}

// while loop - unknown iterations
while(condition) {
    // code to execute
}
```
---
### 8. What is the JVM?
*** Answer: *** JVM (Java Virtual Machine) is an abstract machine that provides the runtime environment in which Java bytecode can be executed. It is platform-dependent and performs tasks like:

- Loading code

- Verifying code

- Executing code

- Providing runtime environment

- Key features: Write Once, Run Anywhere (WORA) capability.

---

### 9. How is Java platform-independent?
*** Answer: ***Java is platform-independent due to:
- Bytecode: Java code is compiled into bytecode (.class files) rather than machine-specific code

- JVM: Each platform has its own JVM that interprets bytecode into machine-specific instructions

- WORA Principle: Write Once, Run Anywhere - same bytecode runs on any platform with a JVM

---
### 10. How do you debug a Java program?
*** Answer: *** Debugging techniques in Java:

- Print Statements: Using System.out.println() to track variable values

- IDE Debugger: Using breakpoints, step into, step over, watch variables in IDEs like IntelliJ or Eclipse

- Exception Stack Traces: Analyzing error messages and stack traces

- Logging: Using logging frameworks like Log4j or java.util.logging

- Unit Testing: Writing tests to identify issues

*** Example using print debugging: ***
```java
public static void divide(double a, double b) {
    System.out.println("Debug: a=" + a + ", b=" + b);
    if(b == 0) {
        System.out.println("Debug: Division by zero attempted");
        return;
    }
    double result = a / b;
    System.out.println("Debug: Result=" + result);
}
```