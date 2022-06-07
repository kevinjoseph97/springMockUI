package com.mockUIBackend.service;

import java.util.List;

import com.mockUIBackend.DTO.EmployeeDTO;
import com.mockUIBackend.exception.EmplNotFoundException;

public interface EmployeeService {
	
	public EmployeeDTO getEmployee(Integer id);
	
	public List<EmployeeDTO> getAllEmployees();
	
	public Integer addEmployee(EmployeeDTO employeeDTO);
	
	public void updateEmployee(Integer id, EmployeeDTO employeeDTO);
	
	
	List<String> getDesignations() throws EmplNotFoundException;
	
	List<String> getCities() throws EmplNotFoundException;
	
	

}
