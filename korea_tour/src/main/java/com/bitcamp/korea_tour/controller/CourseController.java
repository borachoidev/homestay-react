package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
	
	@GetMapping("/course")
	public String getCourseMain() {
		
		return "course/main";
	}
	
	@GetMapping("/course/list")
	public String getCourseList() { // 좋아요순,최신순,who,during,how
		
		return "course/list";
	}
	
	@GetMapping("/course/detail")
	public String getCourseDetail() {
		
		return "course/detail";
	}
	
}
