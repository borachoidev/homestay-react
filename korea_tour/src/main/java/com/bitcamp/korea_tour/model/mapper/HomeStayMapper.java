package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;

@Mapper
public interface HomeStayMapper {
	/*
	 * 홈스테이 디테일 -  해당 집의 집이름, 주소1(출력)
	 * 해당집의 후기 수 (출력)
	 * cleanliness
	 * communication
	 * checkIn
	 * accuracy
	 * location
	 * satisfactionForPrice
	 * 호스트 집 사진 (출력)
	 * 소개글(출력)
	 * 편의시설(8개)및 ,애견동반, 흡연 (출력)
	 * */
	
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
