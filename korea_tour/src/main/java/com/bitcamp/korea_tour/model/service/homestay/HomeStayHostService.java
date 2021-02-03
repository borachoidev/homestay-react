package com.bitcamp.korea_tour.model.service.homestay;

import java.util.List;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayReservationDto;

public interface HomeStayHostService {
	   void insertHomeStay(HomeStayDto dto);
	   void insertHomeStayDetail(HomeStayDetailDto dto);
	   int getTotalCount(int homestayNum);
	   List<HomeStayReservationDto> getAllReservation(int homestayNum,int approval,int start, int perPage);
	   int getApprovalCount(int homeStayNum);
	   List<HomeStayReservationDto> getApprovalReservation(int homeStayNum, int start, int perPage);
	   int getRefusedCount(int homeStayNum);
	   List<HomeStayReservationDto> getRefusedReservation(int homeStayNum, int start, int perPage);
	   int getPendingCount(int homeStayNum);
	   List<HomeStayReservationDto> getPendingReservation(int homeStayNum, int start, int perPage);
	   HomeStayReservationDto getReservation(int homeStayReservationNum);
	   void updateApproval(HomeStayReservationDto dto, int homeStayReservationNum, int approval);
}