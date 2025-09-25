package TASK3;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isIssued;
    
    //Constructor

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    
    //Getters and Setters (Encapsulation)

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIsIssued() {
        return isIssued;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }
    
    
    //toString method for print book data

    @Override
    public String toString() {
        String status = isIssued ? "Issued" : "Available";
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Status: " + status ;
    }    
    
}
