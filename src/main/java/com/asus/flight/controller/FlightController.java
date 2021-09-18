package com.asus.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asus.flight.dto.FlightDto;
import com.asus.flight.entity.Flight;
import com.asus.flight.service.FlightService;

@RestController
@RequestMapping(path = "/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/{id}")
	public FlightDto getFlight(@PathVariable(name = "id") Integer id) {
		return flightService.getFlight(id);
	}
	@GetMapping
	public List<FlightDto> getAllFlight() {
		return flightService.getAllFlight();
	}
	@GetMapping("/findNumbers/{flightNumber}")
	public FlightDto getFlightByFlightNumber(@PathVariable(name = "flightNumber") String flightNumber) {
		return flightService.getFlightByFlightNumber(flightNumber);
	}
	@PostMapping
	public FlightDto createFlight(@RequestBody FlightDto flightDto) {
		return flightService.createFlight(flightDto);
	}
	@PutMapping
	public FlightDto updateFlight(@RequestBody FlightDto flightDto) {
		return flightService.updateFlight(flightDto);
	}
	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable(name = "id") Integer id) {
		flightService.deleteFlight(id);
	}
}
