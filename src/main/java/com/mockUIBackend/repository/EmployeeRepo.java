package com.mockUIBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mockUIBackend.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	

}
