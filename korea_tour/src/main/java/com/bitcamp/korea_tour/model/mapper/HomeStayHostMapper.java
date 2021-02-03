package com.bitcamp.korea_tour.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayReservationDto;

@Mapper
public interface HomeStayHostMapper {
   void insertHomeStay(HomeStayDto dto);
   void insertHomeStayDetail(HomeStayDetailDto dto);
   int getTotalCount(int homestayNum);
   List<HomeStayReservationDto> getAllReservation(Map<String, Object> map);
   int getApprovalCount(int homeStayNum);
   List<HomeStayReservationDto> getApprovalReservation(Map<String, Object> map);
   int getRefusedCount(int homeStayNum);
   List<HomeStayReservationDto> getRefusedReservation(Map<String, Object> map);
   int getPendingCount(int homeStayNum);
   List<HomeStayReservationDto> getPendingReservation(Map<String, Object> map);
   HomeStayReservationDto getReservation(int homeStayReservationNum);
   void updateApproval(Map<String, Object> map);
}