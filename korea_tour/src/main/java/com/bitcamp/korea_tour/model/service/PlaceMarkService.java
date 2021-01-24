package com.bitcamp.korea_tour.model.service;

import com.bitcamp.korea_tour.model.PlaceMarkDto;

public interface PlaceMarkService {
		void insertPlaceMark(PlaceMarkDto dto);
		void deletePlaceMark(int markNum);
		int getAllMyPlaceMarkCount(); 
}
