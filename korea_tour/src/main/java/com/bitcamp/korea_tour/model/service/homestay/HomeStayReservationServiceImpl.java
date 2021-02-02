package com.bitcamp.korea_tour.model.service.homestay;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReservationDto;
import com.bitcamp.korea_tour.model.mapper.HomeStayReservationMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayReservationServiceImpl implements HomeStayReservationService{

	private final HomeStayReservationMapper mapper;

	@Override
	public int getTotalCount(int loginNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(loginNum);
	}

	@Override
	public int getCountByWating(int loginNum) {
		// TODO Auto-generated method stub
		return mapper.getCountByWating(loginNum);
	}

	@Override
	public int getCountByCancel(int loginNum) {
		// TODO Auto-generated method stub
		return mapper.getCountByCancel(loginNum);
	}

	@Override
	public int getCountByApproved(int loginNum) {
		// TODO Auto-generated method stub
		return mapper.getCountByApproved(loginNum);
	}

	@Override
	public List<JoinHomeStayReservationDto> getAllDatas(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getAllDatas(map);
	}

	@Override
	public List<JoinHomeStayReservationDto> getDatasByWating(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getDatasByWating(map);
	}

	@Override
	public List<JoinHomeStayReservationDto> getDatasByCancel(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getDatasByCancel(map);
	}

	@Override
	public List<JoinHomeStayReservationDto> getDatasByApproved(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getDatasByApproved(map);
	}
	
	
}
