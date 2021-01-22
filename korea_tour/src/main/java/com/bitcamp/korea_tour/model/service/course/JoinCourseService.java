package com.bitcamp.korea_tour.model.service.course;

import java.util.List;
import java.util.Map;

import com.bitcamp.korea_tour.model.JoinCourseDto;

public interface JoinCourseService {
	List<JoinCourseDto> getMyCourseList(int loginNum);  //세션 로그인num 받아오기
	JoinCourseDto getMyCourseDetail(int courseNum);
	List<JoinCourseDto> getMyMarkCourse(int loginNum);  //세션 로그인num 받아오기
	List<JoinCourseDto> getAllCourseByTime();
	List<JoinCourseDto> getAllCourseByLike();
	List<JoinCourseDto> getTagCourseByTime(String who, String during, String how);
	List<JoinCourseDto> getTagCourseByLike(String who, String during, String how);
	List<JoinCourseDto> getSearchCourseByTime(String keyword);
	List<JoinCourseDto> getSearchCourseByLike(String keyword);
	List<JoinCourseDto> getCustomCourseByTime(String who, String during, String how);
	List<JoinCourseDto> getCustomCourseByLike(String who, String during, String how);

}
