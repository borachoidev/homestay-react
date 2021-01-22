package com.bitcamp.korea_tour.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TourApi {

	public static String xmlDownload()
			throws IOException {/* 정적 메소드정의?-> 정적 메소드를 사용하면 JSP에서 객체의 선언 없이 바로 클래스 이름 뒤에 붙여서 활용가능 */
		StringBuilder urlBuilder1 = new StringBuilder(
				"http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /* URL */
		urlBuilder1.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=J6mYbSnY7wAwpPP3JTK2bE67pCi7ph2qbw%2B%2FG4Wb1RZY47YJPVGavCpYegxJ6tAypnZmKB8Zncy0UTHFbYZgrw%3D%3D"); 
		urlBuilder1.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
		urlBuilder1.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		/* areaCode {1:서울, 2:인천, 3:대전, 4:대구, 5:광주, 6:부산, 7:울산, 8:세종특별자치시, 31:경기도, 32:강원도, 
		 * 33:충청북도, 34:충청남도, 35:경상북도, 36:경상남도, 37:전라북도, 38:전라남도, 39:제주도 */
		urlBuilder1.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder1.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder1.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("TourAPI3.0_Guide", "UTF-8"));
		urlBuilder1.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("A", "UTF-8"));
		urlBuilder1.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));

//		StringBuilder urlBuilder3 = new StringBuilder(
//				"http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailImage"); /* URL */
//		urlBuilder3.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
//				+ "=gegwvk6zeB5jyYpVL5SFB2d0tHFlUKBlfVMYY4jkwFJ9IeVxgL9EpkW71apt79FOOcXkAmJz%2BbdhVRq9M4jQCw%3D%3D"); 
//		urlBuilder3.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
//		urlBuilder3.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
//		urlBuilder3.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("TourAPI3.0_Guide", "UTF-8"));
//		urlBuilder3.append("&" + URLEncoder.encode("contentId", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
//		urlBuilder3.append("&" + URLEncoder.encode("imageYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		
		URL url1 = new URL(urlBuilder1.toString()); /* 위의 urlBuilder를 하나로 합쳐서 url 이라는 변수에 저장 */
		HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
//		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
		}
		StringBuilder sb1 = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb1.append(line);
		}
		rd.close();
		conn.disconnect();
		
		return sb1.toString();
	}
	public static String detailXmlDownload(String contentid)
			throws IOException {

		StringBuilder urlBuilder2 = new StringBuilder(
				"http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"); /* URL */
		urlBuilder2.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=J6mYbSnY7wAwpPP3JTK2bE67pCi7ph2qbw%2B%2FG4Wb1RZY47YJPVGavCpYegxJ6tAypnZmKB8Zncy0UTHFbYZgrw%3D%3D"); 
		urlBuilder2.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("contentId", "UTF-8") + "=" + URLEncoder.encode(contentid, "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("TourAPI3.0_Guide", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("defaultYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("firstImageYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("areacodeYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("catcodeYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("addrinfoYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("mapinfoYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("overviewYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder2.append("&" + URLEncoder.encode("transGuideYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		
		URL url2 = new URL(urlBuilder2.toString()); /* 위의 urlBuilder를 하나로 합쳐서 url 이라는 변수에 저장 */
		HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
//		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
		}
		StringBuilder sb2 = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb2.append(line);
		}
		rd.close(); 
		conn.disconnect();
		
		return sb2.toString();
	}

	public ArrayList<PlaceDto> insertPlaceList() throws IOException, ParserConfigurationException, SAXException {
		ArrayList<PlaceDto> list = new ArrayList<PlaceDto>();
		String xml = TourApi.xmlDownload();
		
		/* xml 파싱 -> List<item> */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes("utf-8")));

		NodeList nodeList = doc.getElementsByTagName("item");/* xml태그이름 중 item 부분을 전부 긁어모음 */
		PlaceDto dto = new PlaceDto();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			// 태그안에 있는 요소를 가져오기위해 Element를 형변환 하여 다시 담아줌
			Element e = (Element) node;
			try {
				dto.setContentId(Integer.parseInt(e.getElementsByTagName("contentid").item(0).getTextContent()));
			} catch (NullPointerException e3) {
				dto.setContentId(8);
			}
			try {
				dto.setAddr1(e.getElementsByTagName("addr1").item(0).getTextContent());
			} catch (NullPointerException e3) {
				dto.setAddr1(null);
			}
			try {
				dto.setAddr2(e.getElementsByTagName("addr2").item(0).getTextContent());	
			} catch (NullPointerException e3) {
				dto.setAddr2(null);
			}
			try {
				dto.setTitle(e.getElementsByTagName("title").item(0).getTextContent());
			} catch (NullPointerException e3) {
				dto.setTitle(null);
			}
			try {
				dto.setMLevel(Integer.parseInt(e.getElementsByTagName("mlevel").item(0).getTextContent()));
			} catch (NullPointerException e3) {
				dto.setMLevel(6);
			}
			try {
				dto.setMapX(e.getElementsByTagName("mapx").item(0).getTextContent());
			} catch (NullPointerException e3) {
				dto.setMapX(null);
			}
			try {
				dto.setMapY(e.getElementsByTagName("mapy").item(0).getTextContent());
			} catch (NullPointerException e3) {
				dto.setMapY(null);
			}
			try {
				dto.setAreaCode(Integer.parseInt(e.getElementsByTagName("areacode").item(0).getTextContent()));
			} catch (NullPointerException e3) {
				dto.setAreaCode(0);
			}
			
			String contentid = e.getElementsByTagName("contentid").item(0).getTextContent();
			String detailxml = TourApi.detailXmlDownload(contentid);
			Document doc2 = builder.parse(new ByteArrayInputStream(detailxml.getBytes("utf-8")));
			NodeList nodeList2 = doc2.getElementsByTagName("item");
			Node node2 = nodeList2.item(0);
			Element e2=(Element) node2;
			try {
				dto.setOverview(e2.getElementsByTagName("overview").item(0).getTextContent());
			} catch (NullPointerException e3) {
				dto.setOverview(null);
			}
			try {
				dto.setLinkedURL(e2.getElementsByTagName("homepage").item(0).getTextContent());
			} catch (NullPointerException e3) {
				dto.setLinkedURL(null);
			}
			try {
				dto.setFirstImage(e2.getElementsByTagName("firstimage").item(0).getTextContent());
			} catch (NullPointerException e3) {
				dto.setFirstImage(null);
			}
			System.out.println(i);
			System.out.println(dto);
			list.add(dto);
		
		}
		System.out.println("list 개수 : " +list.size());
		return list;
	}
	

}
