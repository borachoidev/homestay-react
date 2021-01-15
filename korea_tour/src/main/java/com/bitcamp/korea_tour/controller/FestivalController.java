package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class FestivalController {

	@GetMapping({"/festival/main","/festival"})
	public String getFestivalMain() {
		
		return "/festival/main";
	}
}
