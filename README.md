# Library Management System

This is a simple Library Management System built with **Spring Boot** and **H2 Database**. It demonstrates basic CRUD operations on books, borrowers, and loans using **Spring Data JPA**. You can perform operations like adding a book, viewing books, updating book details, and deleting a book.

## Features:
- CRUD operations for books, borrowers, and loans.
- RESTful API using Spring Boot.
- In-memory database using H2 for easy setup and testing.
- Data is reset on every application restart (since H2 is in-memory).

## Prerequisites

Before you begin, ensure you have the following installed:
- Java 11 (or above)
- Maven
- Eclipse IDE (or IntelliJ IDEA)
- Postman (for API testing)

## Getting Started

1. Clone the repository to your local machine:
   
   git clone https://github.com/jsnmui/library-management.git

2. Navigate to the project directory:
    cd library-management

3. Build the project using Maven:
    mvn clean install

4. Run the application:

    * In Eclipse, right-click on the LibraryManagementApplication class and select Run As > Spring Boot App.
    * Alternatively, run the app from the terminal:
      mvn spring-boot:run
5. Access the H2 database console:

   * Open your browser and go to http://localhost:8080/h2-console.
   * Use the following details to log in:
    * JDBC URL: jdbc:h2:mem:testdb
    * Username: sa
    * Password: password

# RESTful API Endpoints

## Book API

| Method | Endpoint     | Description                 |
|--------|--------------|-----------------------------|
| GET    | /books       | Retrieve all books           |
| POST   | /books       | Add a new book               |
| PUT    | /books/{id}  | Update an existing book      |
| DELETE | /books/{id}  | Delete a book by ID          |

## Testing with Postman

Once the application is running, you can use Postman to test the API.

### 1. GET /books: Retrieve all books
- **Method**: GET  
- **URL**: `http://localhost:8080/books`  
- **Response**: A list of books stored in the system.

### 2. POST /books: Add a new book
- **Method**: POST  
- **URL**: `http://localhost:8080/books`  
- **Body**: raw, JSON  
- **Request JSON**:
 
  {
      "title": "The Great Gatsby",
      "author": "F. Scott Fitzgerald",
      "isbn": "9780743273565",
      "available": true
  }

 - **Response:** The newly added book with its id.

### 3.  PUT /books/{id}: Update an existing book
- **Method**: PUT 
- **URL**: `http://localhost:8080/books/{id} (replace {id} with the book's ID, e.g., http://localhost:8080/books/1)`  
- **Body**: raw, JSON  
- **Request JSON**:
  
  {
      "title": "The Great Gatsby",
      "author": "F. Scott Fitzgerald",
      "isbn": "9780743273565",
      "available": true
  }

### 4.  DELETE /books/{id}: Delete a book by ID
- **Method**: DELETE
- **URL**: `http://localhost:8080/books/{id} (replace {id} with the book's ID, e.g., http://localhost:8080/books/1)`  
- **Response:** 204 No Content status, indicating successful deletion.

## H2 Database Access

If you want to view or manipulate data directly in the database, you can access the H2 Console:

1. Go to `http://localhost:8080/h2-console`.
2. Use the following settings:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: (leave blank)

## Additional Information

- The project uses an H2 in-memory database, meaning that data is stored temporarily and will be lost once the application is stopped. For persistent data storage, you can switch to a different database like MySQL or PostgreSQL.
- You can extend the functionality by adding more fields to the models or adding new features like search or pagination.

 



   
 

  

