package com.mockUIBackend.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockUIBackend.DTO.CityDTO;
import com.mockUIBackend.DTO.DesignationDTO;
import com.mockUIBackend.DTO.EmployeeDTO;
import com.mockUIBackend.exception.EmplNotFoundException;
import com.mockUIBackend.model.Employee;
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
	
	
	public EmployeeDTO getEmployee (Integer id) throws EmplNotFoundException {
		
		Optional<Employee> optionalEmployee = empRepo.findById(id);
		Employee employee = optionalEmployee.orElseThrow(() -> 
			new EmplNotFoundException("Employee Not Found"));
		
		EmployeeDTO eDTO = EmployeeDTO.prepareDTO(employee);
		DesignationDTO dDTO = DesignationDTO.prepareDTO(employee.getDesignation());
		CityDTO cDTO = CityDTO.prepareDTO(employee.getCity());
		
		eDTO.setDesignation(dDTO);
		eDTO.setCity(cDTO);
		
		return eDTO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
