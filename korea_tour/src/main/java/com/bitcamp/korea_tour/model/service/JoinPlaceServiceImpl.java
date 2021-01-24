package com.bitcamp.korea_tour.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CoursePlaceDto;
import com.bitcamp.korea_tour.model.JoinPlaceListDto;
import com.bitcamp.korea_tour.model.PlaceApiPhotoDto;
import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.PlacePhotoDto;
import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.mapper.JoinPlaceMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinPlaceServiceImpl implements JoinPlaceService{
	
	private final JoinPlaceMapper mapper;
	
	@Override
	public int getTotalPlaceMark(int userNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalPlaceMark(userNum);
	}

	@Override
	public List<PlaceDto> getFourDatasByRandom() {
		// TODO Auto-generated method stub
		return mapper.getFourDatasByRandom();
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.getTotalCount();
	}

	@Override
	public int getTotalCountInArea(int areaCode) {
		// TODO Auto-generated method stub
		return mapper.getTotalCountInArea(areaCode);
	}

	@Override
	public List<PlaceDto> searchPlaceByTitle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.searchPlaceByTitle(map);
	}

	@Override
	public List<JoinPlaceListDto> searchPlaceByLike(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.searchPlaceByLike(map);
	}

	@Override
	public PlaceDto getPlaceDetail(int contentId) {
		// TODO Auto-generated method stub
		return mapper.getPlaceDetail(contentId);
	}

	@Override
	public List<PlaceApiPhotoDto> getPlaceDetailApiPhotos(int contentId) {
		// TODO Auto-generated method stub
		return mapper.getPlaceDetailApiPhotos(contentId);
	}

	@Override
	public List<PlacePhotoDto> getPlaceDetailPhotos(int contentId) {
		// TODO Auto-generated method stub
		return mapper.getPlaceDetailPhotos(contentId);
	}

	@Override
	public List<TourAnswerDto> getAnswerOfPlace(int contentId) {
		// TODO Auto-generated method stub
		return mapper.getAnswerOfPlace(contentId);
	}

	@Override
	public List<CourseDto> getCourseByUser(int userNum) {
		// TODO Auto-generated method stub
		return mapper.getCourseByUser(userNum);
	}

	@Override
	public void insertPlaceIntoCourse(CoursePlaceDto dto) {
		// TODO Auto-generated method stub
		mapper.insertPlaceIntoCourse(dto);
	}

	@Override
	public int getMaxOrderNum(int coursePlaceNum) {
		// TODO Auto-generated method stub
		return mapper.getMaxOrderNum(coursePlaceNum);
	}

	@Override
	public List<JoinPlaceListDto> keywordSearchPlaceByTitle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.keywordSearchPlaceByTitle(map);
	}

	@Override
	public List<JoinPlaceListDto> keywordSearchPlaceBylike(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.keywordSearchPlaceBylike(map);
	}

}
