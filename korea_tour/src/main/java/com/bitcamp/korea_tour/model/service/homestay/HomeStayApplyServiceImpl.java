package com.bitcamp.korea_tour.model.service.homestay;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.mapper.HomeStayApplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayApplyServiceImpl implements HomeStayApplyService {

	private final HomeStayApplyMapper mapper;


	@Override
	public void insertHomeStayApply(HomeStayDto dto) {
		// TODO Auto-generated method stub
		mapper.insertHomeStayApply(dto);
	}

	@Override
	public void insertHomeStayDetail(HomeStayDetailDto dto) {
		// TODO Auto-generated method stub
		mapper.insertHomeStayDetail(dto);
	}

}