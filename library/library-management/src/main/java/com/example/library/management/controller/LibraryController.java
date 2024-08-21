package com.example.library.management.controller;

import com.example.library.management.model.Book;
import com.example.library.management.model.User;
import com.example.library.management.service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        libraryService.addBook(book);
        return "Book added successfully!";
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        libraryService.addUser(user);
        return "User added successfully!";
    }

    @GetMapping("/users")
    public Set<User> getAllUsers() {
        return libraryService.getAllUsers();
    }

    @PostMapping("/borrowBook")
    public String borrowBook(@RequestParam String username, @RequestParam String bookTitle) {
        return libraryService.borrowBook(username, bookTitle);
    }

    @GetMapping("/borrowQueue")
    public List<String> getBorrowQueue() {
        return libraryService.getBorrowQueue();
    }

    @GetMapping("/userBooks")
    public Map<String, List<String>> getUserBooks() {
        return libraryService.getUserBooks();
    }
}
