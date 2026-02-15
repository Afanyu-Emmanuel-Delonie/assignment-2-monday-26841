package com.afanyu.question1_library_api.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Get request for all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // get request for a particular book using the book id 
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return books.stream()
        .filter(b -> b.getId().equals(id))
        .findFirst()
        .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public
}
