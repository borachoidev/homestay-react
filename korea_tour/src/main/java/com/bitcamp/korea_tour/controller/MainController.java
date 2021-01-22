package com.bitcamp.korea_tour.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.TourApi;
import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.PlaceService;
import com.bitcamp.korea_tour.model.service.PlaceServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	PlaceServiceImpl service;
	
	@GetMapping({"/index","/"})
	public String getMain(HttpServletRequest request) {
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
	
	//로그인페이지 이동
	@GetMapping("/login/main")
	public String goLoginMain() {
		return "login/loginform";
	}   
	
	//관리자로그인폼 이동
	@GetMapping("/login/adminlogin")
	public String goAdminLogin() {
		return "login/adminloginform";
	}
	
}
