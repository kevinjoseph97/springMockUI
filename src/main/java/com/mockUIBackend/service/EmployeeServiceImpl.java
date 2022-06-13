package com.mockUIBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockUIBackend.DTO.CityDTO;
import com.mockUIBackend.DTO.DesignationDTO;
import com.mockUIBackend.DTO.EmployeeDTO;
import com.mockUIBackend.exception.EmplNotFoundException;
import com.mockUIBackend.model.City;
import com.mockUIBackend.model.Designation;
import com.mockUIBackend.model.Employee;
import com.mockUIBackend.repository.CityRepo;
import com.mockUIBackend.repository.DesignationRepo;
import com.mockUIBackend.repository.EmployeeRepo;

@Transactional
@Service(value = "emplServices")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private DesignationRepo desigRepo;
	
	
	@Override
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


	@Override
	public List<EmployeeDTO> getAllEmployees() throws EmplNotFoundException {
		// TODO Auto-generated method stub
		Iterable<Employee> eList = empRepo.findAll();
		List<EmployeeDTO> eDTOList = new ArrayList<EmployeeDTO>();
		eList.forEach(e -> {
			EmployeeDTO eDTO =  EmployeeDTO.prepareDTO(e);
			DesignationDTO dDTO = DesignationDTO.prepareDTO(e.getDesignation());
			CityDTO cDTO = CityDTO.prepareDTO(e.getCity());
			eDTO.setDesignation(dDTO);
			eDTO.setCity(cDTO);
			eDTOList.add(eDTO);
		});
		
		if (eDTOList.isEmpty()) {
			throw new EmplNotFoundException("No Employees Present");
		}
		
		return eDTOList;
	}


	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Employee e =  EmployeeDTO.prepareEntity(employeeDTO);
		Optional<City> optionCity = cityRepo.findById(employeeDTO.getCity().getId());
		City city = optionCity.orElseThrow(() -> 
			new EmplNotFoundException("No City Found"));
		
		Optional<Designation> optionDesignation = desigRepo.findById(employeeDTO.getDesignation().getId());
		Designation designation = optionDesignation.orElseThrow(() -> 
			new EmplNotFoundException("No Designation Found"));
		
		
		e.setDesignation(designation);
		e.setCity(city);
		
		Employee emplFromDb	= empRepo.save(e);
		
		return emplFromDb.getId();
	}


	@Override
	public void updateEmployee(Integer id, EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<String> getDesignations() throws EmplNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> getCities() throws EmplNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


