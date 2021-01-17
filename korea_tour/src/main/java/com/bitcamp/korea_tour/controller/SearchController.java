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
	
	// 전체 검색
	@GetMapping("/search")
	public ModelAndView getSearchmain(@RequestParam String keyword) { // 검색어를 파라미터로 받아서 포워딩
		// 검색어가 null일시 현재계절을 키워드로 담는다
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
		mview.setViewName("search/allsearch");
		return mview;
	}
	
	// 맞춤코스 검색
	@GetMapping("/search/course")
	public ModelAndView getCourseSearchMain( // 태그들을 파라미터로 담아서 포워딩
			@RequestParam String who,
			@RequestParam String during,
			@RequestParam String how) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("who", who);
		mview.addObject("during", during);
		mview.addObject("how", how);
		mview.setViewName("search/coursesearch");
		
		return mview;
	}
}
