package com.bitcamp.korea_tour.model.homestay;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joinreservationdetail")
public class JoinReservationDetail {
	private int homeStayReservationNum;
	private String customName;
	private String email1;
	private String email2;
	private Date writeday;
	private Date checkInDay;
	private Date checkOutDay;
	private int numberOfPeople;
	private int totalPrice;
	private int approval;
	private int deleted;
}
