package com.mockUIBackend.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;




@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(name = "first_name")
	@NotNull(message = "First Name Is Required")
	private String firstName;
	
	@Column(name ="last_name")
	@NotNull(message = "Last Name Is Required")
	private String lastName;
	
	@Column(name ="joining_date")
	private LocalDate joiningDate;
	
	@Column(name ="email_address")
	@NotNull(message = "Email Is Required")
	private String emailAddress;
	
	@Column(name="phone_number")
	@NotNull(message = "Phone Number is Required")
	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="designation_id")
	private Designation designation;
	
	@Column(name ="picture")
	private String picture;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;
	
	
	public Employee() {
		
	}

	public Employee(Integer id, String firstName, String lastName, LocalDate joiningDate, String emailAddress,
			String phoneNumber, Designation designation, String picture, City city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.joiningDate = joiningDate;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.designation = designation;
		this.picture = picture;
		this.city = city;
	}

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

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", joiningDate="
				+ joiningDate + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", picture="
				+ picture + "]";
	}


}
