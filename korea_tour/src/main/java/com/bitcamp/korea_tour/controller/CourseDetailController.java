package com.bitcamp.korea_tour.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.JoinCourseDetailDto;
import com.bitcamp.korea_tour.model.service.course.JoinCourseDetailService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseDetailController {
	private final JoinCourseDetailService joincourseDetailService;
	
	
	@GetMapping("/courses/{courseNum}")
	public JsonDataList getCourseDetail(@PathVariable(value="courseNum") int courseNum) {
		
		CourseDto dto=joincourseDetailService.getCourseData(courseNum);
		List<JoinCourseDetailDto> list=joincourseDetailService.getCourseDetail(courseNum);
		
		return new JsonDataList(dto, list);
	}
	
	
	public 
	
	
	
	@Data
	@AllArgsConstructor
	static class JsonDataList {
		private CourseDto dto; //dto
		private List<JoinCourseDetailDto> list;  //list
	}
}
