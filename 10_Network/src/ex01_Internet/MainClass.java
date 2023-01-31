package ex01_Internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainClass {
	
	/*
	 		URL 문제 출제
	 		1. Uniform Resource Locator
	 		2. 정형화된 자원의 경로
	 		3. 실제로는 웹 주소를 의미한다.
	 		4. 구성
	 		   프로토콜:// 		호스트		/ 서버경로	 ?파라미터=값&파라미터=값&
	 				https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=1&acq=tkatjdwjs&qdt=0&ie=utf8&query=삼성전자(마지막은 인코딩된 데이터)
	 		   1) 프로토콜 : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
	 		   2) 호스트 : 서버의 대표 주소
	 		   3) 서버경로 : URL Mapping(URL Pattern)
	 		   4) 파라미터 : 서버로 보내는 데이터를 의미(변수라고 생각하면 된다.)
	 */
	
	public static void ex01() {
		
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		URL url = null;
		
		try {
			
			url = new URL(apiURL); 	// 반드시 예외 처리가 필요한 코드
			
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());
			
		} catch(MalformedURLException e) { // 형태가 잘못된 url exception
			System.out.println("apiURL 주소 오류");
		}
		
		
	}

	public static void ex02() {
		
		// 웹 접속을 담당하는 HttpURLConnection
		
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL); // MalformedURLException 처리가 필요하다.
			con = (HttpURLConnection)url.openConnection();  // IOException 처리가 필요하다.
			
			/*
			 	HTTP 응답 코드 공부하기
			 	1. 200 : 정상 (HttpURLConnection.HTTP_OK)
			 	2. 40X : 잘못된 요청(사용자가 잘못하였음)
			 	3. 50X : 서버측 오류
			 */
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK);
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND);
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);
			
			// apiURL 접속 확인
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {
				System.out.println(apiURL + " 접속 완료");
			}
			
			// 요청 방식(요청 메소드)
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod);
			
			// 컨텐트 타입
			String contentType = con.getContentType();
			System.out.println("컨텐트 타입 : " + contentType); // 웹 상에서 주고받는 데이터 타입
			
			// 요청 헤더
			String userAgent = con.getRequestProperty("User-Agent");
			System.out.println("User-Agent : " + userAgent);
			
			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer);  // 이전 주소가 나옴
			
			// 접속 종료
			con.disconnect();
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			System.out.println("apiURL 접속 오류");
		}
	}
	
	public static void ex03() {
		
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;
		
		InputStream in = null; 			// Daum 로그를 읽어 들이는 입력 스트림
		FileOutputStream out = null;	// C:\storage\daum.png로 내보내는 출력 스트림
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				in = con.getInputStream();
				out = new FileOutputStream("C:" + File.separator + "storage" + File.separator + "daum.png");
				
				byte[] b = new byte[10];
				int readByte = 0;
				
				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte); // 인덱스 0부터 readByte만큼 보내기
				}
				System.out.println("다운로드 완료");
				
				out.close();
				in.close();
				con.disconnect();
				
				
			}
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ex03();

	}

}
