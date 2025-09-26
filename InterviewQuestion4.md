## Interview Questions & Answers

## Task 4: Java File I/O - Notes App

### 1. Difference between FileReader and BufferedReader?
*** Answer: ***
```FileReader:``` Reads character by character from a file. It's a low-level reader that performs unbuffered input.

```BufferedReader:``` Wraps around FileReader and uses a buffer to read larger chunks of data at once, making it more efficient for reading large files.

*** Example: ***

```java
// FileReader - less efficient (character by character)
FileReader fr = new FileReader("file.txt");
int character;
while ((character = fr.read()) != -1) {
    System.out.print((char) character);
}

// BufferedReader - more efficient (line by line)
BufferedReader br = new BufferedReader(new FileReader("file.txt"));
String line;
while ((line = br.readLine()) != null) {
    System.out.println(line);
}
```
*** Key Differences: ***
*** Performance: *** BufferedReader is faster for large files
*** Functionality: *** BufferedReader provides readLine() method
*** Memory Usage: *** BufferedReader uses internal buffer (default 8KB)

----

### 2. What is try-with-resources?
*** Answer: ***
* Try-with-resources is a feature introduced in Java 7 that automatically closes resources that implement the AutoCloseable interface.

*** Syntax: ***

```java
try (ResourceType resource = new ResourceType()) {
    // use resource
} catch (Exception e) {
    // handle exception
}
// resource automatically closed here
```
*** Example: ***

```java
// Traditional approach (pre-Java 7)
FileReader fr = null;
try {
    fr = new FileReader("file.txt");
    // read file
} finally {
    if (fr != null) {
        fr.close();  // manual cleanup
    }
}

// Modern approach (try-with-resources)
try (FileReader fr = new FileReader("file.txt");
     BufferedReader br = new BufferedReader(fr)) {
    // resources automatically closed
}
```
*** Benefits: ***
* ✅ Automatic resource management
* ✅ Eliminates need for explicit finally blocks
* ✅ Prevents resource leaks
* ✅ More readable and concise code

----

### 3. How to handle IOException?
*** Answer: ***
* IOException is a checked exception that must be handled using try-catch blocks or declared in the method signature.

*** Method 1: *** Try-catch block
```java
try {
    FileReader fr = new FileReader("file.txt");
    // file operations
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
    e.printStackTrace();  // for debugging
}
```
*** Method 2: *** Throws declaration

```java
public void readFile() throws IOException {
    FileReader fr = new FileReader("file.txt");
    // caller must handle the exception
}
```
*** Method 3: *** Try-with-resources with catch

```java
try (FileReader fr = new FileReader("file.txt")) {
    // automatic resource management
} catch (IOException e) {
    logger.error("File operation failed", e);
}
```

---
### 4. What are checked and unchecked exceptions?
*** Answer: ***
| Aspect | Checked Exception | Unchecked Exception |
|--------|-------------------|---------------------|
Compile-time |	Checked by compiler| Not checked by compiler
Handling	| Must be handled or declared |	Optional to handle
Inheritance |	Extend Exception	| Extend RuntimeException
Examples	| IOException, SQLException |	NullPointerException, ArrayIndexOutOfBounds

*** Checked Exceptions Examples:***

```java
// Must be handled
try {
    FileReader fr = new FileReader("file.txt");
} catch (IOException e) {  // Checked exception
    // handling required
}

// Or declared
public void readFile() throws IOException {  // Declaration required
    FileReader fr = new FileReader("file.txt");
}
```
*** Unchecked Exceptions Examples: ***

```java
// No handling required (but recommended)
String text = null;
try {
    text.length();  // NullPointerException (unchecked)
} catch (NullPointerException e) {
    // Optional handling
}
```

---

### 5. How does file writing work in Java?
*** Answer: ***
* Java provides several classes for file writing:

* Using FileWriter:

```java
// Append mode (add to existing content)
try (FileWriter fw = new FileWriter("file.txt", true)) {
    fw.write("This will be appended\n");
    fw.write("Another line\n");
}

// Overwrite mode (replace all content)
try (FileWriter fw = new FileWriter("file.txt", false)) {
    fw.write("This replaces everything\n");
}
```
* Using BufferedWriter (more efficient):

```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))) {
    bw.write("Line 1");
    bw.newLine();  // platform-independent newline
    bw.write("Line 2");
    bw.flush();    // force write to disk
}
```
*** Using Files class (Java 7+): ***

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
Files.write(Paths.get("file.txt"), lines);  // writes all lines at once
```

---
### 6. What is the difference between append and overwrite mode?
*** Answer: ***
| Mode | Parameter | Behavior | Use Case |
|------|-----------|----------|----------|
Append | true	| Adds to end of file |	Logging, adding new data |
Overwrite |	false	| Replaces entire file	| Creating new file, updating content |

*** Visual Example: ***

*** text ***
``` Original file content: "Hello" ```

*** APPEND MODE (true): ***
``` write(" World") → File becomes: "Hello World" ```

*** OVERWRITE MODE (false): ***
``` write("Hi") → File becomes: "Hi"```

*** Code Example: ***

```java
// Start with empty file: ""

