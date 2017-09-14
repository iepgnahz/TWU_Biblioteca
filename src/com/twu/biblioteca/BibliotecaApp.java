package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookManager;
import com.twu.biblioteca.controller.MenuManager;
import com.twu.biblioteca.controller.WelcomeSpeaker;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImp;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        WelcomeSpeaker welcomeSpeaker = new WelcomeSpeaker(System.out);
        welcomeSpeaker.sayWelcome();

        BookRepository bookRepository = new BookRepositoryImp();
        BookManager bookManager = new BookManager(bookRepository);
        List<Book> bookList = bookManager.getBookList();

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        MenuManager menuManager = new MenuManager();
        String inputMsg = "";
        do {
            System.out.println(menuManager.getMenu());
            Scanner scanner = new Scanner(System.in);
            inputMsg = scanner.next();

            System.out.println(menuManager.handleOptionInput(inputMsg));

        } while (!inputMsg.equals("2"));


    }
}
