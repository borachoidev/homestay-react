package com.bitcamp.korea_tour.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaceController {

	@GetMapping("/place")
	public String getPlaceList() {
		
		return "place/list";
	}
	
	@GetMapping("/place/detail")
	public String getPlaceDetail() {
		
		return "place/detail";
	}
}
