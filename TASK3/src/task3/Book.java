package task3;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isIssued;
    private User issuedTo;
    
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = null;
    }
    
    // Getters and setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public User getIssuedTo() { return issuedTo; }
    
    public void setIssued(boolean issued) { this.isIssued = issued; }
    public void setIssuedTo(User issuedTo) { this.issuedTo = issuedTo; }
}