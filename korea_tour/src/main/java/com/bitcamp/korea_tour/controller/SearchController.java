package com.bitcamp.korea_tour.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.korea_tour.model.JoinPlaceListDto;
import com.bitcamp.korea_tour.model.service.JoinPlaceService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SearchController {

	private final JoinPlaceService service;
	private final PagingService pagingService;
	int totalCount = 0;
	int start = 0;
	int perPage = 0;
	
	@Data
	@AllArgsConstructor
	static class JsonSearchPlace {
		private List<HashMap<String, Object>> place;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonSearchTotalPage {
		private int totalPage;
	}
	
	// 현재 month
	SimpleDateFormat sdf = new SimpleDateFormat("MM");
	Date currDate = new Date();
	int currentMonth = Integer.parseInt(sdf.format(currDate));
	
	@GetMapping("/search/place/{keyword}/totalPage")
	public JsonSearchTotalPage getTotalCountBySearch(
			@PathVariable(name="keyword") String keyword) throws UnsupportedEncodingException {
		String keywordEncode = URLDecoder.decode(keyword, "UTF-8");
		System.out.println(keywordEncode);
		int totalCount = service.getTotalCountByKeywordSearch(keywordEncode);
		System.out.println("totalCount :" + totalCount);
		int totalPage = pagingService.getTotalPage(totalCount);
		return new JsonSearchTotalPage(totalPage);
	}
	
	@GetMapping("/search/title/{currentPage}/{keyword}")
	public JsonSearchPlace getKeywordSearchByTitle(
			@PathVariable(name="currentPage") int currentPage,
			@PathVariable(name="keyword") String keyword) throws UnsupportedEncodingException {
		String keywordEncode = URLDecoder.decode(keyword, "UTF-8");
		System.out.println(keywordEncode);
		
		HashMap<String, Object> req = new HashMap<String, Object>();
		req.put("keyword", keyword);
		int totalCount = service.getTotalCountByKeywordSearch(keyword);
		Map<String, Integer> paging = pagingService.getPagingData(totalCount, currentPage);
		req.put("start", paging.get("start"));
		req.put("perPage", paging.get("perPage"));
		
		List<HashMap<String, Object>> place = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> map = null;
		List<JoinPlaceListDto> list = service.keywordSearchPlaceByTitle(req);
		for(JoinPlaceListDto jdto: list) {
			map = new HashMap<String, Object>();
			map.put("contentId", jdto.getContentId());
			map.put("title", jdto.getTitle());
			map.put("firstImage", jdto.getFirstImage());
			map.put("addr1", jdto.getAddr1());
			map.put("areaCode", jdto.getAreaCode());
			map.put("likeCount", jdto.getLikeCount());
			place.add(map);
		}
		
		return new JsonSearchPlace(place);
	}
	
	@GetMapping("/search/like/{currentPage}/{keyword}")
	public JsonSearchPlace getKeywordSearchByLike(
			@PathVariable(name="currentPage") int currentPage,
			@PathVariable(name="keyword") String keyword) throws UnsupportedEncodingException  {
		String keywordEncode = URLDecoder.decode(keyword, "UTF-8");
		System.out.println(keywordEncode);
		HashMap<String, Object> req = new HashMap<String, Object>();
		req.put("keyword", keywordEncode);
		int totalCount = service.getTotalCountByKeywordSearch(keyword);
		Map<String, Integer> paging = pagingService.getPagingData(totalCount, currentPage);
		req.put("start", paging.get("start"));
		req.put("perPage", paging.get("perPage"));
		
		List<HashMap<String, Object>> place = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> map = null;
		List<JoinPlaceListDto> list = service.keywordSearchPlaceBylike(req);
		for(JoinPlaceListDto jdto: list) {
			map = new HashMap<String, Object>();
			map.put("contentId", jdto.getContentId());
			map.put("title", jdto.getTitle());
			map.put("firstImage", jdto.getFirstImage());
			map.put("addr1", jdto.getAddr1());
			map.put("areaCode", jdto.getAreaCode());
			map.put("likeCount", jdto.getLikeCount());
			place.add(map);
		}
		
		return new JsonSearchPlace(place);
	}
	
}
