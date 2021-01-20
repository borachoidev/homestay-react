package com.bitcamp.korea_tour.model.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bitcamp.korea_tour.model.mapper.CourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagingServiceImpl implements PagingService {

	private final CourseMapper courseMapper;
	//private final PlaceMapper placeMapper;
	private int totalCount; 

	@Override
	public void dealPaging(String page, Model model) {
		
//		if(page.equals("courses")) {
//			
//		}else if(page.equals("places")) {
//			
//		}else if(page.equals("mycourses")) {
//			
//		}else if(page.equals("myplaces")) {
//			
//		}
//
//		totalCount = service.getTotalCount();
//		int perPage = 10; // 한페이지당 보여질 글의 갯수
//		int perBlock = 5; // 한 블럭당 출력할 페이지의 갯수
//		int totalPage; // 총 페이지의 갯수
//		int startPage; // 각 블럭당 시작 페이지 번호
//		int endPage; // 각 블럭당 끝 페이지 번호
//		int start; // 각 블럭당 불러올 글의 시작번호
//		int end; // 각 블럭당 불러올 글의 끝 번호
//
//		// 총 페이지 구하기(예: 총 글수가 9이고 한페이지당 2개씩 볼경우 5페이지,
//		// 나머지가 있을 경우에는 1페이지 더 추가)
//		totalPage = totalCount/perPage + (totalCount%perPage>0?1:0);
//		// 시작페이지와 끝페이지 구하기
//		// 예: 한페이지당 3개만 볼경우 현재 페이지가 2라면 sp:1, ep:3
//		startPage = (currentPage-1)/perBlock*perBlock+1;
//		endPage = startPage+perBlock-1;
//		// 마지막 블럭은 endPage를 totalPage로 해놔야 한다
//		if(endPage>totalPage){
//			endPage = totalPage;
//		}
//
//		// mysql은 첫글이 0번(오라클은 1번)
//		start = (currentPage-1)*perPage;
//
//		// 각페이지에서 출력할 시작번호
//		// 총 50개일 경우 1페이지는 50
//		int no = totalCount-(currentPage-1)*perPage;
//		//db로부터 출력할 목록 가져오기
//		List<ReBoardDto> list = service.getList(start, perPage);
//
//		// 해당 페이지에서 마지막 하나남은 데이터 삭제시 데이터가 안나오게 되는 현상 해결
//		if(list.size() == 0) {
//			return "redirect:list?pageNum="+(currentPage-1);
//		}
//
//		for(ReBoardDto dto: list) {
//			int n=adao.getAnswerList(dto.getNum()).size();
//			dto.setCnt(n);
//		}
//
//		// model에 저장
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("list", list);
//		model.addAttribute("no", no);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("totalCount", totalCount);
//		model.addAttribute("totalPage", totalPage);
//
//		return "/board/boardlist";		
	}
}
