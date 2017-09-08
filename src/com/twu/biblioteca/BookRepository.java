package com.twu.biblioteca;

import java.util.List;

public interface BookRepository {
    List<Book> getBooks();

    Book getBookById(int id);
}
