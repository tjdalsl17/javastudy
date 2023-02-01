package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class XMLMainClass {
	
	public static void ex01() {
		
		/*
		 	한국공항공사_항공기 운항정보 : 공항 코드 정보
		 	1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		 	2. 요청 변수(Request Parameter)
		 		1) ServiceKey : 인증키
		 */
		
		String serviceKey = "DYL8tbccBRtrNFiAqGKYBrQhg6wGylfT9Wrego1m0wpWCnxqXO+RaK70l46I87yLFAfGh2rhJAurUn5eR8VATA==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {	// HttpURLConnection.HTTP_OK이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("공항코드.xml이 생성되었습니다.");
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		
		/*
		 	한국공항공사_항공기 운항정보 : 공항 코드 정보
		 	1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		 	2. 요청 변수(Request Parameter)
		 		1) ServiceKey : 인증키
		 		2) pageNo : 조회할 페이지 번호
		 		3) schDate : 검색이자
		 		4) schDeptCityCode : 출발도시코드
		 		5) schArrvCityCode : 도착도시코드
		 */
		
		String serviceKey = "DYL8tbccBRtrNFiAqGKYBrQhg6wGylfT9Wrego1m0wpWCnxqXO+RaK70l46I87yLFAfGh2rhJAurUn5eR8VATA==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
		
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&pageNo=1";
			apiURL += "&schDate=20230201";
			apiURL += "&schDeptCityCode=ICN";
			apiURL += "&schArrvCityCode=JFK";
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
		
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {  // HttpURLConnection.HTTP_OK이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage", "국제선운항스케쥴.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선운항스케쥴.xml이 생성되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ex02();

	}

}
