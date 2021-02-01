package com.bitcamp.korea_tour.model.service.homestay;


import java.util.List;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;

public interface HomeStayHouseDetailService {
	HomeStayDto getHomeStayNameAndAddr(int homeStayNum);
	int countOfHouseAnswer(int homeStayNum);
	double avgOfCleanliness(int homeStayNum);
	double avgOfCommunication(int homeStayNum);
	double avgOfCheckIn(int homeStayNum);
	double avgOfAccuracy(int homeStayNum);
	double avgOfLocation(int homeStayNum);
	double avgOfSatisfactionForPrice(int homeStayNum);
	List<HomeStayPhotoDto> getHomeStayPhoto(int homeStayNum);
	String getHomeStayContent(int homeStayNum);
	HomeStayDetailDto getHomeStayFacility(int homeStayNum);
}
