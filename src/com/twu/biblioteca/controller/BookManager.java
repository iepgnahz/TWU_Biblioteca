package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;

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

    public Boolean checkoutBook(String bookName) {
        Book book = bookRepository.getBookByName(bookName);
        if (book != null && !book.getCheckedOut()) {
            bookRepository.updateBookByBookName(bookName, "checkout");
            return true;
        }
        return false;
    }

    public Boolean returnBook(String bookName) {
        Book book = bookRepository.getBookByName(bookName);
        if (book != null && book.getCheckedOut()) {
            bookRepository.updateBookByBookName(bookName, "return");
            return true;
        }
        return false;

    }
}
