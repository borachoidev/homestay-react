package com.bitcamp.korea_tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.korea_tour.model.mapper.PlaceAnswerMapper;

@Controller
public class PlaceController {

	@Autowired
	PlaceAnswerMapper mapper;
	
	@GetMapping("/place")
	public String getPlaceList() { // 전체 관광 검색시 param으로 
		
		return "place/list";
	}
	
	@GetMapping("/place/detail")
	public String getPlaceDetail() {
		
		return "place/detail";
	}
}
