
# 📘 Java Developer Internship - Interview Questions & Answers

## Task 2. Student Record Management System (Java CLI)

---

### 1. What is encapsulation?
**Answer:**  
Encapsulation is the process of hiding the internal details of a class and only exposing controlled access through getters and setters.  
- Example: Making fields private and accessing them via public methods.  
- Benefit: Improves security, maintainability, and reusability.  

```java
class Student {
    private String name;   // private field

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
}
```

---

### 2. How are ArrayLists different from arrays?
**Answer:**  
- **Array** → Fixed size, faster, can store primitives and objects.  
- **ArrayList** → Dynamic size (can grow/shrink), stores only objects, provides built-in methods (`add`, `remove`, `contains`, etc.).  

```java
// Array
int[] marks = new int[5];  

// ArrayList
import java.util.ArrayList;
ArrayList<Integer> marksList = new ArrayList<>();
marksList.add(90);
marksList.add(85);
```

---

### 3. How to sort an ArrayList?
**Answer:**  
- Use `Collections.sort()` or a `Comparator`.  

```java
import java.util.*;

public class SortExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");

        Collections.sort(names); // natural order
        System.out.println(names);

        Collections.sort(names, Comparator.reverseOrder()); // descending
        System.out.println(names);
    }
}
```

---

### 4. What is constructor overloading?
**Answer:**  
Constructor overloading means defining multiple constructors in a class with different parameter lists.  
- Allows creating objects in different ways.  

```java
class Student {
    int id;
    String name;
    double marks;

    // Default constructor
    Student() {}

    // Constructor with 2 parameters
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor with 3 parameters
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}
```

---

### 5. How does garbage collection work in Java?
**Answer:**  
- Garbage Collection (GC) automatically frees memory by removing objects that are no longer reachable.  
- Triggered by JVM when memory is low.  
- Uses algorithms like Mark-and-Sweep.  
- We can suggest GC by calling `System.gc()`, but it’s not guaranteed.  

```java
class GCExample {
    public static void main(String[] args) {
        GCExample obj = new GCExample();
        obj = null;  // eligible for GC
        System.gc(); // request GC
    }
    protected void finalize() {
        System.out.println("Garbage collected!");
    }
}
```

---

### 6. Why do we use getters and setters?
**Answer:**  
- To provide controlled access to private fields.  
- Getters → Read field values.  
- Setters → Modify field values safely.  
- Helps implement validation before setting values.  

```java
class Student {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }
}
```

---

### 7. What is a static variable?
**Answer:**  
- A static variable belongs to the class rather than any object.  
- Shared across all objects.  
- Stored in method area of memory.  

```java
class Student {
    static int count = 0;  // static variable

    Student() {
        count++; // increment count for each object
    }
}

public class Test {
    public static void main(String[] args) {
        new Student();
        new Student();
        System.out.println("Total Students: " + Student.count);
    }
}
```

---

### 8. What is the use of the final keyword?
**Answer:**  
- `final variable` → constant, cannot be reassigned.  
- `final method` → cannot be overridden.  
- `final class` → cannot be inherited.  

```java
final class Animal { }  // cannot be extended

class Student {
    final int id = 101;  // constant

    final void display() {
        System.out.println("Student ID: " + id);
    }
}
```

---

### 9. Difference between compile-time and runtime errors?
**Answer:**  
- **Compile-time error** → Detected by the compiler (syntax errors, missing semicolon, type mismatch).  
- **Runtime error** → Detected when the program runs (NullPointerException, ArrayIndexOutOfBounds, Divide by zero).  

```java
// Compile-time error
int x = "abc";  // type mismatch

// Runtime error
int[] arr = {1, 2, 3};
System.out.println(arr[5]);  // ArrayIndexOutOfBoundsException
```

---

### 10. What are access modifiers?
**Answer:**  
Keywords that define the visibility/scope of classes, methods, and variables.  

- **public** → accessible everywhere  
- **protected** → accessible in same package + subclasses  
- **default (no modifier)** → accessible only in same package  
- **private** → accessible only within the same class  

```java
class Student {
    public int rollNo;       // accessible everywhere
    protected String name;   // same package + subclasses
    int age;                 // default (package-private)
    private double marks;    // accessible only within class
}
```
