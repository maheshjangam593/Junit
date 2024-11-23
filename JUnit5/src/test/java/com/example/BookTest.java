package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookTest {
    @Mock
   BookRepository bookRepo;
    @InjectMocks
   BookController controller;

    //@Mocked
   BookController controller1;
    @BeforeEach
    void setUp() {
        //book = new Book(1,"name","summary",9);
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    @Order(1)
    public void getName(){
        //book.getName();
     Book book = new Book(1,"name","summary",9);
        Assert.assertEquals("name",book.getName());
    }
    @Test
    @Order(4)
    public void getId1() throws NoSuchFieldException {
        //book.getName();
       Optional<Book> book = Optional.of(new Book(1, "name", "summary", 9));
        when(bookRepo.findById(1)).thenReturn(Optional.of(book.get()));
        when(bookRepo.save(book.get())).thenReturn(book.get());
       Book book1= controller.getBookById(1);
        Assert.assertEquals(1,book1.getId());
    }
    @Test
    @Order(2)
    public void test_delete() throws NoSuchFieldException {
        Book book1=new Book(1,"ar","sdf",4);
        controller.deleteBook(book1);

        verify(bookRepo,times(1)).delete(book1);
    }
    @Test
    @Order(3)
    public  void test_put() throws NoSuchFieldException {
      //  Book book1 = new Book(1, "ar", "sdf", 4);
        Optional<Book> book = Optional.of(new Book(1, "name", "summary", 9));
        when(bookRepo.findById(1)).thenReturn(Optional.of((book.get())));
        when(bookRepo.save(book.get())).thenReturn(book.get());
        Book book1= controller.getBookById(1);
        assertEquals(1,book1.getId());
    }
}
