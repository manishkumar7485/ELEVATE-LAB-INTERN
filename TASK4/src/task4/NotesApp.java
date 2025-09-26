package task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class NotesApp {
    private static final String notes_file = "notes.txt";
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    public static void main(String[] args) {
        System.out.println("===== Java Notes App =====");
        System.out.println("A simple file-based notes manager");
        
        boolean running = true;
        while(running){
            displayMenu();
            String choice = sc.nextLine();
            
            switch(choice){
                case "1":
                    addNote();
                    break;
                case "2":
                    viewNotes();
                    break;
                case "3":
                    clearNotes();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");                    
            }
        }
        sc.close();
    }
    
    
    /**
     * Display the main menu options
     */
    private static void displayMenu(){
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add a new note");
        System.out.println("2. View all notes");
        System.out.println("3. Clear all notes");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1 - 4): ");
    }
    
    /**
     * Add a new note to the file in append mode.
     */
    private static void addNote(){
        System.out.println("\n--- Add New Note ---");
        System.out.println("Enter your note: ");
        String noteText = sc.nextLine();
        
        if(noteText.trim().isEmpty()){
            System.out.println("Note cannot be empty!");
            return;
        }
        
        try(FileWriter writer = new FileWriter(notes_file, true)){
            String timestamp = LocalDateTime.now().format(formatter);
            String noteEntry = "["+timestamp+"]"+noteText+"\n";
            
            writer.write(noteEntry);
            System.out.println("✓ Notes added successfully!");            
            
        } catch (IOException ex) {
            System.err.println("❌ Error writing to file: "+ex.getMessage());
            //Log the exception stack trace for debugging
            ex.printStackTrace();
        }
    }
    
    /**
     * Read and display all notes from the file 
     * and uses bufferedReader for efficient reading.
     */
    private static void viewNotes(){
        System.out.println("\n--- Your Notes ---");
        
        File file = new File(notes_file);
        if(!file.exists() || file.length() == 0){
            System.out.println("No notes found. Add some notes first!");
            return;
        }
        
        try(BufferedReader reader = new BufferedReader(new FileReader(notes_file))){
            
            String line;
            int noteCount = 0;
            
            System.out.println("════════════════════════════");
            while(( line = reader.readLine()) != null){
                noteCount++;
                System.out.println(noteCount+". "+ line);
            }
            System.out.println("════════════════════════════");
            System.out.println("Total Notes: "+noteCount);
            
        } catch (FileNotFoundException ex) {
            System.err.print("❌ Notes file not found: " + ex.getMessage());
        } catch (IOException e) {
            System.err.print("❌ Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Clear all notes from the file
     * Demonstrates file overwrite mode.
     */
    
    private static void clearNotes(){
        System.out.print("\nAre you sure you want to clear all notes? (y/n): ");
        String confirm = sc.nextLine();
        
        if(confirm.equalsIgnoreCase("y")){
            try(FileWriter writer = new FileWriter(notes_file, false)){
                
                //Openning in overwrite mode (append==false) clears the notes
                writer.write("");
                System.out.println("✓ All notes cleared successfully!");                
            } catch (IOException e) {
                System.err.println("❌ Error clearing notes: " + e.getMessage());
                e.printStackTrace();
            }
        }else{
            System.out.println("Clear operation cancelled.");
        }
    }
}
