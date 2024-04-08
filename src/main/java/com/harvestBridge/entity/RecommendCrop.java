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
//import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendCrop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cRecomID;
	@Min(value = 4, message=" NItrogen Values must be at least 4 digits")
	private int nitrogen;
	@Min(value = 4, message="Phosphorous Values must be at least 4 digits")
	private int phosphorous;
	@Min(value = 4, message="Potassium Values must be at least 4 digits")
	private int potassium;
	@Min(value = 4, message="Ph Level Values must be at least 4 digits")
	private int ph;
	@Min(value = 4, message="Rainfall Values must be at least 4 digits")
	private int rainfall;
	@Min(value = 4, message="Temperature Values must be at least 4 digits")
	private int temp;
	@Min(value = 4, message="Huidity Values must be at least 4 digits")
	private int humidity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fID", referencedColumnName = "fID")
	@JsonIgnoreProperties("crops")
	
	private Farmer farmer;
	
}
