package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayReviewDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReviewDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayReviewService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayReviewController implements SessionNames{
	private final HomeStayReviewService s;

	//해당 집의 댓글 모두 출력
	@GetMapping("/homestays/{homeStayNum}/allreview")
	public JsonAllReviews<List<JoinHomeStayReviewDto>>getAllReview(@PathVariable(value = "homeStayNum")int homeStayNum){
		List<JoinHomeStayReviewDto> reviews = s.getAllReview(homeStayNum);
		return new JsonAllReviews<List<JoinHomeStayReviewDto>>(reviews);
	}

	//해당 집에 댓글 입력하기
	@PostMapping("/homestays/{homeStayNum}/insertreview")
	public void insertReview(@PathVariable(value="homeStayNum") int homeStayNum,
		HttpServletRequest request, @ModelAttribute HomeStayReviewDto dto) {
		HttpSession session=request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		
		 int loginNum = user.getUserNum(); 
		 String loginId = user.getName(); 
		 String loginPhoto = user.getPhoto();
		 
		
		//regroup max 값
		int max = s.maxOfRegroup();
		//userNum,homeStayNum,relevel,regroup,loginNum,loginId,loginPhoto,content,writeday,deleted
		
		dto.setHomeStayNum(homeStayNum);
		dto.setRegroup(max+1);
		dto.setLoginNum(loginNum);
		dto.setLoginId(loginId);
		dto.setLoginPhoto(loginPhoto);
		
		System.out.println(dto);
		
		s.insertReview(dto);
	}
	
	//해당 집에 답글 입력하기
	@PostMapping("/homestays/{homeStayNum}/insertanswerofreview")
	public void insertAnswerReview(@PathVariable(value="homeStayNum") int homeStayNum,
			HttpServletRequest request, @ModelAttribute HomeStayReviewDto dto) {
		HttpSession session=request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		int loginNum = user.getUserNum();
		String loginId = user.getName();
		String loginPhoto = user.getPhoto();
		
		dto.setHomeStayNum(homeStayNum);
		dto.setLoginNum(loginNum);
		dto.setLoginId(loginId);
		dto.setLoginPhoto(loginPhoto);
		
		System.out.println(dto);
		
		s.insertAnswerReview(dto);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	@Data
	@AllArgsConstructor
	static class JsonAllReviews<T>{
		private T reviews;
	}

}