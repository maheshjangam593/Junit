package com.mindtree.exceptions;

public class BookNotPresentException extends RuntimeException {
    public BookNotPresentException(String book_is_not_present) {
        super(book_is_not_present);
    }
}
