package com.mockUIBackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mockUIBackend.model.City;

@Repository
public interface CityRepo extends CrudRepository<City, Integer> {

}
