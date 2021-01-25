package com.bitcamp.korea_tour.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.CoursePlaceDto;
import com.bitcamp.korea_tour.model.service.course.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseTempController {
	private final CourseService courseService;
	
	@PostMapping(value="/courses")
	public void insertCourse(
			@Param("name") String name, @Param("loginNum") int loginNum
			) {
		courseService.insertCourseTitle(name, loginNum);
	}
	
	@PostMapping(value="/courseplaces")
	public CoursePlaceDto insertCoursePlace(
			@RequestBody CoursePlaceDto dto
			) {
		
		
		
		return dto;
	}
	
}
