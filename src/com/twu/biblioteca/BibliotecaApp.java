package com.twu.biblioteca;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.*;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        User currentUser = null;
        WelcomeSpeaker welcomeSpeaker = new WelcomeSpeaker(System.out);
        welcomeSpeaker.sayWelcome();


        BookRepository bookRepository = new BookRepositoryImp();
        BookManager bookManager = new BookManager(bookRepository);
        List<Book> bookList = bookManager.getBookList();

        MovieRepository movieRepository = new MovieRepositoryImp();
        MovieManager movieManager = new MovieManager(movieRepository);

        UserRepository userRepository = new UserRepositoryImp();
        UserManager userManager = new UserManager(userRepository);

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        MenuManager menuManager = new MenuManager();
        String inputMsg = "";
        do {
            System.out.println(menuManager.getMenu());
            Scanner scanner = new Scanner(System.in);
            inputMsg = scanner.next();


            if (inputMsg.equals("2")) {
                if (currentUser == null) {
                    System.out.println("you haven't login yet!please login first!");

                } else {
                    System.out.println(menuManager.handleOptionInput(inputMsg));
                    Scanner scannerBook = new Scanner(System.in);
                    String inputBookName = scannerBook.next();
                    System.out.println(menuManager.getCheckoutResult(bookManager.checkoutBook(inputBookName)));
                }
            }

            if (inputMsg.equals("3")) {
                if (currentUser == null) {
                    System.out.println("you haven't login yet!please login first!");
                } else {
                    System.out.println(menuManager.handleOptionInput(inputMsg));
                    Scanner scannerBook = new Scanner(System.in);
                    String inputBookName = scannerBook.next();
                    System.out.println(menuManager.getReturnResult(bookManager.returnBook(inputBookName)));
                }
            }

            if (inputMsg.equals("5")) {
                System.out.println(menuManager.handleOptionInput(inputMsg));
                Scanner scannerMovie = new Scanner(System.in);
                String inputMovieName = scannerMovie.next();
                System.out.println(menuManager.getCheckoutMovieResult(movieManager.checkoutMovie(inputMovieName)));
            }

            if (inputMsg.equals("6")) {
                System.out.println(menuManager.handleOptionInput(inputMsg));
                User user = userManager.alertUserLogin();

                if (user != null) {
                    currentUser = user;
                    System.out.println("login success！");
                } else {
                    currentUser = null;
                    System.out.println("account error！login failed！");
                }
            }

            if (inputMsg.equals("7")) {
                if (currentUser == null) {
                    System.out.println("you haven't login yet!please login first!");
                } else {
                    System.out.println(menuManager.handleOptionInput(inputMsg));
                    System.out.printf("%-15s%-10s%-15s%-10s\n", currentUser.getLibraryNumber(), currentUser.getName(), currentUser.getEmailAddress(), currentUser.getPhoneNumber());
                }
            }

        } while (!inputMsg.equals("8"));
        currentUser = null;
    }
}
