package task3;

import java.util.Scanner;

public class UserLibrary {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeLibrary();
        showMainMenu();
    }

    public static void initializeLibrary() {
        // CREATE LIBRARY INSTANCE
        Library library = new Library();

        // Add sample books
        Book book1 = new Book("ISBN001", "JAVA PROGRAMMING", "JAMES GOSLING");
        Book book2 = new Book("ISBN002", "PYTHON", "GUIDO VAN ROSSUM");
        Book book3 = new Book("ISBN003", "C++", "BJARNE STROUSTRUP");
        Book book4 = new Book("ISBN005", "JAVA: THE COMPLETE REFERENCE", "HERBERT SCHILDT");
        Book book5 = new Book("ISBN006", "HTML & CSS: DESIGN AND BUILD WEB SITES", "JON DUCKETT");

        // ADD BOOKS AND USER TO LIBRARY
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        // Add some sample users
        User user1 = new User("U001", "MANISH KUMAR");
        User user2 = new User("U002", "RAHUL RAIKWAR");
        User user3 = new User("U003", "HIMANSHU SINGH");

        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);

        System.out.println("Library initialized with sample data!");

    }

    public static void showMainMenu() {

        while (true) {

            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Displa1y All Books");
            System.out.println("2. Display All Users");
            System.out.println("3. Add New Book");
            System.out.println("4. Add New User");
            System.out.println("5. Issue Book to User");
            System.out.println("6. Return Book from User");
            System.out.println("7. Search Book by ISBN");
            System.out.println("8. View User's Issued Books");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    library.displayAllBooks();
                    break;
                case "2":
                    library.displayAllUsers();
                    break;
                case "3":
                    addNewBook();
                    break;
                case "4":
                    addNewUser();
                    break;
                case "5":
                    issueBook();
                    break;
                case "6":
                    returnBook();
                    break;
                case "7":
                    searchBook();
                    break;
                case "8":
                    viewUserBooks();
                    break;
                case "9":
                    System.out.println("Thank you for using Library Management System! ");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1-9.");

            }

        }

        // TEST BOOK ISSUING
        /**
         * System.out.println("\n=== Issuing Books ===");
         * library.issueBook("U001", "ISBN001");
         * library.issueBook("U002", "ISBN002");
         * library.issueBook("U001", "ISBN003");
         * 
         * //TRY TO ISSUE ALREADY ISSUED BOOK
         * library.issueBook("U002", "ISBN001");
         * 
         * //DISPLAY STATE AFTER ISSUING
         * library.displayAllBooks();
         * library.displayAllUsers();
         * 
         * //TEST BOOK RETURNING
         * System.out.println("\n=== RETURNING BOOKS ===");
         * library.returnBook("U001", "ISBN001");
         * library.returnBook("U002", "ISBN002");
         * 
         * //DISPLAY FINAL STATE
         * library.displayAllBooks();
         * library.displayAllUsers();
         * 
         **/
    }

    private static void addNewBook() {
        System.out.println("\n === ADD NEW BOOK ===");

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        Book newBook = new Book(isbn, title, author);
        library.addBook(newBook);

        System.out.println("Book added successfully!");
        pressEnterToContinue();
    }

    private static void addNewUser() {
        System.out.println("\n === ADD NEW USER ===");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();

        User newUser = new User(userId, userName);
        library.addUser(newUser);

        System.out.println("User added successfully!");
        pressEnterToContinue();
    }

    private static void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void viewUserBooks() {
        System.out.println("\n === VIEW USER'S ISSUED BOOKS ===");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        User user = library.findUserById(userId);
        if (user != null) {
            System.out.println("User: " + user.getName() + " (ID: " + user.getUserId() + ")");
            System.out.println("Issued Books:");

            boolean hasIssuedBooks = false;
            for (Book book : library.getBooks()) {
                if (book.isIssued() && book.getIssuedTo() != null &&
                        book.getIssuedTo().getUserId().equals(userId)) {
                    System.out.println(book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
                    hasIssuedBooks = true;
                }
            }

            if (!hasIssuedBooks) {
                System.out.println("No books currently issued to this user.");
            }
        } else {
            System.out.println("User not found with ID: " + userId);
        }
        pressEnterToContinue();
    }

    private static void searchBook() {
        System.out.println("\n === SEARCH BOOK BY ISBN ===");

        System.out.print("Enter ISBN to search: ");
        String isbn = scanner.nextLine();

        Book book = library.findBookByIsbn(isbn);
        if (book != null) {
            System.out.println("Book Found:");
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Status: " + (book.isIssued() ? "Issued" : "Available"));
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
        pressEnterToContinue();
    }

    private static void returnBook() {
        System.out.println("\n === RETURN BOOK FROM USER ===");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        library.returnBook(userId, isbn);
        pressEnterToContinue();
    }

    private static void issueBook() {
        System.out.println("\n=== ISSUE BOOK TO USER ===");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        library.issueBook(userId, isbn);
        pressEnterToContinue();
    }

    private static void displayAllBooks() {
        System.out.println("\n=== ALL BOOKS IN LIBRARY ===");
        library.displayAllBooks();
        pressEnterToContinue();
    }

    private static void displayAllUsers() {
        System.out.println("\n=== ALL REGISTERED USERS ===");
        library.displayAllUsers();
        pressEnterToContinue();
    }
}
