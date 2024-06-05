import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            try {
                System.out.println("\n==========================================");
                System.out.println("      Library Management System");
                System.out.println("==========================================");
                System.out.println("1. Add a Book");
                System.out.println("2. Display All Books");
                System.out.println("3. Search a Book");
                System.out.println("4. Delete a Book");
                System.out.println("5. Update a Book");
                System.out.println("6. Exit");
                System.out.println("==========================================");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Book Author: ");
                        String author = scanner.nextLine();
                        Book book = new Book(id, title, author);
                        library.addBook(book);
                        break;

                    case 2:
                        library.displayBooks();
                        break;

                    case 3:
                        System.out.print("Enter Book ID to search: ");
                        String searchId = scanner.nextLine();
                        library.searchBook(searchId);
                        break;

                    case 4:
                        System.out.print("Enter Book ID to delete: ");
                        String deleteId = scanner.nextLine();
                        library.deleteBook(deleteId);
                        break;

                    case 5:
                        System.out.print("Enter Book ID to update: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Enter new Book Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new Book Author: ");
                        String newAuthor = scanner.nextLine();
                        library.updateBook(updateId, newTitle, newAuthor);
                        break;

                    case 6:
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }
}
