package com.bitcamp.korea_tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.service.TourAnswerService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TourAnswerController implements SessionNames{
   private final TourAnswerService tas;
   private final PagingService pagingService;

	int totalCount=0;
	int start=0;
	int perPage=0;
	int totalPage=0;

	//관리자용 댓글 조회
	@GetMapping("/adminanswer/{currentPage}")
	public JsonAnswer<List<TourAnswerDto>> getAdminAnswer(@PathVariable(value="currentPage") int currentPage, HttpServletRequest request) {
		/*
		 * HttpSession session = request.getSession(); AdminDto admin =
		 * (AdminDto)session.getAttribute(ADMIN); int adminNum = admin.getAdminNum();
		 */
		totalCount=tas.getTotalCountAnswerAdmin();
		System.out.println(totalCount);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		totalPage=pagingService.getPagingData(totalPage, currentPage).get("totalPage");


		List<TourAnswerDto> adminanswer= tas.getAdminAnswer(start, perPage); 

		return new JsonAnswer<List<TourAnswerDto>>(adminanswer, totalPage);

	}

	//관리자용 답글 조회
	@GetMapping("/adminreanswer/{currentPage}")
	public JsonAnswer<List<TourAnswerDto>> getAdminReAnswer(@PathVariable(value="currentPage") int currentPage, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AdminDto admin = (AdminDto)session.getAttribute(ADMIN);
		int adminNum = admin.getAdminNum();

		totalCount=tas.getTotalCountReAnswerAdmin();
		System.out.println(totalCount);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		totalPage=pagingService.getPagingData(totalPage, currentPage).get("totalPage");

		List<TourAnswerDto> adminreanswer= tas.getAdminReAnswer(start, perPage); 

		return new JsonAnswer<List<TourAnswerDto>>(adminreanswer, totalPage);

	}
	
	// 댓글,답글 삭제
	@PostMapping(value = "/adminanswer/{tourAnswerNum}")
	public void deleteAnswer(@PathVariable int tourAnswerNum) {
		tas.deleteCourseAnswerByAdmin(tourAnswerNum);
		tas.deletePlaceAnswerByAdmin(tourAnswerNum);
	}
	
	@Data
	@AllArgsConstructor
	static class JsonAnswer<T>{

		private T Myanswer;
		int totalPage;
	}

   @PostMapping(value = "/courseanswer")
   public void insertCourseAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertCourseAnswer(dto);
   }
   @PostMapping(value = "/coursereanswer")
   public void insertCourseReAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertCourseAnswer(dto);
   }
   
   @PostMapping(value = "/placeanswer")
   public void insertPlaceAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertPlaceAnswer(dto);
   }
   
   @PostMapping(value = "/placereanswer")
   public void insertPlaceReAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertPlaceAnswer(dto);
   }
   

   
}