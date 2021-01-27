package com.bitcamp.korea_tour.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.NoticeDto;
import com.bitcamp.korea_tour.model.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
   
   private final NoticeMapper mapper;

   @Override
   public int getTotalCount() {
      // TODO Auto-generated method stub
      return mapper.getTotalCount();
   }

   @Override
   public List<NoticeDto> getAllDatas(HashMap<String, Object> map) {
      // TODO Auto-generated method stub
      return mapper.getAllDatas(map);
   }

   @Override
   public void insertNotice(NoticeDto dto) {
      // TODO Auto-generated method stub
      mapper.insertNotice(dto);
   }

   @Override
   public NoticeDto getData(int noticeNum) {
      // TODO Auto-generated method stub
      return mapper.getData(noticeNum);
   }

   @Override
   public void updateNotice(NoticeDto dto) {
      // TODO Auto-generated method stub
      mapper.updateNotice(dto);
   }

   @Override
   public void deleteNotice(int noticeNum) {
      // TODO Auto-generated method stub
      mapper.deleteNotice(noticeNum);
      
   }

   @Override
   public List<NoticeDto> getNewNotice() {
      // TODO Auto-generated method stub
      return mapper.getNewNotice();
   }

}