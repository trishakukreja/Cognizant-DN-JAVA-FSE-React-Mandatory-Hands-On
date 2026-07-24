// File: src/main/java/com/library/service/BookService.java
package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Default Constructor
    public BookService() {}

    // Setter method for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("Service: Processing book addition...");
        bookRepository.saveBook(title);
    }
}