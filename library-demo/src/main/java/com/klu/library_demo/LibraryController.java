package com.klu.library_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {

    List<Book> books = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public int count() {
        return 200;
    }

    @GetMapping("/price")
    public double price() {
        return 599.99;
    }

    @GetMapping("/books")
    public List<String> books() {

        List<String> titles = new ArrayList<>();
        titles.add("Java Programming");
        titles.add("Spring Boot Guide");
        titles.add("Data Structures");

        return titles;
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book Added Successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return books;
    }
}