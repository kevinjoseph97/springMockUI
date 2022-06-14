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
		Optional<Employee> optionEmp = empRepo.findById(employeeDTO.getId());
		Employee employee = optionEmp.orElseThrow(() -> 
		new EmplNotFoundException("Employee Not Found"));
		
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setJoiningDate(employeeDTO.getJoiningDate());
		employee.setEmailAddress(employeeDTO.getEmailAddress());
		employee.setPhoneNumber(employeeDTO.getPhoneNumber());
		
		Optional<City> optionCity = cityRepo.findById(employeeDTO.getCity().getId());
		City city = optionCity.orElseThrow(() -> 
				new EmplNotFoundException("No City Found"));
		
		Optional<Designation> optionDesignation = desigRepo.findById(employeeDTO.getDesignation().getId());
		Designation designation = optionDesignation.orElseThrow(()->
				new EmplNotFoundException("Designation Not Found"));
				
		
		employee.setDesignation(designation);
		employee.setCity(city);
		
		employee = empRepo.save(employee);
		DesignationDTO dDTO = DesignationDTO.prepareDTO(designation);
		CityDTO cDTO = CityDTO.prepareDTO(city);
		
				
	}


	@Override
	public List<String> getDesignations() throws EmplNotFoundException {
		// TODO Auto-generated method stub
		
		Iterable<Designation> designations = desigRepo.findAll();
		List<String> designationNames = new ArrayList<>();
		for (Designation desig: designations) {
			designationNames.add(desig.getDesignation());
		}
		
		return designationNames;
	}


	@Override
	public List<String> getCities() throws EmplNotFoundException {
		Iterable<City> cities = cityRepo.findAll();
		List<String> cityNames = new ArrayList<String>();
		for (City city: cities) {
			cityNames.add(city.getCity());
		}
		return cityNames;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


