import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n=============================================================================");
            System.out.printf("| %-10s | %-40s | %-20s |\n", "Book ID", "Title", "Author");
            System.out.println("=============================================================================");
            for (Book book : books) {
                System.out.printf("| %-10s | %-40s | %-20s |\n", book.getId(), book.getTitle(), book.getAuthor());
            }
            System.out.println("=============================================================================");
        }
    }

    public void searchBook(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                System.out.println("\n=============================================================================");
                System.out.printf("| %-10s | %-40s | %-20s |\n", "Book ID", "Title", "Author");
                System.out.println("=============================================================================");
                System.out.printf("| %-10s | %-40s | %-20s |\n", book.getId(), book.getTitle(), book.getAuthor());
                System.out.println("=============================================================================");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                books.remove(book);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void updateBook(String id, String newTitle, String newAuthor) {
        boolean found = false;
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                found = true;
                System.out.println("Book updated successfully.");
                break; // no need to continue searching
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
}
