import java.util.ArrayList;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return available;
    }
    public void borrow() {
        available = false;
    }
    public void returnBook() {
        available = true;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + (available ? "Yes" : "No");
    }
}
class Library {
    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        System.out.println("\nLibrary Catalog:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }
}

public class DigitalLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Adding sample books to the library
        library.addBook(new Book("Java Programming", "John Doe"));
        library.addBook(new Book("Data Structures and Algorithms", "Jane Smith"));
        library.addBook(new Book("Introduction to Python", "Alice Johnson"));
        library.addBook(new Book("Object oriented programming", "Bhawsaar"));
        boolean quit = false;
        while (!quit) {
            System.out.println("\nDigital Library Menu:");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to borrow: ");
                    String titleToBorrow = scanner.nextLine();
                    Book borrowBook = library.findBook(titleToBorrow);
                    if (borrowBook != null) {
                        borrowBook.borrow();
                        System.out.println("You have successfully borrowed: " + borrowBook.getTitle());
                    } else {
                        System.out.println("Book not available or not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String titleToReturn = scanner.nextLine();
                    Book returnBook = library.findBook(titleToReturn);
                    if (returnBook != null) {
                        returnBook.returnBook();
                        System.out.println("You have successfully returned: " + returnBook.getTitle());
                    } else {
                        System.out.println("Book not found or already returned.");
                    }
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the Digital Library. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
