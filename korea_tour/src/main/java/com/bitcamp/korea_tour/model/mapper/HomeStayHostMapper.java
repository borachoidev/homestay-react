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
   HomeStayReservationDto getReservation(int homeStayReservationNum);
}