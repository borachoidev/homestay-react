package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	
	@GetMapping("/mypage")
	public String getMypage() {
		
		return "mypage/mypage";
	}
	
	@GetMapping("/mypage/favorite")
	public String getMyFavorite() {
		
		return "mypage/favorite";
	}
	
	@GetMapping("/mypage/answer")
	public String getMyAnswer() {
		
		return "mypage/answer";
	}
	
	@GetMapping("/mypage/course")
	public String getMyCourse() {
		
		return "mypage/course";
	}
	
	@GetMapping("/mypage/courselist")
	public String getMyCourseList() {
		
		return "mypage/courselist";
	}
}
