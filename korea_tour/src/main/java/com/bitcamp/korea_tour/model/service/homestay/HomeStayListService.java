package com.bitcamp.korea_tour.model.service.homestay;

import java.util.List;

import com.bitcamp.korea_tour.model.homestay.HomeStayListDto;


public interface HomeStayListService {
	List<HomeStayListDto> getAllHomeStayList(int start, int perPage);
	int getTotalHomeStayList();
	Double getTest();
}
