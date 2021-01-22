package com.bitcamp.korea_tour.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.PlaceLikeDto;

@Mapper
public interface PlaceLikeMapper {
	int getAllPlaceLikeCount(int contentId); //댓글 입력
	void plusPlaceLikes(PlaceLikeDto dto); //유저본인이 댓글 삭제
	void deletePlaceLikes(int placeLikeNum); //관리자에 의해 댓글 삭제
}
