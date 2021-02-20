package com.tavant.searchAddress.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	private int Id;
	@NotBlank(message = "address should not be blank")
	private String address;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Address(int id, @NotBlank(message = "address should not be blank") String address) {
		super();
		Id = id;
		this.address = address;
	}
	
	

}
