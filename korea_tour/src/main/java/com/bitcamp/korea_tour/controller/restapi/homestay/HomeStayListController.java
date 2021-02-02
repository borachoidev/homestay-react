package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayListDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayListService;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayListController implements SessionNames {
	private final HomeStayListService homeStayListService;
	private final HomeStayService homeStayService;
	private final PagingService pagingService;
	
	List<HomeStayListDto> list=new ArrayList<HomeStayListDto>();
	int start=0;
	int perPage=6;
	int totalPage=0;
	int totalCount=0;
	
	String photoName=null;
	int isMarked=0;
	Double avgOfStar=0.0;
	int countOfReview=0;
	
	@GetMapping("/homestays/{currentPage}")
	public JsonList<List<HomeStayListDto>> getHomeStayList(
			@PathVariable(value="currentPage") int currentPage,
			HttpServletRequest request
			) {
		
		HttpSession session=request.getSession();
		UserDto user=(UserDto) session.getAttribute(USER);
		
		totalCount=homeStayListService.getTotalHomeStayList();
		start=pagingService.getPagingStart(currentPage, perPage);
		list=homeStayListService.getAllHomeStayList(start, perPage);
		
		for(HomeStayListDto dto:list) {
			int homeStayNum=dto.getHomeStayNum();
			
			photoName=homeStayListService.getHomeStayPhotoOfList(homeStayNum);
			if(user!=null) isMarked=homeStayListService.isMarked(homeStayNum, user.getUserNum());
			countOfReview=homeStayService.countOfHouseAnswer(homeStayNum);
			if(countOfReview!=0) avgOfStar=homeStayListService.getAvgOfStar(homeStayNum);
			
			dto.setPhotoName(photoName);
			dto.setIsMarked(isMarked);
			dto.setCountOfReview(countOfReview);
			dto.setAvgOfStar(avgOfStar);
			
		}
		
		return new JsonList<List<HomeStayListDto>>(list);
	}
	
	
	
	@GetMapping("/homestays/paging/homestay-list")
	public int getTotalPage() {
		totalCount=homeStayListService.getTotalHomeStayList();
		return pagingService.getPagingTotalPage(totalCount, perPage);
	}
	
	
	@Data
	@AllArgsConstructor
	static class JsonList<T> {
		private T list;
	}
	

}
