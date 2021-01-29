package com.bitcamp.korea_tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.NoticeDto;
import com.bitcamp.korea_tour.model.service.AdminService;
import com.bitcamp.korea_tour.model.service.NoticeService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminRedirectController implements SessionNames {
	private final NoticeService ns;
	private final AdminService adminService;

	/**
	 * 관리자 로그인 db체크
	 * @param id
	 * @param password
	 * @param request
	 * @return 로그인성공시 관리자메인/ 실패시 관리자로그인페이지
	 */
	@PostMapping("/login/admin/check")
	public String checkAdmin(
			@Param(value="id") String id,
			@Param(value="password") String password,
			HttpServletRequest request
			) {

		System.out.println(adminService.checkAdmin(id, password));

		if(adminService.checkAdmin(id, password)==1) {
			AdminDto admin=adminService.getAdminData(id, password);
			HttpSession session=request.getSession();
			session.setAttribute(ADMIN, admin);

			return "admin/adminmain";
		}else  {
			return "login/adminloginform";
		}
	}
	
	
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

