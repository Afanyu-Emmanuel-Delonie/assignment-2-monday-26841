package com.afanyu.question1_library_api.controller;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private List<Book> books = new ArrayList<>();

}
