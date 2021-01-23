package com.bitcamp.korea_tour.model.service.paging;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.PagingDto;

@Service
public class PagingServiceImpl implements PagingService {
	
	private final int PERPAGE = 10; // 한페이지당 보여질 글의 갯수
	private final int PERBLOCK = 5; // 한 블럭당 출력할 페이지의 갯수
	private int totalPage; // 총 페이지의 갯수
	private int startPage; // 각 블럭당 시작 페이지 번호
	private int endPage; // 각 블럭당 끝 페이지 번호
	private int start; // 각 블럭당 불러올 글의 시작번호
	private int end; // 각 블럭당 불러올 글의 끝 번호

	@Override
	public PagingDto getPagingData(int totalCount, int currentPage) {

		// 총 페이지 구하기
		totalPage = totalCount/PERPAGE + (totalCount%PERPAGE>0?1:0);
		// 시작페이지와 끝페이지 구하기
		// 예: 한페이지당 3개만 볼경우 현재 페이지가 2라면 sp:1, ep:3
		startPage = (currentPage-1)/PERBLOCK*PERBLOCK+1;
		endPage = startPage+PERBLOCK-1;
		// 마지막 블럭은 endPage를 totalPage로 해두기
		if(endPage>totalPage){
			endPage = totalPage;
		}

		// mysql은 첫글이 0번(오라클은 1번)
		start = (currentPage-1)*PERPAGE;

//		//db로부터 출력할 목록 가져오기
//		List<ReBoardDto> list = service.getList(start, perPage);
//
//		// 해당 페이지에서 마지막 하나남은 데이터 삭제시 데이터가 안나오게 되는 현상 해결
//		if(list.size() == 0) {
//			return "redirect:list?pageNum="+(currentPage-1);
//		}


		// dto에 저장
		PagingDto pagingDto=new PagingDto();
		pagingDto.setCurrentPage(currentPage);
		pagingDto.setStartPage(startPage);
		pagingDto.setEndPage(endPage);
		pagingDto.setTotalPage(totalPage);
		pagingDto.setTotalCount(totalCount);
		pagingDto.setStart(start);
		pagingDto.setEnd(end);
		
		return pagingDto;		
	}
	

}
