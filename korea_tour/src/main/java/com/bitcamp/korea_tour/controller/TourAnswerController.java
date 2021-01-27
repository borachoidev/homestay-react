package com.bitcamp.korea_tour.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.service.TourAnswerService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TourAnswerController implements SessionNames{
   private final TourAnswerService tas;
   
   @PostMapping(value = "/courseanswer")
   public void insertCourseAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertCourseAnswer(dto);
   }
   @PostMapping(value = "/coursereanswer")
   public void insertCourseReAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertCourseAnswer(dto);
   }
   
   @PostMapping(value = "/placeanswer")
   public void insertPlaceAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertPlaceAnswer(dto);
   }
   
   @PostMapping(value = "/placereanswer")
   public void insertPlaceReAnswer(@RequestBody TourAnswerDto dto) {
      tas.insertPlaceAnswer(dto);
   }
   

   
}