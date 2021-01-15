package com.bitcamp.korea_tour.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

	// 현재 month
	SimpleDateFormat sdf = new SimpleDateFormat("MM");
	Date currDate = new Date();
	int currentMonth = Integer.parseInt(sdf.format(currDate));
	
	@GetMapping("/search")
	public ModelAndView getCourseMain(@RequestParam String keyword) { // 검색어를 파라미터로 받는다
		if(currentMonth>=3 && currentMonth<6) {
			keyword="봄";
		}else if(currentMonth>=6 && currentMonth<9) {
			keyword="여름";
		}else if(currentMonth>=9 && currentMonth<12) {
			keyword="가을";
		}else {
			keyword="겨울";
		}
		
		ModelAndView mview = new ModelAndView();
		mview.addObject("keyword", keyword);
		mview.setViewName("search/main");
		return mview;
	}
	
}
