package com.biz.countries.service;

import com.biz.countries.response.exception.DuplicateResourceException;
import com.biz.countries.response.exception.ResourceNotFoundException;
import com.biz.countries.model.Country;
import com.biz.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository repository;

    @Override
    public Country createCountry(Country country) {
        Optional<Country> savedCountry = repository.findCountryByNameIgnoreCase(country.getName());
        if(savedCountry.isPresent()){
            throw new DuplicateResourceException("Country with name: " + country.getName() + " already exists");
        }
        return repository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> savedCountry = repository.findById(country.getId());
        if(savedCountry.isPresent()){
            Country currentCountry = savedCountry.get();
            currentCountry.setId(country.getId());
            currentCountry.setName(country.getName());
            return currentCountry;
        }else {
            throw new ResourceNotFoundException("Country with name:" + country.getName() + " not found");
        }
    }

    @Override
    public Page<Country> getAllCountry(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Country> pagedResult = repository.findAll(paging);
        return pagedResult;
    }

    @Override
    public Country getCountryById(long id) {
        Optional<Country> savedCountry = repository.findById(id);
        if(savedCountry.isPresent()){
            return savedCountry.get();
        }
        else{
            throw new ResourceNotFoundException("No country with id: " + id + " exists");
        }
    }

    @Override
    public Page<Country> getCountriesByName(String name, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Country> pagedResult = repository.findCountriesByNameContainingIgnoreCase(name, paging);
        return pagedResult;
    }

    @Override
    public void deleteCountry(long id) {
        Optional<Country> savedCountry = repository.findById(id);
        if(savedCountry.isPresent()){
            repository.delete(savedCountry.get());
        }else{
            throw new ResourceNotFoundException("No country with id: " + id + " exists");
        }
    }

    @Override
    public List<Country> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Country> pagedResult = repository.findAll(paging);

        return pagedResult.toList();
    }
}
