package com.mockUIBackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mockUIBackend.model.Designation;

@Repository
public interface DesignationRepo  extends CrudRepository<Designation, Integer> {

}
