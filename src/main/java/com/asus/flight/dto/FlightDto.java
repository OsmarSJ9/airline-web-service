package com.asus.flight.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

	private Integer id;
	
	private String flightNumber;
	
	private int capacity;
	
	private String mfdBy;
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate mfdOn;
}
