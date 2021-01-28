package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminRedirectController {
	
	@GetMapping("/admin")
	public String goAdminmain() {
		
		return "admin/adminmain";
	}
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
	
	@GetMapping("/admin/member/list")
	public String goAdminMemberList() {
		
		return "admin/memberlist";
	}
	
	@GetMapping("/admin/member/delete")
	public String goAdminMemberDelete(@RequestParam int userNum,Model model) {
		model.addAttribute("userNum", userNum);
		return "admin/memberlist";
	}
	
	@GetMapping("/admin/comment/list")
	public String goAdminCommentList() {
		
		return "admin/commentlist";
	}
	
	@GetMapping("/admin/comment/delete")
	public String goAdminCommentDelete(@RequestParam int tourAnswerNum,Model model) {
		model.addAttribute("tourAnswerNum", tourAnswerNum);
		return "admin/commentlist";
	}
	
	@GetMapping("/noticelist")
	public String goNoticeList() {
		
		return "admin/noticelist";		
	}
	
	@GetMapping("/admin/notice/list")
	public String goAdminNoticeList() {
		
		return "admin/noticelist";
	}
	
	@GetMapping("/admin/notice/form")
	public String goAdminNoticeForm() {
		
		return "admin/noticeaddform";
	}
	
	@GetMapping("admin/notice/insert")
	public String goAdminNoticeInsert() {
		
		return "admin/noticelist";
	}
	
	@GetMapping("admin/notice/detail")
	public String goAdminNoticeDetail(@RequestParam int noticeNum,Model model) {
		model.addAttribute("noticeNum", noticeNum);
		return "admin/noticedetail";
	}
	
	@GetMapping("admin/notice/updateform")
	public String goAdminNoticeUpdateForm() {
		
		return "admin/noticeupdateform";
	}
	
	@GetMapping("admin/notice/update")
	public String goAdminNoticeUpdate() {
		
		return "admin/noticelist";
	}
	
	@GetMapping("admin/notice/delete")
	public String goAdminNoticeDelete(@RequestParam int noticeNum,Model model) {
		model.addAttribute("noticeNum", noticeNum);
		return "admin/noticelist";
	}
	
	@GetMapping("admin/placephoto/list")
	public String goAdminDisapprovedPhotoList() {
		
		return "admin/placephotolist";
	}
}

