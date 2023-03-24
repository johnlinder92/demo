package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
@Component
public class JsonHandler {

    public String getJsonById(Long id) throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
        String filePath = "build/data.json";
        File file = new File(filePath);
        HashMap<Long, String> map = new HashMap<>();
        Type mapType = new TypeToken<HashMap<Long, String>>() {
        }.getType();
        if (file.exists()) {
            JsonReader reader = new JsonReader(new FileReader(file));
            map = gson.fromJson(reader, mapType);

        }

        return map.get(id);
    }

    public ResponseEntity<HashMap<Long, String>> getWholeJson() throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
        String filePath = "build/data.json";
        File file = new File(filePath);
        ResponseEntity<HashMap<Long, String>> mappen = null;
        ResponseEntity<HashMap<Long, String>> map= null;
        Type mapType = new TypeToken<ResponseEntity<HashMap<Long, String>>>() {
        }.getType();
        if (file.exists()) {
            JsonReader reader = new JsonReader(new FileReader(file));
            map = gson.fromJson(reader, mapType);
            mappen = map;
        }


        return mappen;
    }


    public void deleteJsonById(Long key) throws IOException {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
        String filePath = "build/data.json";
        File file = new File(filePath);
        HashMap<Long,String> map = new HashMap<>();
        Type mapType = new TypeToken<HashMap<Long,String>>() {
        }.getType();
        if (file.exists()) {
            JsonReader reader = new JsonReader(new FileReader(file));
            map = gson.fromJson(reader, mapType);

        }
        map.remove(key);
        Writer writer = Files.newBufferedWriter(Paths.get(filePath));
        writer.write(gson.toJson(map, mapType));
        writer.close();



    }




    public void updateJsonById(Long key, String data) throws IOException {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
        String filePath = "build/data.json";
        File file = new File(filePath);
        HashMap<Long,String> map = new HashMap<>();
        Type mapType = new TypeToken<HashMap<Long,String>>() {
        }.getType();
        if (file.exists()) {
            JsonReader reader = new JsonReader(new FileReader(file));
            map = gson.fromJson(reader, mapType);

        }
        if(map.get(key) != null) {
            map.replace(key, data);

        }else{
            map.put(key, data);
        }
        Writer writer = Files.newBufferedWriter(Paths.get(filePath));
        writer.write(gson.toJson(map, mapType));
        writer.close();

    }

}
