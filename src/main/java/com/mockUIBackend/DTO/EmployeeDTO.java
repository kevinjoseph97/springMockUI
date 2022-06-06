package com.mockUIBackend.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.mockUIBackend.model.Employee;

public class EmployeeDTO {
	
	private Integer id;
	
	@NotNull(message = "First Name Is Required")
	private String firstName; 
	@NotNull(message = "Last Name Is Required")
	private String lastName;
	
	private LocalDate joiningDate;
	
	@Email(message = "Please enter a valid Email")
	@NotNull(message = "Email Is Required")
	private String emailAddress;
	
	@NotNull(message = "Phone Number is Required")
	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNumber;
	
	private DesignationDTO designation;
	private CityDTO city;
	
	
	private String picture;


	
	//getters and setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public DesignationDTO getDesignation() {
		return designation;
	}


	public void setDesignation(DesignationDTO designation) {
		this.designation = designation;
	}


	public CityDTO getCity() {
		return city;
	}


	public void setCity(CityDTO city) {
		this.city = city;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	//prepare DTO and Entity 
	public static EmployeeDTO prepareDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setJoiningDate(employee.getJoiningDate());
		employeeDTO.setEmailAddress(employee.getEmailAddress());
		employeeDTO.setPhoneNumber(employee.getPhoneNumber());
		employeeDTO.setPicture(employee.getPicture());
		return employeeDTO;
		}
	
	
	public static Employee prepareEntity(EmployeeDTO eDTO) {
		Employee e = new Employee();
		e.setId(eDTO.getId());
		e.setFirstName(eDTO.getFirstName());
		e.setLastName(eDTO.getLastName());
		e.setJoiningDate(eDTO.getJoiningDate());
		e.setEmailAddress(eDTO.getEmailAddress());
		e.setPhoneNumber(eDTO.getPhoneNumber());
		e.setPicture(eDTO.getPicture());
		return e;
	}



	//toString method 
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", joiningDate="
				+ joiningDate + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", picture="
				+ picture + "]";
	}
	
	
	

}
