import java.util.ArrayList;
import java.util.Scanner;

// Class 1: Book
class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    // Issue the book
    public void issueBook() {
        issued = true;
    }

    // Return the book
    public void returnBook() {
        issued = false;
    }

    // Display book details
    public void displayBook() {
        System.out.println("ID: " + id
                + " | Title: " + title
                + " | Author: " + author
                + " | Status: "
                + (issued ? "Issued" : "Available"));
    }
}

// Class 2: Library
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(Book book) {
        if (findBook(book.getId()) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Find a book by ID
    public Book findBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Display all books
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Issue a book
    public void issueBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued!");
        } else {
            book.issueBook();
            System.out.println("Book issued successfully!");
        }
    }

    // Return a book
    public void returnBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (!book.isIssued()) {
            System.out.println("This book was not issued.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully!");
        }
    }

    // Search for a book
    public void searchBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else {
            book.displayBook();
        }
    }
}

// Class 3: Main program
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    library.searchBook(searchId);
                    break;

                case 0:
                    System.out.println("Thank you for using the library system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}