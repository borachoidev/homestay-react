package com.bitcamp.korea_tour.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.bitcamp.korea_tour.model.CourseDto;

@Mapper
public interface CourseMapper {
	//1. mypage에서 내 코스 목록 개수출력
	//2. 내 코스 목록
	//3. 내 코스 공간 생성(첫 작성은 기본 비공개로)
	//4. 내 코스 삭제
	//5. 공유하면 공유+1
	//6. 코스 place(orderNum) 빼고 모든 걸 바꾸기
	
	int myCourseCount(int userNum);
	CourseDto getMyCourseData(int userNum);
	void insertCourseTitle(CourseDto dto);
	void deleteMyCourse(int courseNum);
	void updateShare(int courseNum);
}
