package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import com.bitcamp.korea_tour.model.mapper.MysqlTourMapper;
>>>>>>> 1a877bca3817169b1b92de358faec21e416ecfad

@Controller
public class MainController {
	
<<<<<<< HEAD
	@GetMapping("/")
	public String getMain() {
		return "home";
=======
	@GetMapping({"/index","/"})
	public String getMain() {
		
		return "home/home";
>>>>>>> 1a877bca3817169b1b92de358faec21e416ecfad
	}
	
}
