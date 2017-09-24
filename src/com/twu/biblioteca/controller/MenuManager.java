package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.BookRepositoryImp;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.MovieRepositoryImp;

import java.util.List;

public class MenuManager {
    public String handleOptionInput(String inputMsg) {
        BookRepository bookRepository = new BookRepositoryImp();
        BookManager bookManager = new BookManager(bookRepository);
        List<Book> bookList = bookManager.getBookList();

        MovieRepository movieRepository = new MovieRepositoryImp();
        MovieManager movieManager = new MovieManager(movieRepository);
        List<Movie> movies = movieManager.getMovieLists();

        switch (inputMsg) {
            case "1":
                String s = bookList.stream().map(book -> getBookInfo(book.getName(), book.getAuthor(), book.getPublishYear())).reduce("", (result, subString) -> subString.concat(result));
                return getBookTableTitle() + s;
            case "2":
                return "please input the name of book which you want check out:";
            case "3":
                return "please input the name of book which you want to return:";
            case "4":
                String MovieMsg = movies.stream().map(movie -> getMovieInfo(movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating())).reduce("", (result, subString) -> subString.concat(result));
                return getMovieTableTitle() + MovieMsg;
            case "5":
                return "please input the name of movie which you want check out:";
            case "6":
                return "Good Bye!";
            default:
                return "Select a valid option!";
        }
    }

    public String getCheckoutResult(Boolean isSuccessCheckout) {
        return isSuccessCheckout ? "Thank you! Enjoy the book" : "That book is not available.";
    }

    public String getMenu() {
        return String.format("%-15s%-18s%-15s%-15s%-18s%-15s\n", "1.List Books", "2.check out book", "3.return book", "4.list movies", "5.check out movie", "6.quit");
    }

    public String getBookTableTitle() {
        return String.format("%-10s%-10s%-10s\n", "name", "author", "publishYear");
    }

    public String getMovieTableTitle() {
        return String.format("%-10s%-10s%-10s%-10s\n", "name", "year", "director", "rating");
    }


    public String getBookInfo(String bookName, String author, String publishYear) {
        return String.format("%-10s%-10s%-10s\n", bookName, author, publishYear);
    }

    public String getMovieInfo(String MovieName, String year, String director, String rating) {
        return String.format("%-10s%-10s%-10s%-10s\n", MovieName, year, director, rating);
    }

    public String getReturnResult(Boolean isSuccessReturn) {
        return isSuccessReturn ? "Thank you for returning the book." : "That is not a valid book to return.";
    }

    public String getCheckoutMovieResult(Boolean isSuccessReturn) {
        return isSuccessReturn ? "Thank you! Enjoy the movie" : "That movie is not available.";
    }


}
