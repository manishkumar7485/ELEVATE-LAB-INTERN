# 📘 Interview Questions & Answers


## 1. What is encapsulation?

* - Encapsulation is the process of hiding the internal details of a class and only exposing controlled access through getters and setters.
- Example: Making fields private and accessing them via public methods.
- Benefit: Improves security, maintainability, and reusability.

## 2. How are ArrayLists different from arrays?

* Array → Fixed size, faster, can store primitives and objects.
* ArrayList → Dynamic size (can grow/shrink), stores only objects, provides built-in methods (add, remove, contains, etc.).

## 3. How to sort an ArrayList?

* Use Collections.sort() or a Comparator.

* Collections.sort(myList); // natural order
* Collections.sort(myList, Comparator.reverseOrder()); // descending

## 4. What is constructor overloading?

* Constructor overloading means defining multiple constructors in a class with different parameter lists.

* Allows creating objects in different ways.
* Examples-
- Student() {}
- Student(int id, String name) {}
- Student(int id, String name, double marks) {}

## 5. How does garbage collection work in Java?

* Garbage Collection (GC) automatically frees memory by removing objects that are no longer reachable.
* Triggered by JVM when memory is low.
* Uses algorithms like Mark-and-Sweep.
* We can suggest GC by calling System.gc(), but it’s not guaranteed.

## 6. Why do we use getters and setters?

* To provide controlled access to private fields.
- Getters → Read field values.
- Setters → Modify field values safely.
- Helps implement validation before setting values.

## 7. What is a static variable?

* A static variable belongs to the class rather than any object.
* Shared across all objects.
* Stored in method area of memory.
    - static int count = 0;

## 8. What is the use of the final keyword?
* - final variable → constant, cannot be reassigned.
* - final method → cannot be overridden.
* - final class → cannot be inherited.

## 9. Difference between compile-time and runtime errors?

* Compile-time error → Detected by the compiler (syntax errors, missing semicolon, type mismatch).

* Runtime error → Detected when the program runs (NullPointerException, ArrayIndexOutOfBounds, Divide by zero).

## 10. What are access modifiers?

* Keywords that define the visibility/scope of classes, methods, and variables.

* - public → accessible everywhere
* - protected → accessible in same package + subclasses
* - default (no modifier) → accessible only in same package
* - private → accessible only within the same class