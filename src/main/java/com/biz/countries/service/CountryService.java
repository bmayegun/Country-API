package com.biz.countries.service;

import com.biz.countries.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CountryService {
    Country createCountry(Country country);
    Country updateCountry(Country country);
    Page<Country> getAllCountry(int page, int size);
    Country getCountryById(long id);
    Page<Country> getCountriesByName(String name, int page, int size);
    void deleteCountry(long id);
    List<Country> findPaginated(int pageNo, int pageSize);
}
