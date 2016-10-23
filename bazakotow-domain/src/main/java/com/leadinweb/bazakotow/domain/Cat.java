package com.leadinweb.bazakotow.domain;

import java.util.Date;

public class Cat {
	
	private String name;
	private Float weight;
	private String ownersName;
	private Date birthDate;
	
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
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
