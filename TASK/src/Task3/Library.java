package TASK3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    
    //Constructor

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    //Add book to library
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added: "+book.getTitle());
    }
    
    //Add user to library
    public void addUser(User user){
        users.add(user);
        System.out.println("User added: "+user.getName());
    }
    
    //Find by ISBN
    public Book findBookByIsbn(String isbn){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }
    
    //Find user by ID
    public User findUserById(String userId){
        for(User user: users){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }        
        return null;
    }
    
    //Issue Book to user
    public void issueBook(String userId, String isbn){
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);
        
        if(user != null && book != null){
            user.issueBook(book);
        }else{
            System.out.println("User or Book not found!");
        }
    }
    
    //Return book from user
    public void returnBook(String userId, String isbn){
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);
        
        if(user != null && book != null){
            user.returnBook(book);
        }else{
            System.out.println("User or Book not found!");
        }
    }
    
    //Display all users
    public void displayAllUsers(){
        System.out.println("\n=== All Users in Library ===");
        for(User user : users){
            System.out.println(user);
        }
    }
    //Display all users
    public void displayAllBooks(){
        System.out.println("\n=== All Books in Library ===");
        for(Book book : books){
            System.out.println(book);
        }
    }
}
