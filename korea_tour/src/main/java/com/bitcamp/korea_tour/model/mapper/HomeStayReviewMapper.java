package com.bitcamp.korea_tour.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.homestay.HomeStayReviewDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReviewDto;

@Mapper
public interface HomeStayReviewMapper {
		/*
		 * JOIN : 리뷰출력(글쓴이, 내용, 사진)
		 * Regroup Max 값 구하기
		 * 댓글쓰기
		 * 답글쓰기
		 * */
		List<JoinHomeStayReviewDto> getAllReview(int homeStayNum);
		int maxOfRegroup();
		void insertReview(HomeStayReviewDto dto);
		void insertAnswerReview(HomeStayReviewDto dto);
		int getReviewNum(HashMap<String, Object> map);
		int checkReviewWritten(int homeStayNum, int loginNum);
}
 