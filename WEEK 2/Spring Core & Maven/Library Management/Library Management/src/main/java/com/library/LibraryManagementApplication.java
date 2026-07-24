// File: src/main/java/com/library/LibraryManagementApplication.java
package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring Application Context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the Spring IoC container
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration and Dependency Injection
        System.out.println("--- Testing Spring IoC and Dependency Injection ---");
        bookService.addBook("Spring in Action");
    }
}