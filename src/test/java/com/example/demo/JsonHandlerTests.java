package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.HashMap;

@SpringBootTest
public class JsonHandlerTests {

    @Autowired
    JsonHandler jsonHandler;


    @Test
    public void getalldata() throws FileNotFoundException {
        HashMap<Long, String> test = jsonHandler.getWholeJson();

        Long testet = new Long(11);

        System.out.println(test.get(testet));

        if(test.get(testet).equals("Hello, 5445!")){

            System.out.println("TESTPASS");
        }
    }
}
