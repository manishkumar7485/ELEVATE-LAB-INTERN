# Java Notes App

A simple text-based notes manager application built with Java File I/O operations.

## Features

- **Add Notes**: Write notes to a file with timestamps
- **View Notes**: Read and display all saved notes
- **Clear Notes**: Remove all notes from the file
- **File Persistence**: Notes are saved to `notes.txt` file

## Technical Implementation

### File I/O Operations
- **FileWriter**: Used for writing notes to file (both append and overwrite modes)
- **BufferedReader**: Used for efficient reading of notes from file
- **Try-with-resources**: Automatic resource management for file handles

### Exception Handling
- **IOException**: Handled for all file operations
- **FileNotFoundException**: Specific handling for missing files
- **Stack Trace Logging**: Debug information for exceptions

### Key Concepts Demonstrated
- File reading/writing operations
- Exception handling and propagation
- Try-with-resources statement
- Checked vs unchecked exceptions
- Append vs overwrite file modes
