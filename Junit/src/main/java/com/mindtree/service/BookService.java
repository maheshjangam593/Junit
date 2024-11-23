package com.mindtree.service;

import com.mindtree.entities.Book;
import com.mindtree.exceptions.BookNotPresentException;
import com.mindtree.repo.BookRepo;

public class BookService {


    private BookRepo bookRepo;

    public void addBook(Book book)
    {
        bookRepo.save(book);
    }
    public Book getBookById(int id)
    {
        Book book = bookRepo.getBookById(id);
        return book;
    }
    public Book getUnknownBook(String name) throws BookNotPresentException
    {
        Book book=null;

        try {
            book= bookRepo.getBookByName(name);
        }
        catch (RuntimeException e)
        {
            throw new BookNotPresentException("boo not found");
        }

        return book;

    }
    public void getUnKnownBook1(String name) throws BookNotPresentException
    {
        Book book=null;

        try {
            book= bookRepo.getBookByName(name);
        }
        catch (RuntimeException e)
        {
            throw new BookNotPresentException("boo not found");
        }
    }
    public void noCallWhenReturn(String name)
    {
        Book book=null;
        if (name.equalsIgnoreCase("abc"))
        {
            return ;
        }

        book= bookRepo.getBookByName(name);
    }
    public static boolean staticMethod(int n)
    {
        if(n%2==0)
        {
            return  true;
        }
        return false;
    }


}
