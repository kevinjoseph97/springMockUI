package com.mockUIBackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mockUIBackend.model.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	

}
