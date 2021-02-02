package com.bitcamp.korea_tour.model.service.homestay;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.mapper.HomeStayHostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayHostServiceImpl implements HomeStayHostService {

	private final HomeStayHostMapper mapper;


	@Override
	public void insertHomeStay(HomeStayDto dto) {
		// TODO Auto-generated method stub
		mapper.insertHomeStay(dto);
	}

	@Override
	public void insertHomeStayDetail(HomeStayDetailDto dto) {
		// TODO Auto-generated method stub
		mapper.insertHomeStayDetail(dto);
	}

}