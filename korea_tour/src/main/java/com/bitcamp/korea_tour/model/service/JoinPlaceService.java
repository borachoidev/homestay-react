package com.bitcamp.korea_tour.model.service;

import java.util.List;
import java.util.Map;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CoursePlaceDto;
import com.bitcamp.korea_tour.model.JoinPlaceListDto;
import com.bitcamp.korea_tour.model.PlaceApiPhotoDto;
import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.PlacePhotoDto;
import com.bitcamp.korea_tour.model.TourAnswerDto;

public interface JoinPlaceService {
	int getTotalPlaceMark(int userNum);
	List<PlaceDto> getFourDatasByRandom();
	int getTotalCount();
	int getTotalCountInArea(int areaCode);
	List<PlaceDto> searchPlaceByTitle(Map<String, Object> map);
	List<JoinPlaceListDto> searchPlaceByLike(Map<String, Object> map);
	PlaceDto getPlaceDetail(int contentId);
	List<PlaceApiPhotoDto> getPlaceDetailApiPhotos(int contentId);
	List<PlacePhotoDto> getPlaceDetailPhotos(int contentId);
	List<TourAnswerDto> getAnswerOfPlace(int contentId);
	List<CourseDto> getCourseByUser(int userNum);
	void insertPlaceIntoCourse(CoursePlaceDto dto);
	int getMaxOrderNum(int coursePlaceNum);
	List<JoinPlaceListDto> keywordSearchPlaceByTitle(Map<String, Object> map);
	List<JoinPlaceListDto> keywordSearchPlaceBylike(Map<String, Object> map);
}
