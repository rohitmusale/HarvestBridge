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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int payID;
	@Min(value = 1, message="Payment Price must be at least 1 digits")
	private int payPrice;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({
		@JoinColumn(name = "cID", referencedColumnName = "cID")
//		@JoinColumn(name = "cName", referencedColumnName = "cName"),
//		@JoinColumn(name = "cEmail", referencedColumnName = "cEmail"),
//		@JoinColumn(name = "cMobNo", referencedColumnName = "cMobNo")
//	})
	@JsonIgnoreProperties("payments")
	
	private Customer customer;
}
