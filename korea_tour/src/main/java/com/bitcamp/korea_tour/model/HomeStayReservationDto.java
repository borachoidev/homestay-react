package com.bitcamp.korea_tour.model;

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
	private int approval;
	private Timestamp writeday;
	private String addr1;
	private String addr2;
	private int gender;
	private String year;
	private String month;
	private String day;
}
