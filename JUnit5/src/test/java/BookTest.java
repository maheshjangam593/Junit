/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.example.Book;
import org.example.BookController;
import org.example.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)

public class BookTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    Book b1 = new Book(1, "mai", "enjoy", 2);
    Book b2 = new Book(2, "mai", "enjoy1", 3);
    Book b3 = new Book(3, "mahesh", "enjoy", 2);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();}
        @Test
    public void getBooks() throws Exception {
        List<Book> books = new ArrayList<>(Arrays.asList(b1, b2, b3));

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.
                get("/Books").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(3))).
                andExpect(jsonPath("$[2].name", is("mahesh")));}
    @Test
    public  void getBookById() throws Exception {
        Mockito.when(bookRepository.findById(b1.getId())).thenReturn(ofNullable(b1));
        long id=1L;
       */
/* mockMvc.perform(MockMvcRequestBuilders
                .get("/Books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("mai")));*//*

        mockMvc.perform(MockMvcRequestBuilders.get("/Books/{id}",id))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void postBook() throws Exception
    {
       */
/* Book book=Book.builder()
                .Id()
                .name()*//*

        Book b4 = new Book(4, "raj", "jio", 5);

        Mockito.when(bookRepository.save(b4)).thenReturn(b4);

        String content=objectWriter.writeValueAsString(b4);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder=MockMvcRequestBuilders
                .post("/Book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("raj")));
    }

    @Test
    public void updateBook() throws Exception
    {
        Book updatedBook=new Book(1,"ram","all", 4);
        Mockito.when(bookRepository.findById(b1.getId())).thenReturn(java.util.Optional.ofNullable (b1));
        Mockito.when(bookRepository.save(updatedBook)).thenReturn(updatedBook);
        String content=objectWriter.writeValueAsString(updatedBook);
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
                .post("/Book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.name",is("ram")));
    }

    @Test
    public void deleteBook() throws Exception
    {
        Mockito.when(bookRepository.findById(b1.getId())).thenReturn(Optional.of(b1));
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/Book/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBook1()
    {

        */
/*bookController.deletBook(b1);
        bookRepository.*//*

    }
}

*/
