package com.bitcamp.korea_tour.model.service.homestay;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;

public interface HomeStayHostService {
	   void insertHomeStay(HomeStayDto dto);
	   void insertHomeStayDetail(HomeStayDetailDto dto);
}