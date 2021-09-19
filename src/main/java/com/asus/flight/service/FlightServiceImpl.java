package com.asus.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asus.flight.dto.FlightDto;
import com.asus.flight.entity.Flight;
import com.asus.flight.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public FlightDto createFlight(FlightDto flightDto) {

		Flight flight = new Flight();

		BeanUtils.copyProperties(flightDto, flight);

		flight = flightRepository.save(flight);

		BeanUtils.copyProperties(flight, flightDto);

		return flightDto;
	}

	@Override
	public FlightDto getFlight(Integer id) {

		Optional<Flight> flight = flightRepository.findById(id);

		FlightDto flightDto = null;

		if (flight.isPresent()) {
			flightDto = new FlightDto();
			BeanUtils.copyProperties(flight.get(), flightDto);
		}

		return flightDto;
	}

	@Override
	public FlightDto updateFlight(FlightDto flightDto) {

		Optional<Flight> flightOptional = flightRepository.findById(flightDto.getId());
		if (flightOptional.isPresent()) {
			Flight flight = new Flight();

			BeanUtils.copyProperties(flightDto, flight);
			flight = flightRepository.save(flight);

			BeanUtils.copyProperties(flight, flightDto);

		} else {
			// throw Exception
		}

		return flightDto;
	}

	@Override
	public void deleteFlight(Integer id) {

		Optional<Flight> flight = flightRepository.findById(id);
		if (flight.isPresent()) {
			flightRepository.deleteById(id);
		} else {
			// throw Exception
		}

	}

	@Override
	public List<FlightDto> getAllFlight() {

		List<Flight> flightList = flightRepository.findAll();

		List<FlightDto> flightDtoList = new ArrayList<FlightDto>();

		for (int i = 0; i < flightList.size(); i++) {
			FlightDto flightDto = new FlightDto();
			BeanUtils.copyProperties(flightList.get(i), flightDto);
			flightDtoList.add(flightDto);
			logger.info(" " + flightDtoList.get(i));
		}
		return flightDtoList;
	}

	@Override
	public FlightDto getFlightByFlightNumber(String flightNUmber) {

		Flight flight = flightRepository.findByflightNumber(flightNUmber);
		FlightDto flightDto = new FlightDto();
		BeanUtils.copyProperties(flight, flightDto);
		return flightDto;
	}

}
