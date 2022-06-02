package com.mockUIBackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="city")
public class City implements Serializable {

	private Integer id;
	
	private String city;
	
	public City() {
		
	}

	public City(Integer id, String city) {
		super();
		this.id = id;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + "]";
	}
	
	
	
}
