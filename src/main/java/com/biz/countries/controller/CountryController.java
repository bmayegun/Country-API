package com.biz.countries.controller;

import com.biz.countries.exception.DuplicateResourceException;
import com.biz.countries.exception.ResourceNotFoundException;
import com.biz.countries.model.Country;
import com.biz.countries.repository.CountryRepository;
import com.biz.countries.response.SuccessResponse;
import com.biz.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/countries")
@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<Object> getCountries(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "", required = false) String name){
        return new ResponseEntity<>(new SuccessResponse(countryService.getCountriesByName(name, page, size)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCountries(@PathVariable long id){
        return new ResponseEntity<>(new SuccessResponse(countryService.getCountryById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addCountry(@RequestBody Country country){
        countryService.createCountry(country);
        return new ResponseEntity<>(new SuccessResponse<>("Country: " + country.getName() + " added"), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable Long id, @RequestBody Country country){
        country.setId(id);
        countryService.updateCountry(country);
        return new ResponseEntity<>(new SuccessResponse(country) , HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable long id){
        countryService.deleteCountry(id);
        return new ResponseEntity<>(new SuccessResponse(), HttpStatus.NO_CONTENT);
    }

}
