package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlaceController {

	@GetMapping("/place")
	public String getPlaceMain() { 
		
		return "place/main";
	}
	
	@GetMapping("/place/list")
	public ModelAndView getPlaceList(@RequestParam String region) { // 지역 태그를 param을 model에 담아서 포워딩
		ModelAndView mview = new ModelAndView();
		mview.addObject("region", region);
		mview.setViewName("place/list");
		
		return mview;
	}
	
	@GetMapping("/place/detail")
	public ModelAndView getPlaceDetail(@RequestParam String contentId) { // 해당 관광지의 contentId를 담아서 포워딩
		ModelAndView mview = new ModelAndView();
		mview.addObject("contentId", contentId);
		mview.setViewName("place/list");
		
		return mview;
	}
	
}
