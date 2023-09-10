package com.example.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
	
	private String employerName;
	
	private String positionName;
	
	private int numberOfOpenPosition;
	
	private Date createdDate;               //LocalDate?
	
	private Date applicationDate;
	
}
