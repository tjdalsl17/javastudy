package ex05_InputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	
	public static void ex01() {
		
		File file = new File("C:" + File.separator + "storage", "ex01.bin");
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream(file);
			
			// 입력 단위
			// 1. int 		: 1개
			// 2. byte[] 	: 2개 이상
			
			int c = 0;
			StringBuilder sb = new StringBuilder();
			while((c = fis.read()) != -1) {
				sb.append((char)c);
				
			}
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void ex02() {
		
		// 원래 깨져서 출력됨(바이트 스트림과 한글 처리의 문제 확인)
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream(file);
			
			byte[] b = new byte[4]; 	// 한 번에 4바이트를 읽어 오시오.
			int readByte = 0; 	// 실제로 읽은 바이트를 저장해 두시오.
			StringBuilder sb = new StringBuilder();
			
			while((readByte = fis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte)); 	// 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다.
			}
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex02_complete() {
		
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InputStreamReader
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		InputStreamReader isr = null;
		
		try {
			
			isr = new InputStreamReader(new FileInputStream(file));
		
			
			char[] cbuf = new char[4]; 	// 한 번에 4글자를 읽어 오시오.
			int readCount = 0; 	// 실제로 읽은 글자수를 저장해 두시오.	
			StringBuilder sb = new StringBuilder();
			
			while((readCount = isr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount); 	// 배열 cbuf의 인덱스 0부터 readCount개 데이터를 사용한다.
			}
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) {
					isr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex03() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		
		BufferedInputStream bis = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] b = new byte[4];
			int readByte = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readByte = bis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
			}
			System.out.println(sb.toString());
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) {
					bis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex03_complete() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			System.out.println(sb.toString());
		
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ex03_complete();

	}

}
