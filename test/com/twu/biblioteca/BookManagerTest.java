package com.twu.biblioteca;

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
        Book book1 = new Book();
        Book book2 = new Book();

        mockBookList.add(book1);
        mockBookList.add(book2);

        Mockito.when(bookRepository.getBooks()).thenReturn(mockBookList);
        List<Book> bookList = bookManager.getBookList();

        assertThat(bookList.size(), is(2));
        assertThat(bookList.get(0), equalTo(book1));
        assertThat(bookList.get(1), equalTo(book2));
    }

    @Test
    public void get_book_list_should_return_empty_list_when_there_is_no_book_in_library() throws Exception {
        Mockito.when(bookRepository.getBooks()).thenReturn(new ArrayList<>());

        List<Book> bookList = bookManager.getBookList();
        assertThat(bookList.size(), is(0));
    }


}