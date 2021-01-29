package com.bitcamp.korea_tour.model.service.homestay;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;

public interface HomeStayApplyService {
	   void insertHomeStayApply(HomeStayDto dto);
	   void insertHomeStayDetail(HomeStayDetailDto dto);
}