package com.harvestBridge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int prID;
	@NotBlank(message = "Product Image is must be Required")
	private String prImg;
	@NotBlank(message = "Product Name is must be Required")
	private String prName;
	@Min(value = 1, message="Price of Product must be greater than 1")
	private int prPrice;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	@JoinColumn(name = "cID", referencedColumnName = "cID")
	
	
	@JsonIgnoreProperties("products")
	
	private Customer customer;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fID", referencedColumnName = "fID")
	private Farmer farmer;
}
