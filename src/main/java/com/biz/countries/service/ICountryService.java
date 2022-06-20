package com.biz.countries.service;

import com.biz.countries.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findPaginated(int pageNo, int pageSize);
}
