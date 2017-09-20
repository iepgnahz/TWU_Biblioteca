package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BookManagerTest {
    private BookRepository bookRepository;
    private BookManager bookManager;

    @Before
    public void setUp() throws Exception {
        bookRepository = Mockito.mock(BookRepository.class);
        bookManager = new BookManager(bookRepository);
    }

    @Test
    public void get_book_list_should_return_book_list_when_there_are_books_in_library() throws Exception {
        List<Book> mockBookList = new ArrayList<>();
        Book book1 = new Book("test1", "author1", "2017");
        Book book2 = new Book("test2", "author2", "2017");

        mockBookList.add(book1);
        mockBookList.add(book2);

        Mockito.when(bookRepository.getBooks()).thenReturn(mockBookList);
        List<Book> bookList = bookManager.getBookList();

        assertThat(bookList.size(), is(2));
        assertThat(bookList.get(0), equalTo(book1));
        assertThat(bookList.get(1), equalTo(book2));
    }

    @Test
    public void check_out_book_should_return_true_when_book_can_be_checked() throws Exception {
        Book book1 = new Book("test1", "author1", "2017");

        Mockito.when(bookRepository.getBookByName("test1")).thenReturn(book1);
        Mockito.when(bookRepository.updateBookByBookName("test1", "checkout")).thenReturn(true);

        assertThat(bookManager.checkoutBook("test1"), is(true));
    }

    @Test
    public void check_out_book_should_return_false_when_book_can_not_be_checked() throws Exception {
        Book book1 = new Book("test1", "author1", "2017");

        Mockito.when(bookRepository.getBookByName("test1")).thenReturn(null);
        Mockito.when(bookRepository.updateBookByBookName("test1", "checkout")).thenReturn(false);

        assertThat(bookManager.checkoutBook("test1"), is(false));
    }

    @Test
    public void return_book_should_return_true_when_book_can_be_return() throws Exception {
        Book book1 = new Book("test1", "author1", "2017");
        book1.setCheckedOut(true);

        Mockito.when(bookRepository.getBookByName("test1")).thenReturn(book1);
        Mockito.when(bookRepository.updateBookByBookName("test1", "checkout")).thenReturn(true);

        assertThat(bookManager.returnBook("test1"), is(true));
    }

    @Test
    public void return_book_should_return_false_when_book_can_not_be_return() throws Exception {
        Book book1 = new Book("test1", "author1", "2017");

        Mockito.when(bookRepository.getBookByName("test1")).thenReturn(null);
        Mockito.when(bookRepository.updateBookByBookName("test1", "checkout")).thenReturn(false);

        assertThat(bookManager.returnBook("test1"), is(false));
    }

    @Test
    public void get_book_list_should_return_empty_list_when_there_is_no_book_in_library() throws Exception {
        Mockito.when(bookRepository.getBooks()).thenReturn(new ArrayList<>());

        List<Book> bookList = bookManager.getBookList();
        assertThat(bookList.size(), is(0));
    }
}