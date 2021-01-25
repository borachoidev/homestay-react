package com.bitcamp.korea_tour.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CoursePlaceDto;
import com.bitcamp.korea_tour.model.JoinPlaceListDto;
import com.bitcamp.korea_tour.model.PlaceApiPhotoDto;
import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.PlacePhotoDto;
import com.bitcamp.korea_tour.model.TourAnswerDto;

@Mapper
public interface JoinPlaceMapper {
	int getTotalPlaceMark(int userNum);
	List<PlaceDto> getFourDatasByRandom();
	int getTotalCount();
	int getTotalCountInArea(int areaCode);
	List<JoinPlaceListDto> searchPlaceByTitle(Map<String, Object> map);
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
