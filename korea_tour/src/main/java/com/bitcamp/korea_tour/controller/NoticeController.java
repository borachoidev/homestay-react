package com.bitcamp.korea_tour.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.controller.restapi.common.AdminController;
import com.bitcamp.korea_tour.model.NoticeDto;
import com.bitcamp.korea_tour.model.service.NoticeService;
import com.bitcamp.korea_tour.model.service.TourAnswerService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoticeController{
	private final NoticeService ns;
	private final PagingService pagingService;

	int totalCount=0;
	int start=0;
	int perPage=0;
	int totalPage=0;
	
	/**
	 * 공지사항 리스트
	 * @param currentPage
	 * @return 공지사항 리스트로 이동
	 */
	@GetMapping("/notice/{currentPage}")
	@ResponseBody
	public JsonData<List<NoticeDto>> getNoticeList(@PathVariable(name = "currentPage") int currentPage) {

		totalCount=ns.getTotalCount();
		/* System.out.println(totalCount); */
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		totalPage=pagingService.getPagingData(totalCount, currentPage).get("totalPage");

		System.out.println("공지사항 토탈페이지: "+totalPage);
		List<NoticeDto> list = ns.getAllDatas(start, perPage);

		return new JsonData<List<NoticeDto>>(list, totalPage);

	}
	/**
	 * 공지사항 디테일 페이지
	 * @param noticeNum
	 * @return 공지사항 디테일 페이지로 이동
	 */

	@GetMapping("/notice/detail/{noticeNum}")
	@ResponseBody
	public JsonDetail getNoticeDetail(@PathVariable(name="noticeNum") int noticeNum) {
		NoticeDto dto = ns.getData(noticeNum);

		return new JsonDetail(dto);
	}
	/**
	 * 공지사항 인서트
	 * @param dto
	 * @return
	 */
	@PostMapping("/noticeinsert")
	@ResponseBody
	public String insertNotice(@ModelAttribute NoticeDto dto) {		
		ns.insertNotice(dto);

		return "redirect:noticelist?currentPage=1";
	}
	/**
	 * 공지사항 수정
	 * @param dto
	 * @param noticeNum
	 */
	
	@ResponseBody
	@RequestMapping(value = "/noticeupdate/{noticeNum}", method = RequestMethod.POST)
	public void updateNotice(@RequestBody NoticeDto dto,@PathVariable int noticeNum) {
		ns.updateNotice(noticeNum, dto);
	}
	/**
	 * 공지사항 삭제
	 * @param noticeNum
	 */
	@ResponseBody
	@DeleteMapping(value = "/noticedelete/{noticeNum}")
	public void deleteNotice(@PathVariable(name="noticeNum") int noticeNum) {
		ns.deleteNotice(noticeNum); 
	}

	/**
	 * 공지사항 조회수 증가
	 * @param dto
	 * @param noticeNum
	 */
	@ResponseBody
	@PostMapping(value = "/noticeviews/{noticeNum}")
	public void updateViews(@PathVariable int noticeNum) {
		ns.countViews(noticeNum);
	}

/////////////////////////////////////////뷰매핑

	/**
	 * 공지사항 리스트
	 * @param currentPage
	 * @param model
	 * @return 공지사항 리스트
	 */
	@GetMapping("/noticelist")
	public String goNoticeList(@RequestParam int currentPage,Model model) {
		model.addAttribute("currentPage", currentPage);
		return "admin/noticelist";		
	}

	/**
	 * 공지사항 입력폼
	 * @return 
	 */
	@GetMapping("/admin/notice/form")
	public String goAdminNoticeForm() {

		return "admin/noticeaddform";
	}
	
	@GetMapping("/admin/notice/detail")
	public String goAdminNoticeDetail(@RequestParam int noticeNum,Model model) {
		model.addAttribute("noticeNum", noticeNum);
		return "admin/detail";
	}
	/**
	 * 공지사항 업데이트폼
	 * @return
	 */
	@PostMapping("/admin/notice/updateform")
	public String goAdminNoticeUpdateForm(@RequestParam int noticeNum,Model model ) {
		model.addAttribute("noticeNum", noticeNum);
		return "admin/noticeupdateform";
	}
	
	/**
	 * 공지사항 업데이트
	 * @param noticeNum
	 * @param currentPage
	 * @param model
	 * @param dto
	 * @return 공지사항 리스트
	 */
	@PostMapping("/admin/notice/update")
	public String goAdminNoticeUpdate(@RequestParam int noticeNum,@RequestParam int currentPage,Model model,@ModelAttribute NoticeDto dto) {
		ns.updateNotice(noticeNum, dto);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("noticeNum", noticeNum);
		return "admin/noticelist";
	} 


	@GetMapping("/admin/notice/delete")
	public String goAdminNoticeDelete(@RequestParam int noticeNum,@RequestParam int currentPage,Model model) {
		model.addAttribute("noticeNum", noticeNum);
		model.addAttribute("currentPage", currentPage);
		return "admin/noticelist";
	}
	
	
	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T notices;
		int totalPage;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonDetail {
		private NoticeDto noticeDetail;
	}
}