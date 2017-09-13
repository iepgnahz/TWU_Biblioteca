package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookManager;
import com.twu.biblioteca.controller.WelcomeSpeaker;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImp;

import java.util.List;

public class BibliotecaApp {
    public static void main(String[] args) {
        WelcomeSpeaker welcomeSpeaker = new WelcomeSpeaker(System.out);
        welcomeSpeaker.sayWelcome();

        BookRepository bookRepository = new BookRepositoryImp();
        BookManager bookManager = new BookManager(bookRepository);
        List<Book> bookList = bookManager.getBookList();

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printTableTitle();

        bookList.stream().forEach(book->{
            bibliotecaApp.printBookInfo(book.getName(),book.getAuthor(),book.getPublishYear());
        });

    }

    void printTableTitle() {
        System.out.printf("%-10s%-10s%-10s\n","name","author","publishYear");
    }

    void printBookInfo(String bookName, String author, String publishYear) {
        System.out.printf("%-10s%-10s%-10s", bookName, author, publishYear);
        System.out.println();
    }
}
