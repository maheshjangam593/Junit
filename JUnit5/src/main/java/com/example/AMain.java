package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AMain {

    class A{
        @Autowired
        private B b;
    }
    class B{
        @Autowired
        private A a;
    }

    public static void main(String[] args) {
        SpringApplication.run(AMain.class,args);
    }
}