package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    @JsonProperty
    Long id;

    @JsonProperty
    String carName;

}
