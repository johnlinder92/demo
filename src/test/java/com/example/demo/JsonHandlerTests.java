package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest
public class JsonHandlerTests {
    @Autowired
    JsonHandler jsonHandler;


    @Test
    public void getalldata() throws FileNotFoundException {

        System.out.println(jsonHandler.getWholeJson());
    }
}
