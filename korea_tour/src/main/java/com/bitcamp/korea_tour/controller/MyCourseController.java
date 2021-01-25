/*
 * package com.bitcamp.korea_tour.controller;
 * 
 * import org.apache.ibatis.annotations.Param; import
 * org.springframework.web.bind.annotation.PostMapping;
 * 
 * import com.bitcamp.korea_tour.model.CourseDto; import
 * com.bitcamp.korea_tour.model.service.course.CourseService;
 * 
 * public class MyCourseController {
 * 
 * private final CourseService courseService;
 * 
 * @PostMapping(value="/courses") public void insertCourse(@Param("name") String
 * name, @Param("loginNum") int loginNum) {
 * courseService.insertCourseTitle(name, loginNum); CourseDto dto=new
 * CourseDto(); dto.setName(name); dto.setUserNum(loginNum);
 * 
 * }
 * 
 * }
 * 
 */