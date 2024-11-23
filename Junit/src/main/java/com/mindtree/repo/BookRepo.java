package com.mindtree.repo;

import com.mindtree.entities.Book;

public interface BookRepo {
    public void save(Book book);

    Book getBookById(int id);

    Book getBookByName(String name) throws RuntimeException;
}
