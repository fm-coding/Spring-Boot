package com.example.library.management.service;

import com.example.library.management.model.Book;
import com.example.library.management.model.User;
import com.example.library.management.repository.BookRepository;
import com.example.library.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    private Queue<String> borrowQueue = new LinkedList<>();
    private Map<String, List<String>> userBooks = new HashMap<>();

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Set<User> getAllUsers() {
        return new HashSet<>(userRepository.findAll());
    }

    public String borrowBook(String username, String bookTitle) {
        Optional<Book> bookOpt = bookRepository.findAll().stream()
                .filter(book -> book.getTitle().equals(bookTitle))
                .findFirst();
        Optional<User> userOpt = userRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
        if (bookOpt.isPresent() && userOpt.isPresent()) {
            borrowQueue.add(username);
            userBooks.computeIfAbsent(username, k -> new ArrayList<>()).add(bookTitle);
            userOpt.get().getBorrowedBooks().add(bookTitle);
            userRepository.save(userOpt.get());
            return "Book borrowed successfully!";
        }
        return "Book or user not found!";
    }

    public List<String> getBorrowQueue() {
        return new ArrayList<>(borrowQueue);
    }

    public Map<String, List<String>> getUserBooks() {
        return userBooks;
    }
}