package com.bitcamp.korea_tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.service.TourAnswerService;

@Controller
public class TourAnswerRedirectController {
	@Autowired
	private TourAnswerService ts;
	
	@PostMapping("/placeanswer")
	public void insertPlaceAnswer(@ModelAttribute TourAnswerDto dto) {
		ts.insertPlaceAnswer(dto);
	}
}
