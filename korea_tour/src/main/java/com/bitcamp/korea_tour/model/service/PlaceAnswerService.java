package com.bitcamp.korea_tour.model.service;

import java.util.HashMap;
import java.util.List;

import com.bitcamp.korea_tour.model.PlaceAnswerDto;

public interface PlaceAnswerService {
		void insertPlaceAnswer(PlaceAnswerDto dto); 
		void insertPlaceAnswerRE(PlaceAnswerDto dto); 
		void deletePlaceAnswerByUser(int placeAnswerNum);
		void deletePlaceAnswerByAdmin(int placeAnswerNum); 
		List<PlaceAnswerDto> getAnswerOfPlace(int contentId); 
		List<PlaceAnswerDto> getUserAnswer(HashMap<Integer, Integer> ua);
		List<PlaceAnswerDto> getAdminAnswer(int relevel); 
		
}
