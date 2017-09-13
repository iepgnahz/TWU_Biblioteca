package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;

import java.util.Arrays;
import java.util.List;

public class BookRepositoryImp implements BookRepository {
    @Override
    public List<Book> getBooks() {
        Book book1 = new Book("test1","author1","2017");
        Book book2 = new Book("test2","author2","2017");
        Book[] bookArray = new Book[]{book1, book2};
        List<Book> bookList = Arrays.asList(bookArray);

        return bookList;
    }
}
