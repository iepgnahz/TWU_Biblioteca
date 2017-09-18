package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImp;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuManager {
    public String handleOptionInput(String inputMsg) {
        BookRepository bookRepository = new BookRepositoryImp();
        BookManager bookManager = new BookManager(bookRepository);
        List<Book> bookList = bookManager.getBookList();

        switch (inputMsg) {
            case "1":
                String s = bookList.stream().map(book -> getBookInfo(book.getName(), book.getAuthor(), book.getPublishYear())).reduce("", (result, subString) -> subString.concat(result));
                return getTableTitle() + s;
            case "2":
                return "please input the name of book which you want check out:";
            case "3":
                return "please input the name of book which you want to return:";
            case "4":
                return "Good Bye!";
            default:
                return "Select a valid option!";
        }
    }

    public String getCheckoutResult(Boolean isSuccessCheckout) {
        return isSuccessCheckout ? "Thank you! Enjoy the book" : "That book is not available.";
    }

    public String getMenu() {
        return String.format("%-15s%-18s%-15s%-15s\n", "1.List Books", "2.check out book", "3.return book","4.quit");
    }

    public String getTableTitle() {
        return String.format("%-10s%-10s%-10s\n", "name", "author", "publishYear");
    }

    public String getBookInfo(String bookName, String author, String publishYear) {
        return String.format("%-10s%-10s%-10s\n", bookName, author, publishYear);
    }

    public String getReturnResult(Boolean isSuccessReturn) {
        return isSuccessReturn ? "Thank you for returning the book." : "That is not a valid book to return.";
    }


}
