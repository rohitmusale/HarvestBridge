package com.harvestBridge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int oID;
	@NotBlank(message = "Address is must be Required")
	private String oAddress;
	@NotBlank(message = "Items is must be Required")
	private String oItems;
	private int oPrice;
	
	private String payMethod;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cID", referencedColumnName = "cID")
//	@JoinColumn(name = "cName", referencedColumnName = "cName")
//	@JoinColumn(name = "cEmail", referencedColumnName = "cEmail")
	@JsonIgnoreProperties("orders")
	
	private Customer customer;
}
