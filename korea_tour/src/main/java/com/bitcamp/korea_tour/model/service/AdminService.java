package com.bitcamp.korea_tour.model.service;

import java.util.List;

import com.bitcamp.korea_tour.model.AdminDto;

public interface AdminService {
	void insertAdmin(AdminDto adminDto);
	List<AdminDto> getAllAdmin();
	void deleteAdmin(int adminNum);
	int checkAdmin(AdminDto adminDto);
}
