package com.bitcamp.korea_tour.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.homestay.HomeStayListDto;

@Mapper
public interface HomeStayListMapper {
	List<HomeStayListDto> getAllHomeStayList(Map<String, Integer> paging);
	int getTotalHomeStayList();
	Integer getHomeStayPhotoNumOfList(int homeStayNum);
	String getHomeStayPhotoOfList(int homeStayPhotoNum);
	Double getTest();
}
