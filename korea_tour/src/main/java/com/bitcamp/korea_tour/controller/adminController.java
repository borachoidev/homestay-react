package com.bitcamp.korea_tour.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.controller.MypageController.JsonAnswer;
import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.TourAnswerService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class adminController implements SessionNames{
	
	private final TourAnswerService tas;
	
	private final PagingService pagingService;
	
	int totalCount=0;
	int start=0;
	int perPage=0;
	
	
	//관리자용 댓글 조회
	@GetMapping("/adminanswer/{currentPage}")
	public JsonAnswer<List<TourAnswerDto>> getAdminAnswer(@PathVariable(value="currentPage") int currentPage, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    AdminDto admin = (AdminDto)session.getAttribute(ADMIN);
	    int adminNum = admin.getAdminNum();
	    		
	    totalCount=tas.getTotalCountAnswerAdmin();
	    System.out.println(totalCount);
	    start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("start", start);
		map.put("perPage", perPage);
		
		List<TourAnswerDto> adminanswer= tas.getAdminAnswer(map); 
		
		return new JsonAnswer<List<TourAnswerDto>>(adminanswer);
	   
    }
	
	@Data
	@AllArgsConstructor
	static class JsonAnswer<T>{

		private T Myanswer;
	}
	
}
