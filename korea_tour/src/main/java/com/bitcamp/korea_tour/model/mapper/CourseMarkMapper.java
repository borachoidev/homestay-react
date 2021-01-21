package com.bitcamp.korea_tour.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.CourseMarkDto;

@Mapper
public interface CourseMarkMapper {
	//1. 내가 즐겨찾기 누른 수 (userNum별)
	//2. 즐겨찾기 누르기
	//3. 즐겨찾기 취소하기(userNum,CourseNum)
	int getTotalCourseMark(int userNum);
	void insertCourseMark(CourseMarkDto dto);
	void deleteCourseMark(Map<String, Integer> map);
}
