package com.bitcamp.korea_tour.model.homestay;

import java.security.Timestamp;
import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joinreservation")
public class JoinHomeStayReservationDto {
	private int homeStayReservationNum;
	private Date writeday;
	private String homeTitle;
	private Date checkInDay;
	private Date checkOutDay;
	private int approval;
	private int deleted;
}
