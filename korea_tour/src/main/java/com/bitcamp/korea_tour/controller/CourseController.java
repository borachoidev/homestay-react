package com.bitcamp.korea_tour.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitcamp.korea_tour.model.JoinCourseDto;
import com.bitcamp.korea_tour.model.service.course.JoinCourseService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CourseController {
	
	private JoinCourseService joinCourseService;
	
	@GetMapping("/course")
	public List<JoinCourseDto> getCourseMain() {
		
		return joinCourseService.getAllCourseByTime(0, 10);
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
