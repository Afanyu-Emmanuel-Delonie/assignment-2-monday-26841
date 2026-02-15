package com.afanyu.question1_library_api.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afanyu.question1_library_api.model.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1L, "Clean Code", "Robert Martin", "978-0132350884", 2008));
        books.add(new Book(2L, "The Pragmatic Programmer", "Andrew Hunt", "978-0135957059", 1999));
        books.add(new Book(3L, "Refactoring", "Martin Fowler", "978-0134757599", 2018));
    }

    // Get request 
    @
}
