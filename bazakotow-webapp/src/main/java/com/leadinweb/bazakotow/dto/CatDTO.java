package com.leadinweb.bazakotow.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class CatDTO {
	
	@NotBlank
	private String name;
	
	@NotNull
	private Float weight;
	
	@NotBlank
	private String ownersName;
	
	@NotBlank
	@Pattern(regexp="[0-3]?[0-9]-[0-1]?[0-9]-[1-2][0-9]{3}")
	private String birthDate;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Float getWeight() {
		return weight;
	}
	
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	public String getOwnersName() {
		return ownersName;
	}
	
	public void setOwnersName(String ownersName) {
		this.ownersName = ownersName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}	
}
