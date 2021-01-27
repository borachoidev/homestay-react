package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaceRedirectController {
	
	//관광지 메인 이동
	@GetMapping("/tourplace")
	public String goPlaceMain() {
		return "place/main";
	}
	
	//관광지 메인 이동
	@GetMapping("/tourplace/list")
	public String goPlaceList() {
		return "place/list";
	}
	
	//관광지 메인 이동
	@GetMapping("/tourplace/detail")
	public String goPlaceDetail() {
		return "place/detail";
	}
}