// Append mode
FileWriter fw1 = new FileWriter("file.txt", true);
fw1.write("Hello");    // File: "Hello"
fw1.write(" World");   // File: "Hello World"

// Overwrite mode  
FileWriter fw2 = new FileWriter("file.txt", false);
fw2.write("Hi");       // File: "Hi" (previous content lost)
```

---
### 7. What is exception propagation?
*** Answer: ***
* Exception propagation is when an exception is passed up through the method call stack until it's caught or reaches the JVM.

*** Example: ***

```java
public class ExceptionPropagation {
    public void methodA() {
        methodB();  // Exception propagates to here
    }
    
    public void methodB() {
        methodC();  // Exception propagates to here  
    }
    
    public void methodC() {
        throw new RuntimeException("Error in methodC");
    }
    
    public static void main(String[] args) {
        try {
            new ExceptionPropagation().methodA();
        } catch (RuntimeException e) {
            System.out.println("Caught at top level: " + e.getMessage());
        }
    }
}
```
``` Stack Trace Output: ```

```text```
```java
Exception in thread "main" java.lang.RuntimeException: Error in methodC
    at ExceptionPropagation.methodC(ExceptionPropagation.java:10)
    at ExceptionPropagation.methodB(ExceptionPropagation.java:6)
    at ExceptionPropagation.methodA(ExceptionPropagation.java:2)
    at ExceptionPropagation.main(ExceptionPropagation.java:14)
```
----
### 8. How to log exceptions?
*** Answer: ***

***Basic Logging Methods:***

```java
try {
    FileReader fr = new FileReader("nonexistent.txt");
} catch (IOException e) {
    // Method 1: Simple message
    System.err.println("Error: " + e.getMessage());
    
    // Method 2: Full stack trace
    e.printStackTrace();
    
    // Method 3: Custom formatting
    System.err.println("Exception type: " + e.getClass().getSimpleName());
    System.err.println("Message: " + e.getMessage());
}
```
*** Using Java Logger: ***

```java
import java.util.logging.Logger;
import java.util.logging.Level;

public class FileProcessor {
    private static final Logger logger = Logger.getLogger(FileProcessor.class.getName());
    
    public void processFile() {
        try {
            FileReader fr = new FileReader("file.txt");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to read file", e);
            logger.severe("File error: " + e.getMessage());
        }
    }
}
```
*** Best Practices: ***
* Log appropriate level (INFO, WARNING, SEVERE)
* Include context information
* Don't ignore exceptions (empty catch blocks)
* Use logging frameworks (Log4j, SLF4J) in production

---
### 9. What is a stack trace?
*** Answer: ***
* A stack trace shows the method call sequence that led to an exception, helping developers debug issues.

*** Example Stack Trace: ***

```text```
```java
java.io.FileNotFoundException: notes.txt (No such file or directory)
    at java.io.FileInputStream.open0(Native Method)
    at java.io.FileInputStream.open(FileInputStream.java:195)
    at java.io.FileInputStream.<init>(FileInputStream.java:138)
    at java.io.FileReader.<init>(FileReader.java:72)
    at NotesApp.addNote(NotesApp.java:45)
    at NotesApp.main(NotesApp.java:15)
```
``` Reading the Stack Trace:```

* Exception Type: FileNotFoundException

* Message: notes.txt (No such file or directory)

* Call Stack (bottom to top):
    - main() line 15 → called addNote()
    - addNote() line 45 → tried to create FileReader
    - The error occurred in native file opening code

* How to Use for Debugging: 
    - Identify where exception occurred
    - Trace back through method calls
    - Find the root cause of the issue

----

### 10. When to use finally block?
*** Answer: ***
* The finally block executes regardless of whether an exception occurred. It's used for cleanup operations.

```Traditional Resource Cleanup:```

```java
FileReader fr = null;
try {
    fr = new FileReader("file.txt");
    // read file operations
} catch (IOException e) {
    System.err.println("Error reading file: " + e.getMessage());
} finally {
    // This always executes
    if (fr != null) {
        try {
            fr.close();  // Ensure resource is closed
        } catch (IOException e) {
            System.err.println("Error closing file: " + e.getMessage());
        }
    }
    System.out.println("Cleanup completed");
}
```

``` Modern Alternative (try-with-resources):```

```java
// Prefer this approach for resources
try (FileReader fr = new FileReader("file.txt")) {
    // automatic cleanup - no finally needed for closing
} catch (IOException e) {
    // handle exception
}
```

```When to Use Finally Block:```
- Closing resources (if not using try-with-resources)
- Releasing locks
- Logging completion of operations
- Any cleanup that must happen regardless of success/failure