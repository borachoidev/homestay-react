package com.bitcamp.korea_tour.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.service.PlaceService;
import com.bitcamp.korea_tour.model.service.PlaceServiceImpl;
import com.bitcamp.korea_tour.tourapi.TourApi;

@Controller
public class MainController {
	
	@GetMapping({"/index","/"})
	public String getMain() { 
		
		return "home/home";

	}
}
