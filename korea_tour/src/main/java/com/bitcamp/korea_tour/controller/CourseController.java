package com.bitcamp.korea_tour.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class CourseController {

	private final JoinCourseDetailService joinCourseDetailService;


//	@GetMapping("")
//	public JsonDataList getCourseDetail(@PathVariable int courseNum) {
//		CourseDto courseDto=joinCourseDetailService.getCourseData(courseNum);
//		List<JoinCourseDetailDto> list=joinCourseDetailService.getCourseDetail(courseNum);
//		return new JsonDataList(courseDto, list);
//	}

	/*
	 * @GetMapping("") ///courses/{searchType}/{sortType}?who=?&how=... public void
	 * getString(
	 * 
	 * @PathVariable String searchType,
	 * 
	 * @PathVariable String sortType,
	 * 
	 * @ModelAttribute MyDto model) {
	 * 
	 * System.out.println(model);
	 * 
	 * 
	 * 
	 * }
	 */


	@Data
	@AllArgsConstructor
	static class JsonDataList {
		private CourseDto dto; //dto
		private List<JoinCourseDetailDto> list;  //list
	}


	
}