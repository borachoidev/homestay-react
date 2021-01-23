package com.bitcamp.korea_tour.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.CourseMarkDto;

@Mapper
public interface CourseMarkMapper {
	//1. 즐겨찾기 누르기
	//2. 즐겨찾기 취소하기(userNum,CourseNum)
	void insertCourseMark(CourseMarkDto dto);
	void deleteCourseMark(int courseMarkNum);
}
