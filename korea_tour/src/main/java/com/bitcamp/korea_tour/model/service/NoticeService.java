package com.bitcamp.korea_tour.model.service;

import java.util.HashMap;
import java.util.List;

import com.bitcamp.korea_tour.model.NoticeDto;

public interface NoticeService {
   public int getTotalCount();
   public List<NoticeDto> getAllDatas(HashMap<String, Object> map);
   public void insertNotice(NoticeDto dto);
   public NoticeDto getData(int noticeNum);
   public void updateNotice(NoticeDto dto);
   public void deleteNotice(int noticeNum);
   public List<NoticeDto> getNewNotice();
   
}