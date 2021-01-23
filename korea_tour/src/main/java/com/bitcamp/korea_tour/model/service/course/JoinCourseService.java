package com.bitcamp.korea_tour.model.service.course;

import java.util.List;
import java.util.Map;

import com.bitcamp.korea_tour.model.JoinCourseDto;

public interface JoinCourseService {
	List<JoinCourseDto> getAllCourseByTime(int start, int perPage);
	List<JoinCourseDto> getAllCourseByLike(int start, int perPage);
	JoinCourseDto getMyCourseDetail(int courseNum, int loginNum);
	List<JoinCourseDto> getMyCourseList(int loginNum, int start, int perPage);  //세션 로그인num 받아오기
	List<JoinCourseDto> getMyMarkCourse(int loginNum, int start, int perPage);  //세션 로그인num 받아오기
	List<JoinCourseDto> getTagCourseByTime(String tag, int start, int perPage);
	List<JoinCourseDto> getTagCourseByLike(String tag, int start, int perPage);
	List<JoinCourseDto> getSearchCourseByTime(String keyword, int start, int perPage);
	List<JoinCourseDto> getSearchCourseByLike(String keyword, int start, int perPage);
	List<JoinCourseDto> getCustomCourseByTime(String who, String during, String how, int start, int perPage);
	List<JoinCourseDto> getCustomCourseByLike(String who, String during, String how, int start, int perPage);
	JoinCourseDto getCourseDetail(int courseNum);
}
