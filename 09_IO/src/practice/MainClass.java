package practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

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
	
	public static void main(String[] args) throws IOException { // main 메소드를 호출하는 곳으로 예외 처리를 넘긴다. (개발자가 try-catch 하지 않겠다.)
		ex03();

	}

}
