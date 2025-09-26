package task3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Existing methods
    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        for (Book book : books) {
            String status = book.isIssued() ? "Issued to: " + book.getIssuedTo().getName() : "Available";
            System.out.println("ISBN: " + book.getIsbn() + " | Title: " + book.getTitle() +
                    " | Author: " + book.getAuthor() + " | Status: " + status);
        }
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered in the library.");
            return;
        }

        for (User user : users) {
            System.out.println("ID: " + user.getUserId() + " | Name: " + user.getName());
        }
    }

    public void issueBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user == null) {
            System.out.println("User not found with ID: " + userId);
            return;
        }

        if (book == null) {
            System.out.println("Book not found with ISBN: " + isbn);
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued to: " + book.getIssuedTo().getName());
            return;
        }

        book.setIssued(true);
        book.setIssuedTo(user);
        System.out.println("Book '" + book.getTitle() + "' issued successfully to " + user.getName());
    }

    public void returnBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user == null) {
            System.out.println("User not found with ID: " + userId);
            return;
        }

        if (book == null) {
            System.out.println("Book not found with ISBN: " + isbn);
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book is not currently issued.");
            return;
        }

        if (!book.getIssuedTo().getUserId().equals(userId)) {
            System.out.println("This book is not issued to the specified user.");
            return;
        }

        book.setIssued(false);
        book.setIssuedTo(null);
        System.out.println("Book '" + book.getTitle() + "' returned successfully by " + user.getName());
    }

    // New methods for CLI
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}