package com.bitcamp.korea_tour.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.mapper.PlaceMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	private final PlaceMapper mapper;
	
	
	@Override
	public void insertApiPlaces(PlaceDto dto) {
		// TODO Auto-generated method stub
		mapper.insertApiPlaces(dto);
	}

}
