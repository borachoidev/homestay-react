package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReviewDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayReviewService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayReviewController {
   private final HomeStayReviewService s;
   
   //해당 집의 댓글 모두 출력
   @GetMapping("/homestays/{homeStayNum}/allreview")
   public JsonAllReviews<List<JoinHomeStayReviewDto>>getAllReview(@PathVariable(value = "homeStayNum")int homeStayNum){
      List<JoinHomeStayReviewDto> reviews = s.getAllReview(homeStayNum);
      return new JsonAllReviews<List<JoinHomeStayReviewDto>>(reviews);
   }
   
   
   //////////////////////////////////////////////////////////////////////////////////////////////
   @Data
   @AllArgsConstructor
   static class JsonAllReviews<T>{
      private T reviews;
   }
   
}