package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayReservationDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReservationDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStaySummary;
import com.bitcamp.korea_tour.model.homestay.JoinReservationDetail;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayReservationService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayMyPageController implements SessionNames{

	private final HomeStayReservationService reservationService;
	private final PagingService pagingService;
	int totalCount = 0;
	int start = 0;
	int perPage = 10;
	
	@Data
	@AllArgsConstructor
	static class JsonReservationDataList {
		private List<JoinHomeStayReservationDto> reservations;
		private int totalCount;
	}
	
	/*
	 * 예약확인 리스트 출력(전체)
	 */
	@GetMapping("/homeStays/mypage/reservations/all/{currentPage}")
	public JsonReservationDataList getAllReservationDataList(
			@PathVariable(name="currentPage") int currentPage,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
//		System.out.println(session.getAttribute(USER));
		UserDto user=(UserDto)session.getAttribute(USER);
		int loginNum = user.getUserNum();
		int totalCount = reservationService.getTotalCount(loginNum);
		int start = pagingService.getPagingData(totalCount, currentPage).get("start");
		int perPage = pagingService.getPagingData(totalCount, currentPage).get("perPage");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("loginNum", loginNum);
		map.put("start", start);
		map.put("perPage", perPage);
		List<JoinHomeStayReservationDto> list = reservationService.getAllDatas(map);
		
		return new JsonReservationDataList(list, totalCount);
	}
	
	/*
	 *  예약확인 리스트 출력(예약대기)
	 */
	@GetMapping("/homeStays/mypage/reservations/wating/{currentPage}")
	public JsonReservationDataList getWatingReservationDataList(
			@PathVariable(name="currentPage") int currentPage,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		int loginNum = user.getUserNum();
		int totalCount = reservationService.getCountByWating(loginNum);
		int start = pagingService.getPagingData(totalCount, currentPage).get("start");
		int perPage = pagingService.getPagingData(totalCount, currentPage).get("perPage");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("loginNum", loginNum);
		map.put("start", start);
		map.put("perPage", perPage);
		List<JoinHomeStayReservationDto> list = reservationService.getDatasByWating(map);
		return new JsonReservationDataList(list, currentPage);
	}
	
	// 예약확인 리스트 출력(예약취소)
	@GetMapping("/homeStays/mypage/reservations/cancel/{currentPage}")
	public JsonReservationDataList getCanCelReservationDataList(
			@PathVariable(name="currentPage") int currentPage,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		int loginNum = user.getUserNum();
		int totalCount = reservationService.getCountByCancel(loginNum);
		int start = pagingService.getPagingData(totalCount, currentPage).get("start");
		int perPage = pagingService.getPagingData(totalCount, currentPage).get("perPage");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("loginNum", loginNum);
		map.put("start", start);
		map.put("perPage", perPage);
		List<JoinHomeStayReservationDto> list = reservationService.getDatasByCancel(map);
		return new JsonReservationDataList(list, currentPage);
	}
	
	/*
	 *  예약확인 리스트 출력(예약승인)
	 */
	@GetMapping("/homeStays/mypage/reservations/approved/{currentPage}")
	public JsonReservationDataList getApprovedReservationDataList(
			@PathVariable(name="currentPage") int currentPage,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		int loginNum = user.getUserNum();
		int totalCount = reservationService.getCountByApproved(loginNum);
		int start = pagingService.getPagingData(totalCount, currentPage).get("start");
		int perPage = pagingService.getPagingData(totalCount, currentPage).get("perPage");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("loginNum", loginNum);
		map.put("start", start);
		map.put("perPage", perPage);
		List<JoinHomeStayReservationDto> list = reservationService.getDatasByApproved(map);
		return new JsonReservationDataList(list, currentPage);
	}
	
	/*
	 * 예약확인 상세 출력1
	 */
	@GetMapping("/homeStays/mypage/reservation/detail/homeStay/summary/{homeStayReservationNum}")
	public JoinHomeStaySummary getHomeStaySummary(
			@PathVariable(name="homeStayReservationNum") int homeStayReservationNum) {
		JoinHomeStaySummary jsonData = reservationService.getHomeStaySummary(homeStayReservationNum);
		return jsonData;
	}
	
	/*
	 * 예약확인 상세 출력2
	 */
	@GetMapping("/homeStays/mypage/reservation/detail/{homeStayReservationNum}")
	public JoinReservationDetail getReservationDetail(
			@PathVariable(name="homeStayReservationNum") int homeStayReservationNum) {
		JoinReservationDetail jsonData = reservationService.getHomeStayDetail(homeStayReservationNum);
		return jsonData;
	}
	
	/*
	 * 유저가 예약취소
	 */
	@PatchMapping("/homeStays/mypage/reservation/customer/cancel/{homeStayReservationNum}")
	public String cancelReservationByUser(
			@PathVariable(name="homeStayReservationNum") int homeStayReservationNum) {
		HomeStayReservationDto dto = reservationService.getData(homeStayReservationNum);
		if(dto.getApproval() == 1 || dto.getDeleted() == 1) {
			return "alreadycancel";
		}else if(dto.getApproval() == 0 && dto.getDeleted() == 0){
			reservationService.cancelReservationByUser(homeStayReservationNum);
			return "success";
		}else {
			return "fail";
		}
	}
}
