package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBooks();
}
