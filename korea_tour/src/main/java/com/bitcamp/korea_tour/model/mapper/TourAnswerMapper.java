package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.TourAnswerDto;

@Mapper
public interface TourAnswerMapper {
	
	//place
	int getTotalCountPlaceAnswer(int loginNum);
	int getTotalCountPlaceReAnswer(int loginNum);
	void insertPlaceAnswer(TourAnswerDto dto); 
	void deletePlaceAnswerByUser(int tourAnswerNum);
	void deletePlaceAnswerByAdmin(int tourAnswerNum);
	List<TourAnswerDto> getAnswerOfPlace(int contentId); //해당 place 댓글 출력
	List<TourAnswerDto> getUserAnswerPlace(int loginNum); //마이페이지용 댓글 출력
	List<TourAnswerDto> getUserReAnswerPlace(int loginNum); //마이페이지용 답글 출력
	//course
	int getTotalCountCourseAnswer(int loginNum);
	int getTotalCountCourseReAnswer(int loginNum);
	void insertCourseAnswer(TourAnswerDto dto);
	void deleteCourseAnswerByUser(int tourAnswerNum);
	void deleteCourseAnswerByAdmin(int tourAnswerNum);
	List<TourAnswerDto> getAnswerOfCourse(int courseNum); //해당 course 댓글 출력
	List<TourAnswerDto> getUserAnswerCourse(int loginNum); //마이페이지용 댓글 출력
	List<TourAnswerDto> getUserReAnswerCourse(int loginNum); //마이페이지용 답글 출력
	
	//관리자페이지
	List<TourAnswerDto> getAdminAnswer(); //댓글
	List<TourAnswerDto> getAdminReAnswer(); //답글
}
