package com.mockUIBackend.DTO;

import com.mockUIBackend.model.Designation;

public class DesignationDTO {
	
	private Integer id;
	private String designation;
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
	
	public static DesignationDTO prepareDTO(Designation designation) {
		DesignationDTO dDTO= new DesignationDTO();
		dDTO.setId(designation.getId());
		dDTO.setDesignation(designation.getDesignation());
		return dDTO;
		
	}
	
	
	@Override
	public String toString() {
		return "DesignationDTO [id=" + id + ", designation=" + designation + "]";
	}

}
