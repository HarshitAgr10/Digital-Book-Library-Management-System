Digital Library Book Management System
A simple Library Book Management System implemented in Java using the MVC architecture. 
It allows users to manage books by adding, viewing, searching, updating, and deleting them.

-> Features
✔ Add a new book 
✔ View all available books 
✔ Search for a book by ID or title 
✔ Update book details 
✔ Delete a book
✔ Exit System
✔ Exception handling for invalid inputs 

✔ Modular, scalable, and follows clean code principles

-> Setup Instructions
-  Prerequisites
Ensure you have the following installed:

Java 17+ (or OpenJDK 17)
Git (optional, if cloning)
An IDE like IntelliJ IDEA (recommended)

- Clone the Repository
git clone https://github.com/HarshitAgr10/Digital-Book-Library-Management-System
cd Digital-Book-Library-Management-System

-  Compile and Run 
simply run Main.java.

-> How to Use
Run the application
Choose an option (1-7) from the display menu
Perform actions like adding, viewing, updating, or deleting books
Type 7 to exit



-> Challenges Faced
1. Ensuring Proper Exception Handling
Initially, invalid book entries crashed the program.
Implemented custom exceptions (BookNotFoundException, DuplicateBookException, InvalidBookDataException)
for better error handling.

2. Using Enum for Availability Status
Initially used String values, but switched to BookAvailabilityStatus enum for future expansion scope.
Improved parsing to handle "Checked Out" and "Available" inputs correctly.

3. Maintaining Clean and Modular Code
Followed MVC architecture to separate concerns (Model, View, Controller).



-> Future Improvements
1. Database Integration – Persist the books details using MySQL database.

2. Spring Boot Framework – Use Spring Boot framework for better scalability, dependency 
   management, security and built-in support for REST APIs

3. Build REST APIs - Build Spring Boot REST APIs to allow external integrations and to make application more accessible 
   Expose endpoints like :
      POST /books → Add a new book
      GET /books → Fetch all books
      GET /books/{id} → Get book details by ID 
      GET /books/{title} → Get book details by Title
      PUT /books/{id} → Update book details
      DELETE /books/{id} → Remove a book
