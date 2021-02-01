package com.bitcamp.korea_tour.model.service.homestay;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;
import com.bitcamp.korea_tour.model.mapper.HomeStayMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayHouseDetailServiceImpl implements HomeStayHouseDetailService{
	private final HomeStayMapper mapper;
	
	@Override
	public HomeStayDto getHomeStayNameAndAddr(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.getHomeStayNameAndAddr(homeStayNum);
	}

	@Override
	public int countOfHouseAnswer(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.countOfHouseAnswer(homeStayNum);
	}

	@Override
	public double avgOfCleanliness(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.avgOfCleanliness(homeStayNum);
	}

	@Override
	public double avgOfCommunication(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.avgOfCommunication(homeStayNum);
	}

	@Override
	public double avgOfCheckIn(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.avgOfCheckIn(homeStayNum);
	}

	@Override
	public double avgOfAccuracy(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.avgOfAccuracy(homeStayNum);
	}

	@Override
	public double avgOfLocation(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.avgOfLocation(homeStayNum);
	}

	@Override
	public double avgOfSatisfactionForPrice(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.avgOfSatisfactionForPrice(homeStayNum);
	}

	@Override
	public List<HomeStayPhotoDto> getHomeStayPhoto(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.getHomeStayPhoto(homeStayNum);
	}

	@Override
	public String getHomeStayContent(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.getHomeStayContent(homeStayNum);
	}

	@Override
	public HomeStayDetailDto getHomeStayFacility(int homeStayNum) {
		// TODO Auto-generated method stub
		return mapper.getHomeStayFacility(homeStayNum);
	}
	
}
