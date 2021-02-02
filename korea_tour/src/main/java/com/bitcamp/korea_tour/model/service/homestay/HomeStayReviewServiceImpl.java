package com.bitcamp.korea_tour.model.service.homestay;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReviewDto;
import com.bitcamp.korea_tour.model.mapper.HomeStayReviewMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayReviewServiceImpl implements HomeStayReviewService{
   private final HomeStayReviewMapper m;

   @Override
   public List<JoinHomeStayReviewDto> getAllReview(int homeStayNum) {
      // TODO Auto-generated method stub
      return m.getAllReview(homeStayNum);
   }
   
}