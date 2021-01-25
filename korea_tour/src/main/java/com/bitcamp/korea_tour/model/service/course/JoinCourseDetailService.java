package com.bitcamp.korea_tour.model.service.course;

import java.util.List;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CourseLikeDto;
import com.bitcamp.korea_tour.model.JoinCourseDetailDto;

public interface JoinCourseDetailService {
	CourseDto getCourseData(int courseNum); //메인코스 디테일에서 출력할 코스내용
	List<JoinCourseDetailDto> getCourseDetail(int courseNum);
	int getCourseMarkTotalCount(int courseNum); //디테일에서 출력할 해당 코스 즐겨찾기 개수
	int hasCourseMark(int courseNum, int loginNum);
	List<CourseLikeDto> getCourseLike(int courseNum); //디테일에서 출력할 해당 코스 좋아요 개수
	CourseDto getMyCourseData(int courseNum, int loginNum); //마이코스 디테일에서 출력할 코스내용
	List<JoinCourseDetailDto> getMyCourseDetail(int courseNum, int loginNum);
}
