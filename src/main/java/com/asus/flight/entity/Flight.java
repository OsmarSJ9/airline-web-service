package com.asus.flight.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "flight_number", nullable = false)
	private String flightNumber;
	
	@Column(name = "capacity" , nullable = false)
	private int capacity;
	
	@Column(name = "mf_by" , nullable = false)
	private String mfdBy;
	
	@Column(name = "mf_on" , nullable = false)
	
	private LocalDate mfdOn;
}
