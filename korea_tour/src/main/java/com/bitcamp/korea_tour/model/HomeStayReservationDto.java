package com.bitcamp.korea_tour.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class HomeStayReservationDto {
	private String reservationNum;
	private String checkInDay;
	private String checkOutDay;
	private String numberOfPeople;
	private String approveByHost;
	private Timestamp writeday;
	private String userNum;
	private String homeNum;
}
