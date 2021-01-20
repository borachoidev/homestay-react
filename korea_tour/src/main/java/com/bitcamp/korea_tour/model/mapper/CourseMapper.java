package com.bitcamp.korea_tour.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.bitcamp.korea_tour.model.CourseDto;

@Mapper
public interface CourseMapper {
	int myCourseCount();
	void getMyCourseData();
	void insertCourseTitle(CourseDto dto);
	void deleteMyCourse(int courseNum);
}
