public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ", Available: " + isAvailable + ")";
    }
}

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();
    private static final int MAX_BORROW_LIMIT = 3;

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            System.out.println(name + " cannot borrow more than " + MAX_BORROW_LIMIT + " books.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Book '" + book.getTitle() + "' is not available.");
            return false;
        }
        borrowedBooks.add(book);
        book.setAvailable(false);
        System.out.println(name + " borrowed '" + book.getTitle() + "'.");
        return true;
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            System.out.println(name + " returned '" + book.getTitle() + "'.");
        } else {
            System.out.println(name + " did not borrow '" + book.getTitle() + "'.");
        }
    }
}

public class Librarian {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void manageLibrary() {
        System.out.println(name + " is managing the library.");
    }
}

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchBooks(String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public void displayBooks(boolean includeBorrowed) {
        for (Book book : books) {
            if (includeBorrowed || book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Anna");

        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));

        System.out.println("Available books:");
        library.displayBooks(false);

         Reader reader = new Reader("John Doe");
        reader.borrowBook(library.searchBooks("1984").get(0));
        reader.borrowBook(library.searchBooks("Mockingbird").get(0));

        System.out.println("\nAll books:");
        library.displayBooks(true);


        reader.returnBook(library.searchBooks("1984").get(0));

 
        System.out.println("\nAvailable books after return:");
        library.displayBooks(false);

   
        librarian.manageLibrary();
    }
}
