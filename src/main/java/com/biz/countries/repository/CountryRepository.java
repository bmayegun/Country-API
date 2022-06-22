package com.biz.countries.repository;

import com.biz.countries.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Page<Country> findCountriesByNameContainingIgnoreCase(String name, Pageable pageable);
    Optional<Country> findCountryByNameIgnoreCase(String name);
}
