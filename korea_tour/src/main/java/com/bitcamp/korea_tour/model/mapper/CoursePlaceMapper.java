package com.bitcamp.korea_tour.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CoursePlaceDto;

@Mapper
public interface CoursePlaceMapper {
	void insertCoursePlace(CoursePlaceDto dto);
	void deleteCoursePlace(Map<String, Integer> map);
	int getTotalCoursePlace(int courseNum);
}
