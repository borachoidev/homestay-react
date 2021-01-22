package com.bitcamp.korea_tour.model.service.course;

import com.bitcamp.korea_tour.model.CourseDto;

public interface CourseService {
	public int myCourseCount();
	public void getMyCourseData();
	public void insertCourseTitle(CourseDto dto);
	public void deleteMyCourse(int courseNum);
}
