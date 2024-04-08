package com.harvestBridge.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aID;
	@NotBlank(message = "Name is must be Required")
	private String aName;
	@Email
	@NotBlank(message = "Email is must be Required")
	private String aEmail;
	//@Digits(integer)
	
	@Min(value=10, message="Must be equal to 10 numbers")
	@Max(value=10, message="Must be equal to 10 numbers")
	private int aMobNo;
	@NotBlank(message = "Address is must be Required")
	private String aAddress;
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("admin")
	
	private List<Farmer> farmers;
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private List<Customer> customers;
}
