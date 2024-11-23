package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Vector;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class BookIntegrationTest {


    @Test
    public void getCountries()
    {

       // Vector v=new Vector<>();
        TestRestTemplate testRestTemplate=new TestRestTemplate();
        testRestTemplate.getForEntity("http://localhost:8082/Books",String.class);
       //JSONAssert.assertEquals();
    }


}
