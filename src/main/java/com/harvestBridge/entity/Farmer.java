package com.harvestBridge.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Farmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int fID;
	@NotBlank(message = "Name is must be Required")
	private String fName;
	@Email
	@NotBlank(message = "Name is must be Required")
	private String fEmail;
	@Min(value=10, message="Must be equal to 10 numbers")
	@Max(value=10, message="Must be equal to 10 numbers")
	private int fMobNo;
	@NotBlank(message = "Name is must be Required")
	private String fAddress;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aID", referencedColumnName = "aID")
	@JsonIgnoreProperties("farmers")
	
	private Admin admin;
	
}
