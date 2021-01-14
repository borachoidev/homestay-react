package com.bitcamp.korea_tour.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
	
	@GetMapping("/course")
	public String getCourseList() {
		
		return "course/list";
	}
	
	@GetMapping("/course/detail")
	public String getCourseDetail() {
		
		return "course/detail";
	}
	
}
