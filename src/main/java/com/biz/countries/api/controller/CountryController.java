package com.biz.countries.api.controller;

import com.biz.countries.model.Country;
import com.biz.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/{countries}")
@RestController
public class CountryController {

    @Autowired
    public CountryRepository countryRepository;

    @GetMapping
    public ResponseEntity<Object> getCountries(){
        return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getCountry(@RequestParam(required = false) String name){
        List<Country> countries = countryRepository.findCountriesByNameContainingIgnoreCase(name);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addCountry(@RequestBody Country country){
        countryRepository.save(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
