package com.bitcamp.korea_tour.model.service.course;

import com.bitcamp.korea_tour.model.CoursePlaceDto;

public interface CoursePlaceService {
	void insertCoursePlace(CoursePlaceDto dto);
	void deleteForNewCoursePlace(int courseNum);
	int getTotalCoursePlace(int courseNum);
}
