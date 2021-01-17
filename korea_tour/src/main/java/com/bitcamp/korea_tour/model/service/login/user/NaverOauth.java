package com.bitcamp.korea_tour.model.service.login.user;

import org.springframework.stereotype.Component;

@Component
public class NaverOauth implements OauthService {
	@Override
	public String getOauthRedirectURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requestAccessToken(String code) {
		// TODO Auto-generated method stub
		return "";
	}
}
