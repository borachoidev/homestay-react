package com.bitcamp.korea_tour.model.homestay;

import java.security.Timestamp;
import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joinreservation")
public class JoinHomeStayReservationDto {
	private int homeStayReservationNum; // 예약 고유값
	private Date writeday; // 예약날짜
	private String homeTitle; // 홈스테이 이름
	private Date checkInDay;	// 예약자 체크인날짜
	private Date checkOutDay;	// 예약자 체크아웃날짜
	private int approval;	// 승인여부
	private int deleted;	// 유저 삭제 여부
}
