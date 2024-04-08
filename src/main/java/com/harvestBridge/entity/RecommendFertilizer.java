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
public class RecommendFertilizer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fRecomID;
	@Min(value = 4, message="Nitrogen Values must be at least 4 digits")
	private int nitrogen;
	@Min(value = 4, message="Phosphorous Values must be at least 4 digits")
	private int phosphorous;
	@Min(value = 4, message="Potassium Values must be at least 4 digits")
	private int potassium;
	@NotBlank(message = "Crop is must be Required")
	private String crop;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fID", referencedColumnName = "fID")
	@JsonIgnoreProperties("fertilizers")
	
	private Farmer farmer;
}
