package com.bitcamp.korea_tour.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CoursePlaceDto;
import com.bitcamp.korea_tour.model.service.course.CoursePlaceService;
import com.bitcamp.korea_tour.model.service.course.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
//@RequestMapping(value="/api")
public class CourseTempController {
	private final CourseService courseService;
	private final CoursePlaceService coursePlaceService;
	
	@PostMapping(value="/courses")
	public void insertCourse(
			@Param("name") String name, @Param("loginNum") int loginNum
			) {
		courseService.insertCourseTitle(name, loginNum);
	}
	
	@PostMapping(value="/courseplaces")
	public void insertCoursePlace(
			@RequestBody CoursePlaceDto dto
			) {
		coursePlaceService.insertCoursePlace(dto);
	}
	
	@DeleteMapping(value="/courses/{courseNum}")
	public void deleteCourse(
			@PathVariable int courseNum
			) {
		courseService.deleteMyCourse(courseNum);
	}
	
	@DeleteMapping(value="/courseplaces/{coursePlaceNum}")
	public void deleteCoursePlace(
			@PathVariable int coursePlaceNum
			) {
		coursePlaceService.deleteCoursePlace(coursePlaceNum);
	}
	
	@PutMapping(value="/courses")
	public void updateCourse(
			@ModelAttribute CourseDto dto
			) {
		courseService.updateCourseDetail(dto);
	}
	
	@PatchMapping(value="/courseplaces/{courseNum}/{orderType}")
	public void updateCoursePlace(
			@PathVariable int courseNum,
			@PathVariable String orderType,
			@Param("coursePlaceNum") int coursePlaceNum,
			@Param("orderNum") int orderNum
			) {
		int totalCount=coursePlaceService.getTotalCoursePlace(courseNum);
		
		if(orderNum>1 && orderType.equals("up")) {
			coursePlaceService.updateCoursePlace(coursePlaceNum, orderNum-1);
		}else if(orderNum<totalCount && orderType.equals("down"))
			coursePlaceService.updateCoursePlace(coursePlaceNum, orderNum-1);
			
	}
	
}
