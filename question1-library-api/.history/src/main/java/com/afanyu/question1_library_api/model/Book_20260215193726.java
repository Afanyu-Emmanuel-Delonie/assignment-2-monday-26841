package com.afanyu.question1_library_api.model;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Book(){}

    public Book(Long id, String title, String author, String isbn, int publicationYear ){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    this covers the getters and setters for the model 
}
