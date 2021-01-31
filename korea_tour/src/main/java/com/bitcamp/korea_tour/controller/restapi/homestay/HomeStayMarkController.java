package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.homestay.JoinHomeStayMark;
import com.bitcamp.korea_tour.model.service.HomeStayMarkService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayMarkController {

//	private final HomeStayMarkService service;
//	private final PagingService pagingService;
//	
//	@Data
//	@AllArgsConstructor
//	public class JsonHomeStayMarkJoin {
//		private List<JoinHomeStayMark> marks;
//		private int totalCount;
//		private int totalPage;
//	}
//	
//	@GetMapping("/homestay/mark/{userNum}/{currentPage}")
//	public JsonHomeStayMarkJoin getMarkList(
//			@PathVariable(name="userNum") int userNum,
//			@PathVariable(name="currentPage") int currentPage
//			) {
//		
//		int totalCount = service.getTotalCount(userNum);
//		System.out.println(totalCount);
//		int totalPage = pagingService.getPagingData(totalCount, currentPage).get("totalPage");
//		System.out.println(totalPage);
//		List<JoinHomeStayMark> marks = service.getMarkList(userNum);
//		System.out.println(marks);
//		
//		return new JsonHomeStayMarkJoin(marks, totalCount, totalPage);
//	}
	
}
