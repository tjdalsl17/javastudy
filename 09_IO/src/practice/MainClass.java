package practice;

import java.io.File;
import java.io.IOException;
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

	public static void ex02() throws IOException {
		
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
	
	public static void main(String[] args) throws IOException { // main 메소드를 호출하는 곳으로 예외 처리를 넘긴다. (개발자가 try-catch 하지 않겠다.)
		ex02();

	}

}
