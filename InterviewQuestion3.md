# Java Developer Internship - Interview Questions & Answers

## Task 3: Library Management System (OOP Project)

### 1. What is Abstraction?  
**Answer:**  
Abstraction is the process of hiding implementation details and showing only the essential features of an object.  
In Java, abstraction can be achieved using **abstract classes** and **interfaces**.  
For example, when you call `car.start()`, you don’t need to know how the engine starts internally.

---

### 2. Difference between Interface and Abstract Class?  
**Answer:**  
| Aspect | Abstract Class | Interface |
|--------|----------------|-----------|
| Methods | Can have abstract and concrete methods | Can have only abstract methods (Java 7), default & static methods allowed (Java 8+) |
| Variables | Can have instance variables | Only `public static final` constants |
| Inheritance | A class can extend **only one** abstract class | A class can implement **multiple** interfaces |
| Use Case | When classes share common behavior but need specialization | When classes must follow a contract |

---

### 3. Explain Polymorphism with Example.  
**Answer:**  
Polymorphism means **one name, many forms**. It allows objects to behave differently based on their context.  
- **Compile-time (Overloading):** Same method name with different parameters.  
- **Runtime (Overriding):** Subclass provides specific implementation of a method from its superclass.  

Example:  
```java
class Animal {
    void sound() { System.out.println("Animal makes sound"); }
}
class Dog extends Animal {
    void sound() { System.out.println("Dog barks"); }
}
```
Here, the `sound()` method behaves differently depending on the object.

---

### 4. What is Method Overriding?  
**Answer:**  
Method overriding occurs when a subclass provides a specific implementation for a method already defined in its parent class.  
Rules:  
- Must have the **same method signature**.  
- Must have the **same return type** (or covariant).  
- Access modifier must not be more restrictive.  
- Achieved at **runtime**.  

---

### 5. Explain “IS-A” vs “HAS-A” Relationships.  
**Answer:**  
- **IS-A (Inheritance):** Defines a parent-child relationship. Example: `Dog IS-A Animal`.  
- **HAS-A (Composition):** Defines ownership or usage. Example: `Library HAS-A Book`.  

---

### 6. Why Use Inheritance?  
**Answer:**  
- Promotes **code reusability**.  
- Supports **polymorphism**.  
- Helps in building a **hierarchical class structure**.  
Example: All animals inherit from a base `Animal` class.  

---

### 7. What is Dynamic Binding?  
**Answer:**  
Dynamic Binding (Late Binding) occurs when the method call is resolved at **runtime**, not at compile-time.  
Example:  
```java
Animal a = new Dog();
a.sound();  // Dog’s sound() is called, not Animal’s
```

---

### 8. What is Constructor Chaining?  
**Answer:**  
Constructor chaining means calling one constructor from another in the same or parent class using `this()` or `super()`.  
It helps avoid code duplication.  

Example:  
```java
class A {
    A() { System.out.println("A’s constructor"); }
}
class B extends A {
    B() {
        super();  // Calls A’s constructor
        System.out.println("B’s constructor");
    }
}
```

---

### 9. How to Implement Encapsulation?  
**Answer:**  
Encapsulation means **binding data and methods together** and restricting direct access.  
In Java:  
- Declare fields as `private`.  
- Provide `public` getters and setters.  

Example:  
```java
class Student {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

---

### 10. Explain `super` Keyword.  
**Answer:**  
The `super` keyword is used to:  
1. Call the **parent class constructor**.  
2. Access **parent class methods**.  
3. Access **parent class fields**.  

Example:  
```java
class Animal {
    String type = "Animal";
}
class Dog extends Animal {
    String type = "Dog";
    void printType() {
        System.out.println(super.type); // Prints "Animal"
    }
}
```
