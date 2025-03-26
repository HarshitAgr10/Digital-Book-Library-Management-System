package dev.harshit.views;

import dev.harshit.controllers.LibraryController;
import dev.harshit.models.BookAvailabilityStatus;

import java.util.Scanner;

/**
 * LibraryView class acts as the User Interface for the Digital Library Book Management System.
 * It interacts with the user and communicates with the LibraryController to execute operations.
 */
public class LibraryView {
    private LibraryController libraryController;

    private Scanner scanner = new Scanner(System.in);

    public LibraryView(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    /**
     * Displays the main menu and processes user input from 1-7 continuously.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\nDigital Library Book Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book By ID");
            System.out.println("4. Search Book By Title");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;


                case 2:
                    viewAllBooks();
                    break;

                case 3:
                    searchBookByID();
                    break;

                case 4:
                    searchBookByTitle();
                    break;

                case 5:
                    updateBook();
                    break;

                case 6:
                    deleteBook();
                    break;

                case 7:
                    exitProgram();

                default:
                    System.out.println("Invalid choice, Please try again");;
            }
        }
    }


    /**
     * Takes user input and adds a new book to the system.
     */
    private void addBook() {
        System.out.println("Enter BookID: ");
        String bookID = scanner.nextLine();
        System.out.println("Enter Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Author: ");
        String author = scanner.nextLine();
        System.out.println("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter Availability Status (Available/Checked_Out): ");
        String availabilityStatus = scanner.nextLine().trim().toUpperCase();
        BookAvailabilityStatus status = BookAvailabilityStatus.valueOf(availabilityStatus);

        libraryController.addBook(bookID, title, author, genre, status);
    }


    /**
     * Displays all books available in the system.
     */
    private void viewAllBooks() {
        libraryController.viewAllBooks();
    }


    /**
     * Takes user input and Searches for a book by its ID.
     */
    private void searchBookByID() {
        System.out.println("Enter BookID: ");
        String bookID = scanner.nextLine();
        libraryController.searchBookByID(bookID);
    }


    /**
     * Takes user input and Searches for a book by its title.
     */
    private void searchBookByTitle() {
        System.out.println("Enter BookTitle: ");
        String bookTitle = scanner.nextLine();
        libraryController.searchBookByTitle(bookTitle);
    }


    /**
     * Takes user input and Updates the details of an existing book.
     */
    private void updateBook() {
        System.out.println("Enter BookID: ");
        String bookID = scanner.nextLine();
        System.out.println("Enter new Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter new Author: ");
        String author = scanner.nextLine();
        System.out.println("Enter new Genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter new Availability Status: ");
        String availabilityStatus = scanner.nextLine().trim().toUpperCase();
        BookAvailabilityStatus status = BookAvailabilityStatus.valueOf(availabilityStatus);

        libraryController.updateBook(bookID, title, author, genre, status);
    }


    /**
     * Takes user input and Deletes a book from the system.
     */
    private void deleteBook() {
        System.out.println("Enter BookID: ");
        String bookID = scanner.nextLine();
        libraryController.deleteBook(bookID);
    }


    /**
     * Exits the program after confirmation from the user.
     */
    public void exitProgram() {
        System.out.println("Are you sure you want to exit? (yes/no)");
        String response = scanner.nextLine();
        if (response.equals("yes")) {
            System.out.println("Exiting... Goodbye!");
            System.exit(0);
        } else {
            displayMenu();
        }
    }

}
