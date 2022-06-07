package com.mockUIBackend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockUIBackend.repository.CityRepo;
import com.mockUIBackend.repository.DesignationRepo;
import com.mockUIBackend.repository.EmployeeRepo;

@Transactional
@Service(value = "emplServices")
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private DesignationRepo desigRepo;
	
	
	
	

}
