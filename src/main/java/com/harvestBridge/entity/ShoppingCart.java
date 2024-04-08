package com.harvestBridge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int scID;
	@Min(value = 1, message="Quantity Values must be at least 1")
	private int prdQuantity;
	private int prdTotalPrice;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cID", referencedColumnName = "cID")
//	@JoinColumn(name = "cName", referencedColumnName = "cName")
//	@JoinColumn(name = "cEmail", referencedColumnName = "cEmail")
//	@JoinColumn(name = "cMobNo", referencedColumnName = "cMobNo")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prID", referencedColumnName = "prID")
//	@JoinColumn(name = "prImg", referencedColumnName = "prImg")
//	@JoinColumn(name = "prName", referencedColumnName = "prName")
//	@JoinColumn(name = "prPrice", referencedColumnName = "prPrice")
	@JsonIgnoreProperties("shopingCarts")
	
	
	private Product product;
	
}
