package com.bitcamp.korea_tour.model.service.homestay;

import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;

public interface HomeStayHostPhotoService {
	void insertPhoto(HomeStayPhotoDto dto);
	void deletePhoto(int homeStayPhotoNum);
	void updatePhoto(int homeStayPhotoNum);
}

