package com.bitcamp.korea_tour.controller.restapi.homestay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStayDetailDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayHostService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayApplyController implements SessionNames{
	private final HomeStayHostService hsas;
	
	/*
	 * @PostMapping("/homestay/house") public void insertApply(@RequestBody
	 * HomeStayDto dto,@RequestBody HomeStayDetailDto ddto ) {
	 * hsas.insertHomeStay(dto); int homeStayNum = hsas.getHomeStayNum();
	 * 
	 * hsas.insertHomeStayDetail(homeStayNum, ddto);
	 * 
	 * }
	 */
	@PostMapping("/homestays/house")
	public void insertApply(@RequestBody JoinHomeStayDetailDto dto,
			@RequestParam int userNum,
			HttpServletRequest request
				) {
//		HttpSession session=request.getSession();
//		UserDto user=(UserDto) session.getAttribute(USER);
	
		
	
		dto.setUserNum(userNum);

		hsas.insertHomeStay(dto);
		System.out.println(userNum);
		System.out.println(dto);
		int homeStayNum = hsas.getHomeStayNum2(userNum);
		hsas.insertHomeStayDetail(homeStayNum,userNum, dto);
		System.out.println(dto);
	}
}
