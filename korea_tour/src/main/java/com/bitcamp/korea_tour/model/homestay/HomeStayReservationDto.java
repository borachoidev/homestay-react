package com.bitcamp.korea_tour.model.homestay;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestayreservation")
public class HomeStayReservationDto {
	private int homeStayReservationNum;
	private int userNum;
	private int homeStayNum;
	private String checkInDay;
	private String checkOutDay;
	private int numberOfPeople;
	private int totalPrice;
	private int approval;
	private Timestamp writeday;
	private String name;
	private String email1;
	private String email2;
	private int gender;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private int deleted;
}
