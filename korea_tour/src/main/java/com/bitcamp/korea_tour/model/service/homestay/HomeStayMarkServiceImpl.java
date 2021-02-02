package com.bitcamp.korea_tour.model.service.homestay;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.mapper.HomeStayMarkMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayMarkServiceImpl implements HomeStayMarkService {
	
	private final HomeStayMarkMapper homeStayMarkMapper;
	
//	private final HomeStayMarkMapper mapper;
//	
//	@Override
//	public List<JoinHomeStayMark> getMarkList(int userNum) {
//		// TODO Auto-generated method stub
//		return mapper.getMarkList(userNum);
//	}
//
//	@Override
//	public int getTotalCount(int userNum) {
//		// TODO Auto-generated method stub
//		return mapper.getTotalCount(userNum);
//	}
	
	@Override
	public void insertMark(@Param("homeStayNum") int homeStayNum, int loginNum) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("homeStayNum", homeStayNum);
		map.put("loginNum", loginNum);
		homeStayMarkMapper.insertMark(map);
	}
	
	@Override
	public void deleteMark(@Param("homeStayNum") int homeStayNum, int loginNum) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("homeStayNum", homeStayNum);
		map.put("loginNum", loginNum);
		homeStayMarkMapper.deleteMark(map);
	}
}
