package api.data;

import java.io.IOException;
import java.net.URLEncoder;

public class TourApi {

	public static String xmlDownload()
			throws IOException {/* 정적 메소드정의?-> 정적 메소드를 사용하면 JSP에서 객체의 선언 없이 바로 클래스 이름 뒤에 붙여서 활용가능 */
		StringBuilder getListByAreaCodeUrl = new StringBuilder(
				"http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /* URL */
		getListByAreaCodeUrl.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=gegwvk6zeB5jyYpVL5SFB2d0tHFlUKBlfVMYY4jkwFJ9IeVxgL9EpkW71apt79FOOcXkAmJz%2BbdhVRq9M4jQCw%3D%3D"); /*

		// &upkind=417000&pageNo=1&numOfRows=10
//        String bgndey = bgnde;

		System.out.print(urlBuilder);
		urlBuilder.append("&" + URLEncoder.encode("bgnde", "UTF-8") + "=" + URLEncoder.encode(bgndey, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "=" + URLEncoder.encode(enddey,
				"UTF-8"));/* 시도 이름 (서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종) */
		urlBuilder.append("&" + URLEncoder.encode("upkind", "UTF-8") + "=" + URLEncoder.encode("417000", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("30", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("upr_cd", "UTF-8") + "=" + URLEncoder.encode("6110000", "UTF-8"));

		URL url = new URL(urlBuilder.toString()); /* 위의 urlBuilder를 하나로 합쳐서 url 이라는 변수에 저장 */
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		return sb.toString();
	}

	public ArrayList<AbandonDto> getAbandonList() throws IOException, ParserConfigurationException, SAXException {
		ArrayList<AbandonDto> list = new ArrayList<AbandonDto>();
		String xml = Abandon.xmlDownload();
		/* xml 파싱 -> List<item> */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes("utf-8")));

		NodeList nodeList = doc.getElementsByTagName("item");/* xml태그이름 중 item 부분을 전부 긁어모음 */
		for (int i = 0; i < nodeList.getLength(); i++) {
			AbandonDto dto = new AbandonDto();
			Node node = nodeList.item(i);
			// 태그안에 있는 요소를 가져오기위해 Element를 형변환 하여 다시 담아줌
			Element e = (Element) node;
			dto.setAge(e.getElementsByTagName("age").item(0).getTextContent());
			dto.setCareaddr(e.getElementsByTagName("careAddr").item(0).getTextContent());
			dto.setCareNm(e.getElementsByTagName("careNm").item(0).getTextContent());
			dto.setOfficetel(e.getElementsByTagName("officetel").item(0).getTextContent());
			dto.setColorcd(e.getElementsByTagName("colorCd").item(0).getTextContent());
			dto.setDesertionNo(e.getElementsByTagName("desertionNo").item(0).getTextContent());
			dto.setKindcd(e.getElementsByTagName("kindCd").item(0).getTextContent());
			dto.setNeuteryn(e.getElementsByTagName("neuterYn").item(0).getTextContent());
			dto.setSexCd(e.getElementsByTagName("sexCd").item(0).getTextContent());
			dto.setPopfile(e.getElementsByTagName("popfile").item(0).getTextContent());
			dto.setSpecialmark(e.getElementsByTagName("specialMark").item(0).getTextContent());
			dto.setNoticeSdt(e.getElementsByTagName("noticeSdt").item(0).getTextContent());
			list.add(dto);
		}

		System.out.println(doc);

		return list;
	}

	public AbandonDto getData(String desertionNo) {
		AbandonDto dto = new AbandonDto();
		String xml;
		try {
			xml = Abandon.xmlDownload();
			/* xml 파싱 -> List<item> */
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes("utf-8")));

			NodeList nodeList = doc.getElementsByTagName("item");/* xml태그이름 중 item 부분을 전부 긁어모음 */

//			Element firstElement = (Element) nodeList.item(0);
//			NodeList firstNmElementList = firstElement.getElementsByTagName("desertionNo");
			// firstElement 하위의 id 노드를 검색하여 배열로 리턴
			
//			Element firstNmElement = (Element) firstNmElementList.item(0); //
			
			  
//			NodeList firstNm = firstNmElement.getChildNodes(); // firstNmElement의 하위 노드를
			 
			  
//			System.out.println(((Node) firstNm.item(0)).getNodeValue());
			
//			String dogNum = String.valueOf(((Node) firstNm.item(0)).getNodeValue());
			// 첫 번째 노드의 값 출력
			
			  for (int i = 0; i < nodeList.getLength(); i++) {
			  Node node = nodeList.item(i); // 태그안에 있는 요소를 가져오기위해 Element를 형변환 하여다시 담아줌
			  Element e = (Element) node;
			  if(e.getElementsByTagName("desertionNo").item(0).getTextContent().equals(desertionNo)){
				  dto.setAge(e.getElementsByTagName("age").item(0).getTextContent());
				  dto.setCareaddr(e.getElementsByTagName("careAddr").item(0).getTextContent());
				  dto.setCareNm(e.getElementsByTagName("careNm").item(0).getTextContent());
				  dto.setOfficetel(e.getElementsByTagName("officetel").item(0).getTextContent());
				  dto.setColorcd(e.getElementsByTagName("colorCd").item(0).getTextContent());
				  dto.setDesertionNo(e.getElementsByTagName("desertionNo").item(0).getTextContent());
				  dto.setKindcd(e.getElementsByTagName("kindCd").item(0).getTextContent());
				  dto.setNeuteryn(e.getElementsByTagName("neuterYn").item(0).getTextContent());
				  dto.setSexCd(e.getElementsByTagName("sexCd").item(0).getTextContent());
				  dto.setPopfile(e.getElementsByTagName("popfile").item(0).getTextContent());
				  dto.setSpecialmark(e.getElementsByTagName("specialMark").item(0).getTextContent());
				  dto.setNoticeSdt(e.getElementsByTagName("noticeSdt").item(0).getTextContent());
			  }
		  }
		
//		System.out.println(doc);

		} catch (IOException | ParserConfigurationException | SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return dto;
	}
}
