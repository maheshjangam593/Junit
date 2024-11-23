package com.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;


import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan(basePackages = {"org.example"})
@AutoConfigureMockMvc
@ContextConfiguration
@RunWith(MockitoJUnitRunner.class)
public class MockMVCTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    BookRepository bookRepository;

    @Autowired
    public Book book;
    @InjectMocks
    BookController controller;

    @Before
    public void setUp() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getBooksById() throws Exception {
        Book book = new Book(1, "name", "summary", 9);

        when(bookRepository.getById(1)).thenReturn(book);
       /* when(bookRepository.findById1(1)).thenReturn(Optional.of(book.get()));
        when(bookRepository.save(book.get())).thenReturn(book.get());*/

        int id = 1;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/Book/{Id}", id)).andExpect(status().isFound()).andDo(print());
    }

    @Test
    public void test_Put() throws Exception {
        Optional<Book> book = Optional.of(new Book(1, "name", "summary", 9));
        when(bookRepository.findById(1)).thenReturn(Optional.of(book.get()));
        when(bookRepository.save(book.get())).thenReturn(book.get());
        Book book1 = controller.getBookById(1);

        ObjectMapper mapper = new ObjectMapper();
        String book2 = mapper.writeValueAsString(book);

        this.mockMvc.perform(put("/put/book").content(book2).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(".id").value(1)).andExpect(MockMvcResultMatchers.jsonPath(".name").value("name")).andDo(print());


    }

}
