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
            if(inputMsg.equals("2")){
                Scanner scannerBook = new Scanner(System.in);
                String inputBookName = scannerBook.next();
                System.out.println(menuManager.getCheckoutResult(bookManager.checkoutBook(inputBookName)));
            }

            if(inputMsg.equals("3")){
                Scanner scannerBook = new Scanner(System.in);
                String inputBookName = scannerBook.next();
                System.out.println(menuManager.getReturnResult(bookManager.returnBook(inputBookName)));
            }

        } while (!inputMsg.equals("5"));


    }
}
