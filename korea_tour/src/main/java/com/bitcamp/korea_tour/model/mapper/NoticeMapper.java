package com.bitcamp.korea_tour.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.NoticeDto;

@Mapper
public interface NoticeMapper {
   public int getTotalCount();
   public List<NoticeDto> getAllDatas(HashMap<String, Object> map);
   public void insertNotice(NoticeDto dto);
   public NoticeDto getData(int noticeNum);
   public void updateNotice(NoticeDto dto);
   public void deleteNotice(int noticeNum);
   public List<NoticeDto> getNewNotice();
   
}