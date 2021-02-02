package com.bitcamp.korea_tour.model.service.homestay;

import java.util.List;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayReservationDto;

public interface HomeStayHostService {
	   void insertHomeStay(HomeStayDto dto);
	   void insertHomeStayDetail(HomeStayDetailDto dto);
	   int getTotalCount(int homestayNum);
	   List<HomeStayReservationDto> getAllReservation(int homestayNum,int start, int perPage);
	   HomeStayReservationDto getReservation(int homeStayReservationNum);
}