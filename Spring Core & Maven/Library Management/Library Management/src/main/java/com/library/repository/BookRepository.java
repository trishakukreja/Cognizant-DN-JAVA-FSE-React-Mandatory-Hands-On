// File: src/main/java/com/library/repository/BookRepository.java
package com.library.repository;

public class BookRepository {
    
    public void saveBook(String bookTitle) {
        System.out.println("Repository: Successfully saved book -> \"" + bookTitle + "\" to the database.");
    }
}