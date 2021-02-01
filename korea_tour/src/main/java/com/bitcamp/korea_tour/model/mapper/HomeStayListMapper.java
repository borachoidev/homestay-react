package com.bitcamp.korea_tour.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.homestay.HomeStayListDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;

@Mapper
public interface HomeStayListMapper {
	List<HomeStayListDto> getAllHomeStayList(Map<String, Integer> paging);
	List<HomeStayPhotoDto> getAllHomeStayPhoto(int homeStayNum);
	int getTotalHomeStayList();
}
