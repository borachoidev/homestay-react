package com.bitcamp.korea_tour.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.PlaceDto;

@Mapper
public interface PlaceMapper {

	void insertApiPlaces(PlaceDto dto);
}
