package com.bitcamp.korea_tour.model.service.course;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.korea_tour.model.CoursePlaceDto;

public interface CoursePlaceService {
	void insertCoursePlace(CoursePlaceDto dto);
	void deleteCoursePlace(int coursePlaceNum);
	int getTotalCoursePlace(int courseNum);
	void updateCoursePlace(@Param("coursePlaceNum") int coursePlaceNum, @Param("orderNum") int orderNum);
}
