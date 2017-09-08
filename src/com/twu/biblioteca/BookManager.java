package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookList() {
        List<Book> bookList = bookRepository.getBooks();
        return bookList;
    }
}
