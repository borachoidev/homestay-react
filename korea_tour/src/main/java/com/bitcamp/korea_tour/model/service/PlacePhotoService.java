package com.bitcamp.korea_tour.model.service;

import java.util.List;

import com.bitcamp.korea_tour.model.PlacePhotoDto;

public interface PlacePhotoService {

	void insertData(PlacePhotoDto dto);
	void deleteData(int photoNum);
	List<PlacePhotoDto> getDisapprovedDatas();
	void approvePhoto(int photoNum);
}
