package com.bitcamp.korea_tour.controller.restapi.homestay;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.homestay.HomeStayDetailDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayHostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayApplyController {
	private final HomeStayHostService hsas;
	
	@PostMapping("/homestay/house")
	public void insertApply(@RequestBody HomeStayDto dto,@RequestBody HomeStayDetailDto ddto ) {
		hsas.insertHomeStay(dto);
		hsas.insertHomeStayDetail(ddto);
		
	}
}
