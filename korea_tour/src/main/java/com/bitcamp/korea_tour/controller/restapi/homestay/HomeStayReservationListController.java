package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.homestay.HomeStayReservationDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayHostService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayReservationListController {
	private final HomeStayHostService hhs;
	private final PagingService pagingService;

	int totalCount = 0;
	int start = 0;
	int perPage = 0;
	int totalPage = 0;

	
	  @GetMapping("/homestay/reservation/{homestayNum}/{approval}/{currentPage}") public
	  JsonData<List<HomeStayReservationDto>> getReservationList(
	  
	  @PathVariable(value="currentPage") int currentPage,
	  @PathVariable(value="approval") int approval,
	  @PathVariable(value="homestayNum") int homestayNum){
	  
	  totalCount=hhs.getTotalCount(homestayNum);
	  start=pagingService.getPagingData(totalCount, currentPage).get("start");
	  perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
	  totalPage=pagingService.getPagingData(totalCount,
	  currentPage).get("totalPage");
	  
	  
	  List<HomeStayReservationDto> list = hhs.getAllReservation(homestayNum, approval, start,
	  perPage);
	  
	  
	  return new JsonData<List<HomeStayReservationDto>>(list, totalPage);
	  
	  
	  }
	 

	/**
	 * 예약 승인 리스트
	 * 
	 * @param currentPage
	 * @param homeStayNum
	 * @return
	 */
	/*
	 * @GetMapping("/homestay/reservation/{homeStayNum}/{currentPage}") public
	 * JsonAlist<List<HomeStayReservationDto>> getApprovalList(
	 * 
	 * @PathVariable(value="currentPage") int currentPage,
	 * 
	 * @PathVariable(value="homeStayNum") int homeStayNum) {
	 * 
	 * totalCount=hhs.getApprovalCount(homeStayNum);
	 * start=pagingService.getPagingData(totalCount, currentPage).get("start");
	 * perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
	 * totalPage=pagingService.getPagingData(totalCount,
	 * currentPage).get("totalPage");
	 * 
	 * List<HomeStayReservationDto> list =
	 * hhs.getApprovalReservation(homeStayNum,start, perPage);
	 * 
	 * return new JsonAlist<List<HomeStayReservationDto>>(list, totalPage); }
	 *//**
		 * 예약 거절 리스트
		 * 
		 * @param currentPage
		 * @param homeStayNum
		 * @return
		 */

	/*
	 * @GetMapping("") public JsonRlist<List<HomeStayReservationDto>>
	 * getRefusedList(
	 * 
	 * @PathVariable(value="currentPage") int currentPage,
	 * 
	 * @PathVariable(value="homeStayNum") int homeStayNum){
	 * 
	 * totalCount=hhs.getApprovalCount(homeStayNum);
	 * start=pagingService.getPagingData(totalCount, currentPage).get("start");
	 * perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
	 * totalPage=pagingService.getPagingData(totalCount,
	 * currentPage).get("totalPage");
	 * 
	 * List<HomeStayReservationDto> list =
	 * hhs.getRefusedReservation(homeStayNum,start, perPage);
	 * 
	 * 
	 * return new JsonRlist<List<HomeStayReservationDto>>(list, totalPage); }
	 *//**
		 * 예약 대기중 리스트
		 * 
		 * @param currentPage
		 * @param homeStayNum
		 * @return
		 *//*
			 * @GetMapping("") public JsonPlist<List<HomeStayReservationDto>>
			 * getPendingList(
			 * 
			 * @PathVariable(value="currentPage") int currentPage,
			 * 
			 * @PathVariable(value="homeStayNum") int homeStayNum){
			 * 
			 * totalCount=hhs.getApprovalCount(homeStayNum);
			 * start=pagingService.getPagingData(totalCount, currentPage).get("start");
			 * perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
			 * totalPage=pagingService.getPagingData(totalCount,
			 * currentPage).get("totalPage");
			 * 
			 * List<HomeStayReservationDto> list =
			 * hhs.getPendingReservation(homeStayNum,start, perPage);
			 * 
			 * 
			 * return new JsonPlist<List<HomeStayReservationDto>>(list, totalPage);
			 * 
			 * }
			 */

	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T list;
		int totalPage;
	}

	@Data
	@AllArgsConstructor
	static class JsonAlist<T> {
		private T alist;
		int totalPage;
	}

	@Data
	@AllArgsConstructor
	static class JsonRlist<T> {
		private T rlist;
		int totalPage;
	}

	@Data
	@AllArgsConstructor
	static class JsonPlist<T> {
		private T plist;
		int totalPage;
	}

}
