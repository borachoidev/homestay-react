package com.bitcamp.korea_tour.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.TourApi;
import com.bitcamp.korea_tour.model.service.PlaceService;
import com.bitcamp.korea_tour.model.service.PlaceServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	PlaceServiceImpl service;
	
	@GetMapping({"/index","/"})
	public String getMain() { 
		
		return "home/home";

	}
	
	@ResponseBody
	@RequestMapping(value="/input/api")
	public String insertApiPlaces() throws IOException, ParserConfigurationException, SAXException {
		TourApi api = new TourApi();
		ArrayList<PlaceDto> list = api.insertPlaceList();
		for(PlaceDto dto : list) {
			service.insertApiPlaces(dto); 
		}
		
		
		return "success";
	}
	
}
