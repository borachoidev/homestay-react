package com.bitcamp.korea_tour.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.mapper.UserMapper;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService,SessionNames {
	
	private final UserMapper mapper;
	
	@Override
	public void getUserList(Model model) {
		
		mapper.getUserList();

	}

	@Override
	public void insertUser(UserDto dto) {
		
		mapper.insertUser(dto);
		
	}
	
	@Override
	public void setSession(UserDto dto, HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.setAttribute(USER, dto);
		
	}

	@Override
	public void getUserData(String userNum, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userNum) {

	}
	
	@Override
	public String getAccessToken(String sns, String code) {
		final String RequestUrl;
		final List<NameValuePair> postParams = new ArrayList<>();


		RequestUrl = "https://kauth.kakao.com/oauth/token"; // Host
		postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		postParams.add(new BasicNameValuePair("client_id", "5d2136e7d58ec45f7275dcd5dd09cf7c")); // REST API KEY
		postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:9003/login/kakao")); // 리다이렉트 URI
		postParams.add(new BasicNameValuePair("code", code)); // 로그인 과정중 얻은 code 값
		postParams.add(new BasicNameValuePair("client_secret", "jeYn5R9K3CFHZDYqmdryIDdGpJQ8Cp9w"));
		
		final HttpClient client = HttpClientBuilder.create().build();
		System.out.println(client);
		final HttpPost post = new HttpPost(RequestUrl);
		System.out.println(post);
		JsonNode returnNode = null;
		

			try {
				post.setEntity(new UrlEncodedFormEntity(postParams));
				final HttpResponse response = client.execute(post);
				final int responseCode = response.getStatusLine().getStatusCode();
				
				System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
				System.out.println("Post parameters : " + postParams);
				System.out.println("Response Code : " + responseCode);
				
				ObjectMapper mapper = new ObjectMapper();
				returnNode = mapper.readTree(response.getEntity().getContent());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String accessToken= returnNode.path("access_token").asText();
			
			
		return accessToken;
		
	}
		
	
	@Override
	public UserDto getUserInfo(String sns, String accessToken) {
		
		UserDto dto = new UserDto();
		
		if(sns.equals("kakao")) {
			String RequestUrl=null;
			
			RequestUrl="https://kapi.kakao.com/v2/user/me";
			final HttpClient client = HttpClientBuilder.create().build();
	        final HttpPost post = new HttpPost(RequestUrl);
	 
	        // add header
	        post.addHeader("Authorization", "Bearer " + accessToken);
	 
	        JsonNode userInfo = null;
	 
	        try {
	            final HttpResponse response = client.execute(post);
	            final int responseCode = response.getStatusLine().getStatusCode();
	 
	            System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
	            System.out.println("Response Code : " + responseCode);
	 
	            // JSON 형태 반환값 처리
	            ObjectMapper mapper = new ObjectMapper();
	            userInfo = mapper.readTree(response.getEntity().getContent());
	           
	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            // clear resources
	        }
	        
	        
	        dto.setKakaoKey(userInfo.path("id").asText());
	        dto.setName(userInfo.path("properties").path("nickname").asText());
			dto.setPhoto(userInfo.path("properties").path("profile_image").asText());
			/*
			 * dto.setEmail(userInfo.path("kakao_account").path("email").asText());
			 * dto.setGender(userInfo.path("kakao_account").path("gender").asText());
			 */

		}else if(sns.equals("naver")) {
			
		}else {
			
		}
		
		return dto;
		
	}
	
	@Override
	public boolean hasKey(String key) {
		
		if(mapper.hasKey(key)!=0) {
			return true;
		}
		
		return false;
	}
	
}
