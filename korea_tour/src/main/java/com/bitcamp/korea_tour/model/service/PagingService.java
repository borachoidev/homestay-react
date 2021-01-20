package com.bitcamp.korea_tour.model.service;

import org.springframework.ui.Model;

public interface PagingService {
	void dealPaging(String page, Model model);
}
