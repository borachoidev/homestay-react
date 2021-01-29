package com.bitcamp.korea_tour.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;

@Mapper
public interface HomeStayApplyMapper {
   void insertHomeStayApply(HomeStayDto dto);
   void insertHomeStayDetail(HomeStayDetailDto dto);
}