package ex04_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

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
	
	public static void ex04() {
		
		// 변수를 그대로 출력하는 DataOutputStream
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex04.dat");
		
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(file));
			
			// 출력할 변수
			String name = "에밀리";  // 9바이트
			int age = 30; 			 // 4바이트
			double height = 170.5; 	 // 8바이트
			boolean isAlive = true;  // 
			
			// 출력(변수 타입에 따라서 메소드가 다름)
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeBoolean(isAlive);
			
		} catch(IOException e) {
			e.printStackTrace();	
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex04.dat 파일의 크기 : " + file.length() + "바이트");
	}
	
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutputStream
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex05.dat");
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 출력할 객체
			List<Person> people = Arrays.asList(
				new Person("에밀리", 30, 180.5, true),
				new Person("제시카", 35, 190.5, true)
			);
			
			// 출력할 객체
			Person person = new Person();
			person.setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			// 출력
			oos.writeObject(people);
			oos.writeObject(person);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex05.dat 파일의 크기 : " + file.length() + "바이트" );
		
		
	}
	
	public static void main(String[] args) {
		ex05();

	}

}
