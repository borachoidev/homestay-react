package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageCourseRedirectController {
	
	@GetMapping("/tourmypage")
	public String goMypage(){
		
		return "mypage/mypage";
	}
	
	@GetMapping("/tourmypage/favorite")
	public String goMypageFavorite(){
		
		return "mypage/favorite";
	}
	
	@GetMapping("/tourmypage/answer")
	public String goMypageAnswer(){
		
		return "mypage/answer";
	}
	
	@GetMapping("/tourmypage/courselist")
	public String goMycourseList(){
		//내가만든코스리스트보기
		return "course/mycourse";
	}
	
	@GetMapping("/tourmypage/courselist/detail")
	public String goMycourseDetail(){
		
		return "course/detail";
	}
	
	@GetMapping("/tourcourse")
	public String goCourse(){
		
		return "course/list";
	}
	
	@GetMapping("/tourcourse/detail")
	public String goCourseDetail(){
		
		return "course/detail";
	}
	
	
	
}
