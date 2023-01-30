package ex04_OutputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainClass {
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex01.bin");
		
		FileOutputStream fos = null; // fos : 파일 연결을 위한 출력 통로(int, byte[])
		
		try {
			fos = new FileOutputStream(file);
			
			// 출력 단위
			// 1. int 	 : 1개
			// 2. byte[] : 2개 이상
			
			int c = 'A';
			String str = "pple";
			byte[] b = str.getBytes();
			
			// 출력
			fos.write(c);
			fos.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();	
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex02.bin");
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			
			// getBytes(Charset charset)
			byte[] b = str.getBytes(StandardCharsets.UTF_8); // UTF_8로 인코딩하여 생성하시오.
			
			// getBytes(String charsetName)
			// byte[] b = str.getBytes("UTF-8");
			
			fos.write(b);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex02.bin 파일의 크기 : " + file.length() + "바이트");
		
	}

	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex03.bin");

		BufferedOutputStream bos = null;
		
		try {
			
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			bos.write("반갑습니다\n또만나요".getBytes("UTF-8"));
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close(); 	// 위 try 실행문 마지막에 써도 가능 (그럼 finally 사라짐)
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex03.bin 파일의 크기 : " + file.length() + "바이트" );
	}
	
	public static void main(String[] args) {
		ex03();

	}

}
