package com.bitcamp.korea_tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bitcamp.korea_tour.model.mapper.MysqlTourMapper;

@Controller
public class MainController {

	@Autowired
	MysqlTourMapper mapper;
	
	@GetMapping({"/index","/"})
	public String getMain() {
		
		return "home/home";
	}
	
}
