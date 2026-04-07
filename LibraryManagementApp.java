/*
## Problem: Library Management System

**Part 1: Core Java + OOP + Constructor Chaining**
- Create class `Book` with private fields: `bookId` (String), `title` (String), `author` (String), `price` (double)
- Constructor 1: Takes `bookId`, `title`, `author` → sets default price = 0.0
- Constructor 2: Takes all four fields
- Override `toString()` to return: `Book[ID - Title by Author, Rs. Price]`

**Part 2: Custom Exceptions**
- Create `InvalidBookException` (checked exception - extends Exception) → thrown when bookId is null or empty
- Create `BookNotFoundException` (unchecked exception - extends RuntimeException) → thrown when book is not found

**Part 3: Collections (HashMap + ArrayList + HashSet)**
Create class `Library`:
- Use `HashMap<String, Book>` to store books (key = bookId)
- Method `addBook(Book b)`: 
  - Throw `InvalidBookException` if bookId is null or empty
  - Add to map if valid
- Method `findBook(String bookId)`: Throw `BookNotFoundException` if not found
- Method `getExpensiveBooks(double minPrice)`: Return `ArrayList<Book>` of books above minPrice. Use **Iterator** for safe iteration.
- Method `getUniqueAuthors()`: Return `HashSet<String>` of all unique authors

**Part 4: String Manipulation**
- Method `searchByTitle(String keyword)`: Return `ArrayList<Book>` where title contains keyword (case-insensitive)
- Static method `reverseWords(String title)`: Reverse order of words  
  Example: `"Java Complete Reference"` → `"Reference Complete Java"`

**Part 5: Exception Flow in main()**
In `main()` method:
- Try to add a book with empty bookId → catch `InvalidBookException`
- Try to find a non-existent book → catch `BookNotFoundException`
- Use try-catch-finally in both cases where `finally` prints `"Library operation completed"`

---

**Test Cases to include in main():**
1. Add valid books: B001-Clean Code-Robert Martin-450, B002-Spring Boot-Craig Walls-599, B003-Java Reference-Herbert Schildt-350
2. Print all expensive books (>400)
3. Print unique authors
4. Search by keyword "Java"
5. Print reverseWords("Java Complete Reference")
6. Demonstrate exception handling with finally

---
*/

import java.util.*;
public class LibraryManagementApp {
    public static void main(String[] args) {
        Library library = new Library();

        // Add Book
        try {
            library.addBook(new Book("B001", "Clean Code", "Robert Martin", 450));
            System.out.println("Book added: B001 - Clean Code by Robert Martin");
        } catch (InvalidBookException e) {
            System.out.println("InvalidBookException: " + e.getMessage());
        } finally {
            System.out.println("Library operation completed");
        }

        // Find Book
        try {
            Book book = library.findBook("B012");
            System.out.println("Found: " + book.bookId);
        } catch (BookNotFoundException e) {
            System.out.println("BookNotFoundException: " + e.getMessage());
        } finally {
            System.out.println("Library operation completed");
        } 

        // Expensive Books        
        List<Book> books = library.getExpensiveBooks(400);
        System.out.println("Expensive books (>400) are total - " + books.size());
        for (Book book : books) {
            System.out.println(book.title);
        }

        // Authors
        Set<String> authors = library.getUniqueAuthors();
        System.out.println("Authors: " + authors);

        // Search by Title
        List<Book> javaBooks = library.searchByTitle("Java");
        System.out.println("All books with keyword Java:");
        for (Book book : javaBooks) {
            System.out.println(book.title);
        }

        // Reverse Words
        String reversed = Library.reverseWords("Java Complete Reference");
        System.out.println("\n=== Format Title ===");
        System.out.println("Original : Java Complete Reference");
        System.out.println("Reversed : " + reversed);
    }
}

// ==================== Book Class ====================
class Book {
    String bookId;
    String title;
    String author;
    double price;

    public Book(String bookId, String title, String author) {
        this(bookId, title, author, 0.0);
    }

    public Book(String bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book[" + bookId + " - " + title + " by " + author + ", Rs. " + price + "]";
    }
}

// ==================== Library Class ====================
class Library {
    private HashMap<String, Book> bookMap = new HashMap<>();

    public void addBook(Book b) throws InvalidBookException {
        if (b.bookId == null || b.bookId.trim().isEmpty()) {
            throw new InvalidBookException("Book ID cannot be null or empty");
        }
        bookMap.put(b.bookId, b);
    }

    public Book findBook(String bookId) {
        if (!bookMap.containsKey(bookId)) {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
        return bookMap.get(bookId);
    }

    public List<Book> getExpensiveBooks(double minPrice) {
        List<Book> result = new ArrayList<>();
        
        Iterator<Book> iterator = bookMap.values().iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.price > minPrice) {
                result.add(b);
            }
        }
        return result;
    }

    public Set<String> getUniqueAuthors() {
        Set<String> authors = new HashSet<>();
      
        for (Book b : bookMap.values()) {
            authors.add(b.author);
        }
        return authors;
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> books = new ArrayList<>();
        
        for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
            String titleName = entry.getValue().title.toLowerCase();
            if (titleName.contains(keyword.toLowerCase())) {
                books.add(entry.getValue());
            }
        }

        return books;
    }

    public static String reverseWords(String title) {
        char[] titleArray = title.toCharArray();
        reverse(titleArray, 0, title.length()-1);

        int start = 0;
        for (int i = 0; i < title.length(); i++) {
            if (i == title.length() - 1 || titleArray[i+1] == ' ') {
                reverse(titleArray, start, i);
                start = i+2;
            }
        }

        return new String(titleArray);
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}

// ==================== Custom Exceptions ====================
class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }
}

class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
