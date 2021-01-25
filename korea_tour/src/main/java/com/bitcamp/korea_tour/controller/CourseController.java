package com.bitcamp.korea_tour.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.JoinCourseDetailDto;
import com.bitcamp.korea_tour.model.JoinCourseDto;
import com.bitcamp.korea_tour.model.service.course.JoinCourseDetailService;
import com.bitcamp.korea_tour.model.service.course.JoinCourseMainService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor
public class CourseController {
	
	private final PagingService pagingService;
	private final JoinCourseMainService joinCourseMainService;
	private final JoinCourseDetailService joinCourseDetailService;
	int totalCount=0;
	int start=0;
	int perPage=0;
	
	@GetMapping("/courses/{currentPage}")
	public JsonData<List<JoinCourseDto>> getAllCourseByTime(@PathVariable int currentPage) {
		totalCount=joinCourseMainService.getAllTotalCount();
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		List<JoinCourseDto> list=joinCourseMainService.getAllCourseByTime(start, perPage);
		System.out.println(currentPage);  
		System.out.println("controller:"+start+","+perPage);
		return new JsonData<List<JoinCourseDto>>(list);
	}
	
	@GetMapping("/courses/detail/{courseNum}")
	public JsonDataList getCourseDetail(@PathVariable int courseNum) {
		CourseDto courseDto=joinCourseDetailService.getCourseData(courseNum);
		List<JoinCourseDetailDto> list=joinCourseDetailService.getCourseDetail(courseNum);
		return new JsonDataList(courseDto, list);
	}
	
	
	
	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T list;
	}
		
	@Data
	@AllArgsConstructor
	static class JsonDataList {
		private CourseDto dto; //dto
		private List<JoinCourseDetailDto> list;  //list
	}

}
