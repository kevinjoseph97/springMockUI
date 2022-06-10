package com.mockUIBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockUIBackend.DTO.EmployeeDTO;
import com.mockUIBackend.exception.EmplNotFoundException;
import com.mockUIBackend.repository.CityRepo;
import com.mockUIBackend.repository.DesignationRepo;
import com.mockUIBackend.repository.EmployeeRepo;
import com.mockUIBackend.service.EmployeeService;

@RestController
@RequestMapping("/MockUI")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService emplService;
	
	@Autowired
	private DesignationRepo desRepo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private Environment environment;
	
	
	
	//get a certain employee
	@GetMapping(value= "/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id) throws EmplNotFoundException{
		EmployeeDTO e = emplService.getEmployee(id);
		return new ResponseEntity<EmployeeDTO>(e, HttpStatus.OK);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
