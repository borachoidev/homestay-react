package com.bitcamp.korea_tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.korea_tour.model.NoticeDto;
import com.bitcamp.korea_tour.model.service.NoticeService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

@Controller
public class AdminRedirectController {
	@Autowired
	private NoticeService ns;

	//관리자 메인페이지

	@GetMapping("/admin")
	public String goAdminmain() {

		return "admin/adminmain";
	}
	
	//관리자 회원관리

	@GetMapping("/admin/member/list")
	public String goAdminMemberList() {

		return "admin/memberlist";
	}

	@GetMapping("/admin/member/delete")
	public String goAdminMemberDelete(@RequestParam int userNum,Model model) {
		model.addAttribute("userNum", userNum);
		return "admin/memberlist";
	}

	//관리자 댓글관리
	//댓글로 이동
	@GetMapping("/admin/comment/list")
	public String goAdminCommentList(@RequestParam int currentPage,Model model) {
		model.addAttribute("currentPage", currentPage);
		return "admin/commentlist";
	}

	//답글로 이동
	@GetMapping("/admin/recomment/list")
	public String goAdminReCommentList(@RequestParam int currentPage,Model model) {
		model.addAttribute("currentPage", currentPage);
		return "admin/recommentlist";
	}
	
	@GetMapping("/admin/comment/delete")
	public String goAdminCommentDelete(@RequestParam int tourAnswerNum,Model model,@RequestParam int currentPage) {
		model.addAttribute("tourAnswerNum", tourAnswerNum);
		model.addAttribute("currentPage", currentPage);
		return "admin/commentlist";
	}
	
	//관리자 공지사항 관리
	@GetMapping("/noticelist")
	public String goNoticeList(@RequestParam int currentPage,Model model) {
		model.addAttribute("currentPage", currentPage);
		return "admin/noticelist";		
	}


	@GetMapping("/admin/notice/form")
	public String goAdminNoticeForm() {

		return "admin/noticeaddform";
	}


	@PostMapping("/noticeinsert")
	public String insertNotice(@ModelAttribute NoticeDto dto) {		
		ns.insertNotice(dto);

		return "redirect:noticelist?currentPage=1";
	}

	@GetMapping("/admin/notice/detail")
	public String goAdminNoticeDetail(@RequestParam int noticeNum,Model model) {
		model.addAttribute("noticeNum", noticeNum);
		return "admin/noticedetail";
	}

	@GetMapping("/admin/notice/updateform")
	public String goAdminNoticeUpdateForm() {

		return "admin/noticeupdateform";
	}

	@GetMapping("/admin/notice/update")
	public String goAdminNoticeUpdate(@RequestParam int noticeNum,@RequestParam int currentPage,Model model) {
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
	
	
	//Tour 사진관리
	@GetMapping("/admin/placephoto/list")
	public String goAdminDisapprovedPhotoList() {

		return "admin/placephotolist";
	}
	
	
	
	//////////////////홈스테이HOMESTAY/////////////////////////////
	
	@GetMapping("/admin/host/list")
	public String goAdminHostList() {

		return "admin/hostlist";
	}

	@GetMapping("/admin/host/detail")
	public String goAdminHostDetail( ) {

		return "admin/hostdetail";
	}

	@GetMapping("/admin/host/approval")
	public String goAdminHostApproval() {

		return "admin/hostlist";
	}

	@GetMapping("/admin/host/denial")
	public String goAdminHostDenial() {

		return "admin/hostlist";
	}
}

