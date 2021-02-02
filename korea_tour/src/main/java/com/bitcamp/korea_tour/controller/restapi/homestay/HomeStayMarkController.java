package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayMarkService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/homestays")
public class HomeStayMarkController implements SessionNames {
	
	private final HomeStayMarkService homeStayMarkService;
	
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
	
	/**
	 * 즐겨찾기 추가
	 * @param homeStayNum
	 * @param request
	 * @return String
	 */
	@PostMapping("/mark")
	public String insertMark(
			@RequestParam(value="homeStayNum") int homeStayNum,
			HttpServletRequest request
			) {
		
		HttpSession session=request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		if(user!=null) homeStayMarkService.insertMark(homeStayNum, user.getUserNum());
		
		return "즐겨찾기 추가 성공";
	}
	
	/**
	 * 즐겨찾기 취소
	 * @param homeStayNum
	 * @param request
	 * @return String
	 */
	@DeleteMapping("/mark")
	public String deleteMark(
			@RequestParam(value="homeStayNum") int homeStayNum,
			HttpServletRequest request
			) {
		
		HttpSession session=request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		if(user!=null) homeStayMarkService.deleteMark(homeStayNum, user.getUserNum());
		
		return "즐겨찾기 취소 성공";
	}
	
}
