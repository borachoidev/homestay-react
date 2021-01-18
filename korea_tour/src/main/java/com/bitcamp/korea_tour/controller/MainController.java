package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping({"/index","/"})
	public String getMain() {
		
		return "home/home";

	}
	
}
