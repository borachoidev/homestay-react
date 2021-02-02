package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReservationDto;
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
	static class JsonReservationAllDataList {
		private List<JoinHomeStayReservationDto> reservations;
		private int totalCount;
	}
	
	@GetMapping("/homeStays/mypage/reservations/all/{currentPage}")
	public JsonReservationAllDataList getAllReservationDataList(
			@PathVariable(name="currentPage") int currentPage,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
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
		
		
		return new JsonReservationAllDataList(list, totalCount);
	}
	
}
