package com.bitcamp.korea_tour.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.bitcamp.korea_tour.model.CourseDto;

@Mapper
public interface CourseMapper {
	//1. 내 코스 공간 생성(첫 작성은 기본 비공개로)
	//2. 내 코스 삭제
	//3. 공유하면 공유+1
	//4. 코스 테이블 수정(코스관광지는 coursePlace 테이블에서 처리)
	
	void insertCourseTitle(Map<String, String> title, Map<String, Integer> num);
	void deleteMyCourse(int courseNum);
	void updateShare(int courseNum);
	void updateCourseDetail(CourseDto courseDto);
	void updateCourseTotalLike(Map<String, Integer> courseLike);
}
