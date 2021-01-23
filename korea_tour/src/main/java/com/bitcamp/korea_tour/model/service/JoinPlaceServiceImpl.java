package com.bitcamp.korea_tour.model.service;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.mapper.JoinPlaceMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinPlaceServiceImpl implements JoinPlaceService{
	
	private final JoinPlaceMapper mapper;
	
	@Override
	public int getTotalPlaceMark(int userNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalPlaceMark(userNum);
	}

}
