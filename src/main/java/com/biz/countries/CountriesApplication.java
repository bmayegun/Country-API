package com.biz.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.biz.countries")
public class CountriesApplication {
    public static void main(String[] args) {
        SpringApplication.run(CountriesApplication.class, args);
    }

}
