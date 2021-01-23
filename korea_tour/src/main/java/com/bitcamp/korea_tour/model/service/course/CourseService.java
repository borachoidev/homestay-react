package com.bitcamp.korea_tour.model.service.course;

import com.bitcamp.korea_tour.model.CourseDto;

public interface CourseService {
	public int myCourseCount(int userNum);
	CourseDto getMyCourseData(int userNum);
	public void insertCourseTitle(CourseDto dto);
	public void deleteMyCourse(int courseNum);
	public void updateShare(int courseNum);
	public void updateCourseName(int courseNum);
}
