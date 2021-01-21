package com.bitcamp.korea_tour.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.bitcamp.korea_tour.model.PlaceAnswerDto;

@Mapper
public interface PlaceAnswerMapper {
	void insertPlaceAnswer(PlaceAnswerDto dto); //댓글 입력
	void insertPlaceAnswerRE(PlaceAnswerDto dto); //대댓글 입력
	void deletePlaceAnswerByUser(int placeAnswerNum); //유저본인이 댓글 삭제
	void deletePlaceAnswerByAdmin(int placeAnswerNum); //관리자에 의해 댓글 삭제
	List<PlaceAnswerDto> getAnswerOfPlace(int contentId); //해당 place의 전체 댓글 출력
	List<PlaceAnswerDto> getUserAnswer(HashMap<Integer, Integer> ua); // 본인이 쓴 댓글 출력 (마이페이지 용)
	List<PlaceAnswerDto> getAdminAnswer(int relevel); // 전체 댓글 출력(관리자용)
	
} 

