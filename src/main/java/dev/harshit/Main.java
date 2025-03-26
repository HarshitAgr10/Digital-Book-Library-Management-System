package dev.harshit;

import dev.harshit.controllers.LibraryController;
import dev.harshit.services.LibraryService;
import dev.harshit.views.LibraryView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Digital Library Management System!");

        // Initialize the service layer responsible for business logic
        LibraryService libraryService = new LibraryService();

        // Initialize the controller layer responsible for handling user requests
        LibraryController libraryController = new LibraryController(libraryService);

        // Initialize the view layer responsible for handling user interactions
        LibraryView libraryView = new LibraryView(libraryController);

        libraryView.displayMenu();
    }
}