package com.booking.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.movie.util.BuildMockData;

@RestController
public class DataController {
	
	@Autowired
	private BuildMockData buildMockData;
	
	@GetMapping("data")
	public String createData() {
		
		buildMockData.createData();
		return "data created";
		
	}

}
