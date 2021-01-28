package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.bitcamp.korea_tour.model.AdminDto;

@Mapper
public interface AdminMapper {
	void insertAdmin(AdminDto adminDto);
	List<AdminDto> getAllAdmin();
	void deleteAdmin(int adminNum);
	int checkAdmin(AdminDto adminDto);
}
