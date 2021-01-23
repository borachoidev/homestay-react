package com.bitcamp.korea_tour.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.mapper.TourAnswerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TourAnswerServiceImpl implements TourAnswerService{
	
	private final TourAnswerMapper mapper;
	@Override
	public void insertPlaceAnswer(TourAnswerDto dto) {
		// TODO Auto-generated method stub
		mapper.insertPlaceAnswer(dto);
	}

	@Override
	public void deletePlaceAnswerByUser(int tourAnswerNum) {
		// TODO Auto-generated method stub
		mapper.deletePlaceAnswerByUser(tourAnswerNum);
	}

	@Override
	public void deletePlaceAnswerByAdmin(int tourAnswerNum) {
		// TODO Auto-generated method stub
		mapper.deletePlaceAnswerByAdmin(tourAnswerNum);
	}

	@Override
	public List<TourAnswerDto> getAnswerOfPlace(int contentId) {
		// TODO Auto-generated method stub
		return mapper.getAnswerOfPlace(contentId);
	}

	@Override
	public List<TourAnswerDto> getUserAnswerPlace(int loginNum, int relevel) {
		// TODO Auto-generated method stub
		return mapper.getUserAnswerPlace(loginNum, relevel);
	}

	@Override
	public List<TourAnswerDto> getUserReAnswerPlace(int loginNum, int relevel) {
		// TODO Auto-generated method stub
		return mapper.getUserReAnswerPlace(loginNum, relevel);
	}

	@Override
	public void insertCourseAnswer(TourAnswerDto dto) {
		// TODO Auto-generated method stub
		mapper.insertCourseAnswer(dto);
	}

	@Override
	public void deleteCourseAnswerByUser(int tourAnswerNum) {
		// TODO Auto-generated method stub
		mapper.deleteCourseAnswerByUser(tourAnswerNum);
	}

	@Override
	public void deleteCourseAnswerByAdmin(int tourAnswerNum) {
		// TODO Auto-generated method stub
		mapper.deleteCourseAnswerByAdmin(tourAnswerNum);
	}

	@Override
	public List<TourAnswerDto> getAnswerOfCourse(int courseNum) {
		// TODO Auto-generated method stub
		return mapper.getAnswerOfCourse(courseNum);
	}

	@Override
	public List<TourAnswerDto> getUserAnswerCourse(int loginNum, int relevel) {
		// TODO Auto-generated method stub
		return mapper.getUserAnswerCourse(loginNum, relevel);
	}

	@Override
	public List<TourAnswerDto> getUserReAnswerCourse(int loginNum, int relevel) {
		// TODO Auto-generated method stub
		return mapper.getUserAnswerCourse(loginNum, relevel);
	}

	@Override
	public List<TourAnswerDto> getAdminAnswer() {
		// TODO Auto-generated method stub
		return mapper.getAdminAnswer();
	}

	@Override
	public List<TourAnswerDto> getAdminReAnswer() {
		// TODO Auto-generated method stub
		return mapper.getAdminReAnswer();
	}

}
