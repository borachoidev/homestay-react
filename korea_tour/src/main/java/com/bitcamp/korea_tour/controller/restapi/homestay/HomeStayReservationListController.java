package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.controller.NoticeController;
import com.bitcamp.korea_tour.controller.restapi.homestay.HomeStayListController.JsonData;
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
	
	int totalCount=0;
	int start=0;
	int perPage=0;
	int totalPage=0;
	
	@GetMapping("/homestay/reservation/{homestayNum}/{currentPage}")
	public JsonData<List<HomeStayReservationDto>> getReservationList(
			@PathVariable(value="currentPage") int currentPage,
			@PathVariable(value="homestayNum") int homestayNum){
		
		totalCount=hhs.getTotalCount(homestayNum);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
	    totalPage=pagingService.getPagingData(totalCount, currentPage).get("totalPage");
		
		
		List<HomeStayReservationDto> list = hhs.getAllReservation(homestayNum,start, perPage);
		
		
		return new JsonData<List<HomeStayReservationDto>>(list, totalPage);
		
	
   }
   @Data
   @AllArgsConstructor
   static class JsonData<T> {
      private T list;
      int totalPage;
   }
	
}
