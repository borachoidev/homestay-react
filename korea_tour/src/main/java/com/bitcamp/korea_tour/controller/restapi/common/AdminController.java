package com.bitcamp.korea_tour.controller.restapi.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.bitcamp.korea_tour.model.NoticeDto;
import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.service.NoticeService;
import com.bitcamp.korea_tour.model.service.TourAnswerService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AdminController {
	private final TourAnswerService tas;
	private final PagingService pagingService;
	private final NoticeService ns;
	
	int totalCount=0;
	int start=0;
	int perPage=0;
	int totalPage=0;
	/**
	 * 관리자용 댓글조회
	 * @param currentPage
	 * @param request
	 * @return
	 */
	@GetMapping("/admin/answer/{currentPage}")
	public JsonAnswer<List<TourAnswerDto>> getAdminAnswer(@PathVariable(value="currentPage") int currentPage, HttpServletRequest request) {
		totalCount = tas.getTotalCountAnswerAdmin();
		System.out.println(totalCount);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		totalPage=pagingService.getPagingData(totalCount, currentPage).get("totalPage");

		List<TourAnswerDto> answer = tas.getAdminAnswer(start, perPage);
		return new JsonAnswer<List<TourAnswerDto>>(answer, totalPage);

	}
	/**
	 * 관리자용 답글 조회
	 * @param currentPage
	 * @param request
	 * @return
	 */
	@GetMapping("/admin/reanswer/{currentPage}")
	public JsonReAnswer<List<TourAnswerDto>> getAdminReAnswer(@PathVariable(value="currentPage") int currentPage, HttpServletRequest request) {
		totalCount = tas.getTotalCountReAnswerAdmin();
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		totalPage=pagingService.getPagingData(totalCount, currentPage).get("totalPage");
		
		List<TourAnswerDto> reAnswer = tas.getAdminReAnswer(start, perPage);
		return new JsonReAnswer<List<TourAnswerDto>>(reAnswer, totalPage);
		
	}
	/**
	 * 관리자용 댓글,답글 삭제
	 * @param tourAnswerNum
	 */
	@DeleteMapping(value = "/admin/answer/{tourAnswerNum}")
	public void deleteAnswer(@PathVariable int tourAnswerNum) {
		tas.deleteCourseAnswerByAdmin(tourAnswerNum);
		tas.deletePlaceAnswerByAdmin(tourAnswerNum);
	}

	@Data
	@AllArgsConstructor
	static class JsonAnswer<T>{

		private T answer;
		int totalPage;
	}

	@Data
	@AllArgsConstructor
	static class JsonReAnswer<T>{

		private T reAnswer;
		int totalPage;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T notices;
		int totalPage;
	}

	@Data
	@AllArgsConstructor
	static class JsonDataList {
		private NoticeDto noticeDto; //dto
	}

	@Data
	@AllArgsConstructor
	static class JsonDetail {
		private NoticeDto noticeDetail;
	}

	@Data
	@AllArgsConstructor
	static class JsonRequest {
		private String title;
		private String content;
		private int views;
	}
	
	

	

}
