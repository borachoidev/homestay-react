package com.bitcamp.korea_tour.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.korea_tour.model.CourseMarkDto;
import com.bitcamp.korea_tour.model.PlaceMarkDto;
import com.bitcamp.korea_tour.model.service.PlaceMarkService;
import com.bitcamp.korea_tour.model.service.course.CourseMarkService;
import com.bitcamp.korea_tour.model.service.course.CourseService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MypageController {
	
	private final CourseMarkService cms;
	private final PlaceMarkService pms;
	private final CourseService cs;
	
	@GetMapping("/mypage")
	public String getMypage(@SessionAttribute("loginNum") int loginNum) {
		//총 즐겨찾기 개수찾기
		int totalcoursemark = cms.getMyCourseMarkCount(loginNum);
		int totalplacemark = pms.getAllMyPlaceMarkCount(loginNum);
		int totalMark = totalcoursemark+totalplacemark;
		
		//나의 코스 개수 찾기
		int totalmycourse = cs.getMyCourseCount(loginNum);
		
		//나의 댓글 개수 찾기
		
		Map<String, Integer> mypagecount = new HashMap<String, Integer>();
		mypagecount.put("totalMark", totalMark);
		mypagecount.put("totalmycourse", totalmycourse);
		System.out.println(mypagecount);
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
	
	
	
	@Data
	@AllArgsConstructor
	static class JsonDataList{
		private CourseMarkDto cdto;
		private PlaceMarkDto pdto;
	}
	
	
	@Data
	@AllArgsConstructor
	static class MyPageDto{
		private String num;
	}
}
