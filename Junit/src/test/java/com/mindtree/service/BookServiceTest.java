package com.mindtree.service;

import com.mindtree.entities.Book;
import com.mindtree.exceptions.BookNotPresentException;
import com.mindtree.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookService bookService;

    @Test
    void addBook() {

        Book book = new Book(1, "Java", 1231);

        doNothing().when(bookRepo).save(book);
        bookService.addBook(book);
        //times to check the call for void method
        verify(bookRepo,times(1)).save(book);
    }


    @Test
    void getBookById() {
        Book book = new Book(1, "Java", 1231);
        when(bookRepo.getBookById(anyInt())).thenReturn(book);
        Book actualBook = bookService.getBookById(1);
        assertEquals("Java",actualBook.getName());
        verify(bookRepo,times(1)).getBookById(anyInt());
    }

    @Test
    void getBookByNameHandleException() throws RuntimeException
    {
       // Book book = new Book(1, "Java", 1231);
       // doThrow(RuntimeException.class).when(bookRepo).getBookByName(anyString());
        //once we call repo method it throws Runtime Exception, and we will catch that and throw new custom exception and validate it
        when(bookRepo.getBookByName(anyString())).thenThrow(RuntimeException.class);
       // bookService.getUnknownBook("abc");
        // this is to validate the given service method throws correct exception
      assertThrows(BookNotPresentException.class,()->bookService.getUnknownBook("abed"));

    }
    @Test
    void getBookByNameHandleUsingDoThrowException() throws RuntimeException
    {
        // doThrow is used when our service method returns nothing
        doThrow(RuntimeException.class).when(bookRepo).getBookByName(anyString());

        assertThrows(BookNotPresentException.class,()->bookService.getUnKnownBook1("book1"));
    }
    @Test
    void verifyIfInvalidNamePassedSaveShouldNotCall() throws RuntimeException
    {// Book book = new Book(1, "Java", 1231);
       bookService.noCallWhenReturn("abc");
       // this is used to tell that there is no interaction with bookRepo yet
       verifyNoInteractions(bookRepo);
       //this is used when there is no chance of using book repo;
       verifyNoMoreInteractions(bookRepo);
       bookService.noCallWhenReturn("Java");
       verify(bookRepo,times(1)).getBookByName(anyString());

    }

    @Test
    void verifyStaticMethod() {
        try (MockedStatic<BookService> bookServiceMockedStatic = mockStatic(BookService.class))
        {
            bookServiceMockedStatic.when(()->BookService.staticMethod(anyInt())).thenReturn(true);
            assertEquals(true, BookService.staticMethod(2));
        }
    }
}