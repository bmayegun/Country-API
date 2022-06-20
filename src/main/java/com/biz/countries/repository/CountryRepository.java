package com.biz.countries.repository;

import com.biz.countries.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findCountriesByNameContainingIgnoreCase(String name);
}
