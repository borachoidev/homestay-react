package com.bitcamp.korea_tour.model.service;

import com.bitcamp.korea_tour.model.CourseLikeDto;

public interface CourseLikeService {
	int getTotalCourseLike(int courseNum);
	void insertCourseLike(CourseLikeDto dto);
	void deleteCourseLike(String loginId, int courseNum);
}
