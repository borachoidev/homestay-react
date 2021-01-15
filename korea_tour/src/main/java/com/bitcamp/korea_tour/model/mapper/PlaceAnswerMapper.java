package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.PlaceAnswerDto;

@Mapper
public interface PlaceAnswerMapper {
	public int getTotalCount();
	public List<PlaceAnswerDto> getAllDatas();
	public void insertdata(PlaceAnswerDto dto);
	public PlaceAnswerDto getData(String placeAnswerNum);
	public void updateData(PlaceAnswerDto dto);
	public void deleteData(PlaceAnswerDto dto);
}
