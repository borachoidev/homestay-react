package com.bitcamp.korea_tour.controller.restapi.homestay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayHouseDetailService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayHouseDetailController {
	private final HomeStayHouseDetailService s;
	
	//홈스테이 디테일 -  해당 집의 집이름, 주소1(출력)
	@GetMapping("/homestays/detail/name/{homeStayNum}")
	public HomeStayDto getHomeStayNameAndAddr(@PathVariable(value = "homeStayNum")int homeStayNum) {
		HomeStayDto dto = s.getHomeStayNameAndAddr(homeStayNum);
		return dto;
	}
	
	//해당집의 후기 수 (출력) / 평점들의 평균 계산
	@GetMapping("/homestays/detail/star/{homeStayNum}")
	public JsonMainStar countOfHouseAnswer(@PathVariable(value = "homeStayNum")int homeStayNum) {
		//후기수
		int countOfReview = s.countOfHouseAnswer(homeStayNum);
		
		//총 별점평균 구하기
		double a=s.avgOfCleanliness(homeStayNum);
		double b=s.avgOfCommunication(homeStayNum);
		double c=s.avgOfCheckIn(homeStayNum);
		double d=s.avgOfAccuracy(homeStayNum);
		double e=s.avgOfLocation(homeStayNum);
		double f=s.avgOfSatisfactionForPrice(homeStayNum);
		
		double allOfAvg=(a+b+c+d+e+f)/6;
		
		return new JsonMainStar(countOfReview,allOfAvg);
	}
	
	//각각의 평점 모아보기
	//cleanliness/communication/checkIn/accuracy/location/satisfactionForPrice
	@GetMapping("/homestays/detail/staravg/{homeStayNum}")
	public JsonStarList AvgOfReviewStars(@PathVariable(value = "homeStayNum")int homeStayNum) {
		
		double cleanliness=s.avgOfCleanliness(homeStayNum);
		double communication=s.avgOfCommunication(homeStayNum);
		double checkIn=s.avgOfCheckIn(homeStayNum);
		double accuracy=s.avgOfAccuracy(homeStayNum);
		double location=s.avgOfLocation(homeStayNum);
		double satisfactionForPrice=s.avgOfSatisfactionForPrice(homeStayNum);
		
		return new JsonStarList(cleanliness,communication,checkIn,accuracy,location,satisfactionForPrice);
	}
	
	//호스트 집 사진 (출력)
	@GetMapping("/homestays/detail/photos/{homeStayNum}")
	public HomeStayPhotoDto getHomeStayPhoto(@PathVariable(value = "homeStayNum")int homeStayNum) {
		HomeStayPhotoDto dto = s.getHomeStayPhoto(homeStayNum);
		return dto;
	}
	
	//소개글(출력)
	@GetMapping("/homestays/detail/content/{homeStayNum}")
	public String getHomeStayContent(@PathVariable(value = "homeStayNum")int homeStayNum) {
		String content = s.getHomeStayContent(homeStayNum);
		
		return content;
	}
	
	
	//편의시설(8개)및 ,애견동반, 흡연 (출력)
	@GetMapping("/homestays/detail/facility/{homeStayNum}")
	public HomeStayDetailDto getHomeStayFacility(@PathVariable(value = "homeStayNum")int homeStayNum) {
		HomeStayDetailDto dto = s.getHomeStayFacility(homeStayNum);
		return dto;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////	
	@Data
	@AllArgsConstructor
	static class JsonMainStar{
		//후기들의 개수
		private int countOfReview;
		//평점들의 평균
		private double allOfAvg;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonStarList{
		//평점들
		private double cleanliness;
		private double communication;
		private double checkIn;
		private double accuracy;
		private double location;
		private double satisfactionForPrice;
	}
}
