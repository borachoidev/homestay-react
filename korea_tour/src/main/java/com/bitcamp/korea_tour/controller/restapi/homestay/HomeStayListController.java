package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.homestay.HomeStayListDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayListService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayListController {
	private final HomeStayListService homeStayListService;
	private final PagingService pagingService;
	
	List<HomeStayListDto> list=new ArrayList<HomeStayListDto>();
	int totalPage=0;
	int start=0;
	int perPage=0;
	int totalCount=0;
	
	@GetMapping("/homestays/{currentPage}")
	public JsonData<List<HomeStayListDto>> getHomeStayList(
			@PathVariable(value="currentPage") int currentPage
			) {
		
		totalCount=homeStayListService.getTotalHomeStayList();
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		list=homeStayListService.getAllHomeStayList(start, perPage);
		
		for(HomeStayListDto dto:list) {
			int homeStayNum=dto.getHomeStayNum();
			dto.setHomeStayPhotos(homeStayListService.setAllHomeStayPhoto(homeStayNum));
		}
		
		return new JsonData<List<HomeStayListDto>>(list, currentPage);
	}
	
	
	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T list;
		private int totalPage;
	}
	

}
