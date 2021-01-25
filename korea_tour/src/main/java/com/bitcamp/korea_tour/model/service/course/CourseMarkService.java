package com.bitcamp.korea_tour.model.service.course;

import java.util.List;

import com.bitcamp.korea_tour.model.CourseMarkDto;

public interface CourseMarkService {
	void insertCourseMark(CourseMarkDto dto);
	void deleteCourseMark(int courseMarkNum);
	List<CourseMarkDto> getCourseMark(int courseNum);
	int getMyCourseMarkCount(int loginNum);
}
