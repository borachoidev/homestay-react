package com.bitcamp.korea_tour.model.service.homestay;

import java.util.List;

import com.bitcamp.korea_tour.model.homestay.HomeStayReviewDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReviewDto;

public interface HomeStayReviewService {
	List<JoinHomeStayReviewDto> getAllReview(int homeStayNum);
	int maxOfRegroup();
	void insertReview(HomeStayReviewDto dto);
	void insertAnswerReview(HomeStayReviewDto dto);
}