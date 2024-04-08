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
public class RecommendPesticide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pRecomID;
	@NotBlank(message = "Crop Image is must be Required")
	private String cropIMG;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fID", referencedColumnName = "fID")
	@JsonIgnoreProperties("pesticides")
	
	private Farmer farmer;
}
