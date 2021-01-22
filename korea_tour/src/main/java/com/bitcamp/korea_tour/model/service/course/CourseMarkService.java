package com.bitcamp.korea_tour.model.service.course;

import com.bitcamp.korea_tour.model.CourseMarkDto;

public interface CourseMarkService {
	int getTotalCourseMark(int userNum);
	void insertCourseMark(CourseMarkDto dto);
	void deleteCourseMark(int userNum, int courseNum);
}
