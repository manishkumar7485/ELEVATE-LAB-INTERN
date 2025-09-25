package TASK3;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<Book> issuedBooks;
    
    //Constructor

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }
    
    //Getters

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBook() {
        return issuedBooks;
    }
    
    //Method to issue a book to user
    public void issueBook(Book book){
        if(!book.isIsIssued()){
            issuedBooks.add(book);
            book.setIsIssued(true);
            System.out.println("Book '"+book.getTitle()+"' issued to "+name);
        }else{
            System.out.println("Book is alredy issued!");
        }
    }
    
    //Method to return a book
    public void returnBook(Book book){
        if(issuedBooks.contains(book)){
            issuedBooks.remove(book);
            book.setIsIssued(false);
            System.out.println("Book '"+book.getTitle()+"' return by "+name);
        }else{
            System.out.println("This book was not issued to "+ name);
        }        
    }
    
    //toString() for print the data of users
    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Books Issued: " + issuedBooks.size();
    }
    
}
