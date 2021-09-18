package com.asus.flight.service;

import java.util.List;

import com.asus.flight.dto.FlightDto;
import com.asus.flight.entity.Flight;

public interface FlightService {

	
	public FlightDto createFlight(FlightDto flightDto);
	public FlightDto getFlight(Integer id);
	public FlightDto updateFlight(FlightDto flightDto);
	public void deleteFlight(Integer id);
	public List<FlightDto> getAllFlight();
	public FlightDto getFlightByFlightNumber(String flightNUmber);
}
