package com.bitcamp.korea_tour.controller.restapi.homestay;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.service.homestay.HomeStayHostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayHostController {
	private final HomeStayHostService hsas;
	
	@PutMapping("/homestay/house/{homeStayNum}")
	public void updateHouse(@PathVariable(value = "homeStayNum") int homeStayNum) {
		hsas.updateHomeStay(homeStayNum);
		hsas.updateHomeStayDetail(homeStayNum);
	}
}
