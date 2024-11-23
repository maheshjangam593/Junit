package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repo;
    @GetMapping("/Books")
    public ResponseEntity<List<Book>> getBooks() {
        return (ResponseEntity<List<Book>>) repo.findAll();
    }

    @GetMapping("/Books/{Id}")
    public Book getBookById(@PathVariable(value = "Id") int id) throws NoSuchFieldException {
        Optional<Book> optionalBook = repo.findById(id);

        if (!optionalBook.isPresent()) {
           throw new NoSuchFieldException("book not present");
        }
        Book optionalBook1 = optionalBook.get();
        return repo.save(optionalBook1);


    }
    @GetMapping("/Book/{id}")
    public ResponseEntity<Book> getBookById1(@PathVariable(value = "Id") int id) throws NoSuchFieldException {
        try {
            Book book= repo.getById(id);
            return new ResponseEntity<Book>(book,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Book")
    public Book createBook(@RequestBody Book book) {
        return repo.save(book);
    }

    @PutMapping("/put/book")
    public Book putBook(@RequestBody Book book) throws NoSuchFieldException {
        if (book == null) {
            throw new NoSuchFieldException("book not present");
        }

        Optional<Book> optionalBook = repo.findById(book.getId());
        if (!optionalBook.isPresent()) {
            throw new NoSuchFieldException("id not present");
        }

        Book existingBook = optionalBook.get();
        existingBook.setId(book.getId());
        existingBook.setName(book.getName());
        existingBook.setSummary(book.getSummary());
        existingBook.setRating(book.getRating());
        return repo.save(existingBook);
    }


    @DeleteMapping("/Book/{id}")
    public void deleteBookById(@PathVariable(value = "id") int id) throws NoSuchFieldException {
        if (!repo.findById(id).isPresent()) {
            throw new NoSuchFieldException("id is not present " + id);

        }

        repo.deleteById(id);

    }
    @DeleteMapping("/Book/delete")
    public void deleteBook(Book book) throws NoSuchFieldException {


        repo.delete(book);

    }
}
