package com.bitcamp.korea_tour.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.JoinCourseDto;

@Mapper
public interface JoinCourseMapper {
	/*
	 * <mypage>
	내코스 목록보기 
	내코스 자세히보기 
	내 즐겨찾기 코스 모아보기 
	<main>
	모든코스 모아보기(최신순) 
	모든코스 모아보기(인기순) 
	Nav로 태그 검색한 코스보기(최신순)
	Nav로 태그 검색한 코스보기(인기순) 
	통합검색코스(검색어에 해당하는 관광지가 들어있는 코스까지) 검색쿼리 최신순
	통합겸색코스(검색어에 해당하는 관광지가 들어있는 코스까지) 검색쿼리 인기순
	맞춤코스 검색(최신순)
	맞춤코스 검색(인기순)
	*/
	
	List<JoinCourseDto> getMyCourseList(int loginNum);  //세션 로그인num 받아오기
	JoinCourseDto getMyCourseDetail(int courseNum);
	List<JoinCourseDto> getMyMarkCourse(int loginNum);  //세션 로그인num 받아오기
	List<JoinCourseDto> getAllCourseByTime();
	List<JoinCourseDto> getAllCourseByLike();
	List<JoinCourseDto> getTagCourseByTime(Map<String, String> tag);
	List<JoinCourseDto> getTagCourseByLike(Map<String, String> tag);
	List<JoinCourseDto> getSearchCourseByTime(String keyword);
	List<JoinCourseDto> getSearchCourseByLike(String keyword);
	List<JoinCourseDto> getCustomCourseByTime(Map<String, String> tag);
	List<JoinCourseDto> getCustomCourseByLike(Map<String, String> tag);
}
