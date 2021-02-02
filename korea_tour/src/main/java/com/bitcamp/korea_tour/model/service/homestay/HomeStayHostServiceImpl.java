package com.bitcamp.korea_tour.model.service.homestay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayReservationDto;
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
	
	@Override
	public int getTotalCount(int homestayNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(homestayNum);
	}

	@Override
	public List<HomeStayReservationDto> getAllReservation(int homestayNum, int start, int perPage) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("homestayNum", homestayNum);
		map.put("start", start);
		map.put("perPage", perPage);
		List<HomeStayReservationDto> list = mapper.getAllReservation(map);
		return list;
	}

	@Override
	public HomeStayReservationDto getReservation(int homeStayReservationNum) {
		// TODO Auto-generated method stub
		return mapper.getReservation(homeStayReservationNum);
	}



}