package com.bitcamp.korea_tour.model.service;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.PlaceMarkDto;
import com.bitcamp.korea_tour.model.mapper.CourseMarkMapper;
import com.bitcamp.korea_tour.model.mapper.PlaceMarkMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceMarkServiceImpl implements PlaceMarkService {
	
	private final PlaceMarkMapper mapper; 

	@Override
	public void insertPlaceMark(PlaceMarkDto dto) {
		// TODO Auto-generated method stub
		mapper.insertPlaceMark(dto);
	}

	@Override
	public void deletePlaceMark(int markNum) {
		// TODO Auto-generated method stub
		mapper.deletePlaceMark(markNum);
	}

	@Override
	public int getAllMyPlaceMarkCount() {
		// TODO Auto-generated method stub
		return mapper.getAllMyPlaceMarkCount();
	}

}
