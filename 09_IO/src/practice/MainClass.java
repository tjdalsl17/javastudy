package practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainClass {
	
	// 문제1. 현재 시간을 이용하여 디렉터리를 생성하시오.
	// 예시)
	// C:\14\31\30
	
	public static void ex01() {
		
		LocalTime now = LocalTime.now();
		
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getMinute();
		
		String sep = File.separator;
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);
		
		if(dir.exists() == false) {
			dir.mkdirs();
			
			
		}
		
	}

	public static void ex02() throws IOException {  // 예외 처리를 ex02 메소드를 호출한 곳으로 넘긴다.
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		
		File file = new File(dir, "myfile.txt");
		if(file.exists() == false) {
			file.createNewFile();  // 반드시 예외 처리가 필요한 코드
		} else {
			file.delete();
		}
		
		
	}
	
	public static void ex03() throws IOException {
		
		File dir = new File("C:"+ File.separator + "storage");
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "myfile.txt");
		
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		// 파일의 정보 확인
		System.out.println("파일명 : " + file.getName());
		System.out.println("디렉터리명 : " + file.getParent());
		System.out.println("경로명 : " + file.getPath());  // 파일명 + 디렉터리명
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModified = file.lastModified(); 	// 최종 수정일의 타임 스탬프
		System.out.println("최종 수정일 : " + lastModified);
		
		String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(lastModified);
		System.out.println("최종 수정일 : " + lastModifiedDate);
		
		long size = file.length();  // 파일의 크기가 바이트 단위로 저장
		long kb = size / 1024 + (size % 1024 != 0 ? 1 : 0);
		System.out.println("파일 크기 : " + kb + "KB");  // 킬로 바이트 출력(1024바이트 = 1킬로바이트)
	}
	
	public static void ex04() {
		
		File dir = new File("C:" + File.separator + "Program Files");
		
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isHidden() == false) { // 숨김 파일이 아니면 보여줌
				System.out.println(files[i].getName());
				
			}
		}
	}
	
	// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
		/*
		2023-01-04  오후 02:19    <DIR>          bin
		2023-01-04  오후 02:19    <DIR>          conf
		2023-01-04  오후 02:19    <DIR>          include
		2023-01-04  오후 02:19    <DIR>          jmods
		2023-01-04  오후 02:19    <DIR>          legal
		2023-01-04  오후 02:19    <DIR>          lib
		2023-01-04  오후 02:19               160 README.html
		2023-01-04  오후 02:19             1,302 release
		               2개 파일               1,462 바이트
		*/
	
	public static void ex05() {
		
		File dir = new File("C:" + File.separator + "Program Files" + File.separator + "Java" + File.separator + "jdk-11.0.17");
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			int fileCount = 0;
			long totalFileSize = 0;
			for(File file : list) {
				if(file.isHidden()) {
					continue;
				}
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm").format(file.lastModified());
				String directory = file.isDirectory() ? "<Dir>" : "";
				String size = "";
				if(file.isFile()) {
					long length = file.length();
					size = new DecimalFormat("#,##0").format(file.length());
					fileCount++;
					totalFileSize += file.length();
				}
				String name = file.getName();
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
				System.out.print(result);
				
				
				
			}
				System.out.println(fileCount + "개 파일 " + new DecimalFormat("#,##0").format(totalFileSize) + "바이트");
				
				
		}
			
			
	}
		
		
		
		
		
		
	
	
	// 문제3. C:\storage 디렉터리를 삭제하시오.
	// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
	
	public static void ex06() {
		
		File dir = new File("C:" + File.separator + "storage");
		
		File file = new File(dir, "myfile.txt");
		if(file.exists()) {
			file.delete();
		}
		if(dir.exists()) {
			dir.delete();
		}
	}
	
	public static void ex07() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sentences = new String[5];
		System.out.println("5문장을 입력하세요.");
		for(int i = 0; i < sentences.length; i++) {
			sentences[i] = sc.nextLine();
		}
		
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "diary.txt");
		
		try (PrintWriter out = new PrintWriter(file)) {
			
			for(int i = 0; i < sentences.length; i++) {
				out.println(sentences[i]);
			}
			
			System.out.println("diary.txt 파일이 생성되었습니다.");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
		
		
		// 문제4. 사용자로부터 입력 받은 문자열을 C:\storage\diary.txt 파일로 보내시오.
		// 총 5개 문장을 입력 받아서 보내시오.
		
		/*File dir = new File("C:" + File.separator + "storage" + File.separator + "diary");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "ex01.txt");
		
		PrintWriter out = null;
		
		try {
			
			out = new PrintWriter(file);
			
			
			out.println("안녕하세요");
			out.println("반갑습니다");
			out.println("눈이 많이 오네요");
			out.println("배고프다");
			out.println("졸려요");
			
			System.out.println("ex01.txt 파일이 생성되었다.");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close(); 
			
		}
	
	 }
	 */
	
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생시간을 저장한 C:\storage\log.txt
	public static void ex08() {
		
		try {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수를 입력하세요 >>> ");
		int number1 = sc.nextInt();
		
		System.out.print("두 번째 정수를 입력하세요 >>> ");
		int number2 = sc.nextInt();
		
		int add = number1 + number2;
		int sub = number1 = number2;
		int mul = number1 * number2;
		int div = number1 / number2;
		
		System.out.println(number1 + "+" + number2 + "=" + add);
		System.out.println(number1 + "-" + number2 + "=" + sub);
		System.out.println(number1 + "*" + number2 + "=" + mul);
		System.out.println(number1 + "/" + number2 + "=" + div);
		
		
		
		
		sc.close();
		
		} catch(Exception e) {
			
			// 날짜
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String dateTime = dtf.format(now);
			
			// 예외 클래스 이름
			String className = e.getClass().getName();
			
			// 예외 메시지
			String message = e.getMessage();
			
			// 로그 파일 만들기
			File dir = new File("C:" + File.separator + "storage" + File.separator + "log.txt");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir, "log.txt");
			
			// 생성 모드(언제나 새로 만든다.) 		new FileWriter(file)
			// 추가 모드(기존 내용에 추가한다.)		new FileWriter(file, true)
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
				
				bw.write(dateTime + " " + className + " " + message + "\n");
				// bw.newLine(); \n을 대신할 수 있는 코드
				
				System.out.println("예외 메시지가 log.txt 파일에 기록되었습니다.");
				
			} catch(IOException e2) {
				e2.printStackTrace();
			}
			
			
			
			
		}
	}
	
	public static void main(String[] args) { // main 메소드를 호출하는 곳으로 예외 처리를 넘긴다. (개발자가 try-catch 하지 않겠다.)
		ex08();

	}

}
