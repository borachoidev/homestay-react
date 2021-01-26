package com.bitcamp.korea_tour.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.PlacePhotoDto;

@Mapper
public interface PlacePhotoMapper {
	
	void insertData(PlacePhotoDto dto);
	void deleteData(int photoNum);
	int getTotalCount();
	List<PlacePhotoDto> getDisapprovedDatas(HashMap<String, Object> map);
	void approvePhoto(int photoNum);
}
