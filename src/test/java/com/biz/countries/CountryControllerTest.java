package com.biz.countries;

import com.biz.countries.exception.DuplicateResourceException;
import com.biz.countries.exception.ResourceNotFoundException;
import com.biz.countries.model.Country;
import com.biz.countries.service.CountryService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CountryControllerTest {
    @Autowired
    CountryService countryService;

    @Test
    @Order(1)
    public void testCreateCountry() {
        Country country = new Country();
        country.setName("Portugal");
        countryService.createCountry(country);
        assertNotNull(countryService.getCountryById(1L));
    }

    @Test
    @Order(2)
    public void testCreateDuplicateCountry() {
        Country country = new Country();
        country.setName("Nigeria");
        assertThrows(DuplicateResourceException.class, () -> countryService.createCountry(country));
    }

    @Test
    @Order(3)
    public void testGetAllCountries() {
        Page countries = countryService.getAllCountry(0, 10);
        assertTrue(countries.getTotalElements() > 0);
    }

    @Test
    @Order(4)
    public void testGetCountryById() {
        Country country = countryService.getCountryById(1L);
        assertEquals("Nigeria", country.getName());
    }

    @Test
    @Order(5)
    public void testUpdateCountry() {
        Country country = countryService.getCountryById(1L);
        country.setId(1L);
        country.setName("Naija");
        countryService.updateCountry(country);
        assertEquals("Naija", countryService.getCountryById(1L).getName());
    }

    @Test
    @Order(6)
    public void testDelete() {
        countryService.deleteCountry(1L);
        assertThrows(ResourceNotFoundException.class, () -> countryService.getCountryById(1L));
    }
}
