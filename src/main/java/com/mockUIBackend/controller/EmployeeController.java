package com.mockUIBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockUIBackend.DTO.EmployeeDTO;
import com.mockUIBackend.exception.EmplNotFoundException;
import com.mockUIBackend.model.City;
import com.mockUIBackend.model.Designation;
import com.mockUIBackend.model.Employee;
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
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id) throws EmplNotFoundException{
		EmployeeDTO e = emplService.getEmployee(id);
		return new ResponseEntity<EmployeeDTO>(e, HttpStatus.OK);
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws EmplNotFoundException {
		List<EmployeeDTO> eDTOs = emplService.getAllEmployees();
		return new ResponseEntity<>(eDTOs, HttpStatus.OK);
	}
	
	
	@PostMapping("/employees")
	public ResponseEntity<Integer> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws EmplNotFoundException {
		Integer emplID = emplService.addEmployee(employeeDTO);
		return new ResponseEntity<Integer>(emplID, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) throws EmplNotFoundException {
		emplService.updateEmployee(id, employeeDTO);
		String updateSuccess = environment.getProperty("Updated");
		return new ResponseEntity<String>(updateSuccess, HttpStatus.OK);
	}
	
	
	@GetMapping("/designations")
	public List<Designation> getAllDesignations() {
		return desRepo.findAll();
	}
	
	
	@GetMapping("/cities")
	public List<City> getAllCities() {
		return cityRepo.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
