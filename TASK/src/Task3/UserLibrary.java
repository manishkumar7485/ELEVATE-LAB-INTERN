package Task3;

public class UserLibrary {
    public static void main(String[] args) {
        
        //CREATE LIBRARY INSTANCE
        Library library = new Library();
        
        //CREATE BOOKS
        Book book1 = new Book("ISBN001", "JAVA PROGRAMMING", "JAMES GOSLING");
        Book book2 = new Book("ISBN002", "PYTHON", "GUIDO VAN ROSSUM");
        Book book3 = new Book("ISBN003", "C++", "BJARNE STROUSTRUP");
        Book book4 = new Book("ISBN005", "JAVA: THE COMPLETE REFERENCE", "HERBERT SCHILDT");
        Book book5 = new Book("ISBN006", "HTML & CSS: DESIGN AND BUILD WEB SITES", "JON DUCKETT");
        
        //CREATE USERS
        User user1 = new User("U001", "MANISH KUMAR");
        User user2 = new User("U002", "RAHUL RAIKWAR");
        User user3 = new User("U003", "HIMANSHU SINGH");
        
        //ADD BOOKS AND USER TO LIBRARY
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        
        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);
        
        //DISPLAY INITIAL STATE
        library.displayAllBooks();
        library.displayAllUsers();
        
        //TEST BOOK ISSUING
        System.out.println("\n=== Issuing Books ===");
        library.issueBook("U001", "ISBN001");
        library.issueBook("U002", "ISBN002");
        library.issueBook("U001", "ISBN003");
        
        //TRY TO ISSUE ALREADY ISSUED BOOK
        library.issueBook("U002", "ISBN001");
        
        //DISPLAY STATE AFTER ISSUING
        library.displayAllBooks();
        library.displayAllUsers();
        
        //TEST BOOK RETURNING
        System.out.println("\n=== RETURNING BOOKS ===");
        library.returnBook("U001", "ISBN001");
        library.returnBook("U002", "ISBN002");
        
        //DISPLAY FINAL STATE
        library.displayAllBooks();
        library.displayAllUsers();
    }
}
