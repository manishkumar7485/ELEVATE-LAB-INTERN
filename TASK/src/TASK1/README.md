# TASK #1 -> Java Console Calculator
* A simple console-based calculator application built with Java as part of a Java Developer Internship Task 1.

## Features
- <i>Basic Arithmetic Operations: Addition, Subtraction, Multiplication, and Division
- <ii>User-Friendly Interface: Interactive menu-driven console interface
- <iii>Error Handling: Robust exception handling for invalid inputs and division by zero
- <iv>Continuous Operation: Allows multiple calculations in a single session
- <v>Formatted Output: Clean and readable result display

# Operations Supported
- <i>➕ Addition (+)
- <ii>➖ Subtraction (-)
- <iii>✖️ Multiplication (*)
- <iv>➗ Division (/)

### Welcome to Java Console Calculator!

#### === Java Console Calculator ===
- 1. Addition (+)
- 2. Subtraction (-)
- 3. Multiplication (*)
- 4. Division (/)
- 5. Exit
- Choose an operation (1-5): 1
- Enter first number: 15
- Enter second number: 4
- Result: 15 + 4 = 19

=== Java Console Calculator ===
- 1. Addition (+)
- 2. Subtraction (-)
- 3. Multiplication (*)
- 4. Division (/)
- 5. Exit
- Choose an operation (1-5): 4
- Enter first number: 10
- Enter second number: 0
- Error: Division by zero is not allowed!

### Code Structure
-  - add(int num1, int num2): Performs addition
-  - subtract(int num1, int num2): Performs subtraction
-  - multiply(int num1, int num2): Performs multiplication
-  - divide(double num1, double num2): Performs division with zero-check
-  - displayMenu(): Shows the calculator menu
-  - main(String[] args): Main method with program loop and user interaction

### Key Java Concepts Demonstrated
- Methods: Separate methods for each arithmetic operation
- Scanner Class: For user input handling
- Loops: While loop for continuous operation
- Conditionals: Switch statements for menu selection
- Exception Handling: Try-catch blocks for error management
- Data Types: Proper use of primitive data types


### Error Handling
#### The calculator handles various error scenarios:

- - ❌ Division by zero attempts
- - ❌ Invalid numeric inputs
- - ❌ Menu selection out of range
- - ❌ Unexpected runtime errors

### Learning Outcomes
#### This project helped reinforce:
- - Java syntax and basic programming constructs
- - Object-Oriented Programming principles
- - Input/Output operations in Java
- - Control flow and logical operations
- - Debugging and error handling techniques