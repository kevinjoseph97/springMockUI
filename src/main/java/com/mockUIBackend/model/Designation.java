package com.mockUIBackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="designation")
public class Designation implements Serializable {
	
	private Integer id;
	
	private String designation;
	
	public Designation() {
		
	}

	public Designation(Integer id, String designation) {
		super();
		this.id = id;
		this.designation = designation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Designation [id=" + id + ", designation=" + designation + "]";
	}
	
	
	
	
	
	
	
	

}
