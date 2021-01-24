package com.bitcamp.korea_tour.model.service;

import java.util.List;

import com.bitcamp.korea_tour.model.TourAnswerDto;

public interface TourAnswerService {
	
	//place
	void insertPlaceAnswer(TourAnswerDto dto); 
	void deletePlaceAnswerByUser(int tourAnswerNum);
	void deletePlaceAnswerByAdmin(int tourAnswerNum);
	List<TourAnswerDto> getAnswerOfPlace(int contentId); //해당 place 댓글 출력
	List<TourAnswerDto> getUserAnswerPlace(int loginNum, int relevel); //마이페이지용 댓글 출력
	List<TourAnswerDto> getUserReAnswerPlace(int loginNum, int relevel); //마이페이지용 답글 출력
	//course
	void insertCourseAnswer(TourAnswerDto dto);
	void deleteCourseAnswerByUser(int tourAnswerNum);
	void deleteCourseAnswerByAdmin(int tourAnswerNum);
	List<TourAnswerDto> getAnswerOfCourse(int courseNum); //해당 course 댓글 출력
	List<TourAnswerDto> getUserAnswerCourse(int loginNum, int relevel); //마이페이지용 댓글 출력
	List<TourAnswerDto> getUserReAnswerCourse(int loginNum, int relevel); //마이페이지용 답글 출력
	
	//관리자페이지
	List<TourAnswerDto> getAdminAnswer(); //댓글
	List<TourAnswerDto> getAdminReAnswer(); //답글
}
