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
	메인코스 자세히 보기
	*/
	List<JoinCourseDto> getAllCourseByTime(Map<String, Integer> paging);
	List<JoinCourseDto> getAllCourseByLike(Map<String, Integer> paging);
	JoinCourseDto getMyCourseDetail(Map<String, Integer> nums);
	List<JoinCourseDto> getMyCourseList(Map<String, Integer> num, Map<String, Integer> paging);  //세션 로그인num 받아오기
	List<JoinCourseDto> getMyMarkCourse(Map<String, Integer> num, Map<String, Integer> paging);  //세션 로그인num 받아오기
	List<JoinCourseDto> getTagCourseByTime(Map<String, String> navTag, Map<String, Integer> paging);
	List<JoinCourseDto> getTagCourseByLike(Map<String, String> navTag, Map<String, Integer> paging);
	List<JoinCourseDto> getSearchCourseByTime(Map<String, String> searchKeyword, Map<String, Integer> paging);
	List<JoinCourseDto> getSearchCourseByLike(Map<String, String> searchKeyword, Map<String, Integer> Paging);
	List<JoinCourseDto> getCustomCourseByTime(Map<String, String> tags, Map<String, Integer> paging);
	List<JoinCourseDto> getCustomCourseByLike(Map<String, String> tags, Map<String, Integer> paging);
	JoinCourseDto getCourseDetail(int courseNum);
}
