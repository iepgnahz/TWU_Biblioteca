package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookRepositoryImp implements BookRepository {
    public static Book book1 = new Book("test1", "author1", "2017");
    public static Book book2 = new Book("test2", "author2", "2017");
    public static Book[] bookArray = new Book[]{book1, book2};

    @Override
    public List<Book> getBooks() {
        List<Book> bookList = Arrays.asList(bookArray).stream().filter(book -> !book.getCheckedOut()).collect(Collectors.toList());
        return bookList;
    }

    @Override
    public Book getBookByName(String bookName) {
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i].getName().equals(bookName)) {
                return bookArray[i];
            }
        }
        return null;
    }

    @Override
    public Boolean updateBookByBookName(String bookName, String operation) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("checkout", true);
        map.put("return", false);
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i].getName().equals(bookName)) {
                bookArray[i].setCheckedOut(map.get(operation));
                return true;
            }
        }
        return false;
    }
}
