package ex04_OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

	public static void main(String[] args) {
		ex01();

	}

}
