package ex01_branch;

public class Ex04_switch {
	
	public static void ex01() {
		
		int month = 3;
		
		switch(month) {
		case 12 :
		case 1 :
		case 2 : System.out.println("겨울"); break;
		case 3 :
		case 4 :
		case 5 : System.out.println("봄"); break;
		case 6 :
		case 7 :
		case 8 : System.out.println("여름"); break;
		default : System.out.println("가을"); break;
		}
	}

	public static void ex02() {
		
		int day = 13;
		String weekname;
		
		switch(day % 7) {
		case 0 : weekname="토"; break;
		case 1 : weekname="일"; break;
		case 2 : weekname="월"; break;
		case 3 : weekname="화"; break;
		case 4 : weekname="수"; break;
		case 5 : weekname="목"; break;
		default : weekname="금"; break;
		
		}
		
		System.out.println(day + "일은 " + weekname + "요일 입니다.");
		
		
		
		
	}
	
	public static void ex03() {
		
		int score = 100;
		
		if(score < 0 || score > 100) {
			System.out.println("잘못된 점수");
			return; //  위 조건에 부합하면 ex03 메소드를 종료하시오.
		}
		
		switch (score / 10) {
		case 0 :
		case 1 :
		case 2 :
		case 3 :
		case 4 :
		case 5 : System.out.println("가"); break;
		case 6 : System.out.println("양"); break;
		case 7 : System.out.println("미"); break;
		case 8 : System.out.println("우"); break;
		case 9 :
		case 10 : System.out.println("수"); break;
		default : System.out.println("잘못된 점수"); // 반대로 10부터 시작해도 상관xs
		}
	}
	
	public static void ex04() {
		
		int month = 5; // 1분기 : 1~3  2분기 : 4~6  3분기 : 7~9 4분기 : 10~12
		
		System.out.println((month - 1) / 3 + 1 + "분기");
		
		switch ((month - 1) / 3) {
		case 0 :
			System.out.println("1분기");
			break;
		case 1 :
			System.out.println("2분기");
			break;
		case 2 :
			System.out.println("3분기");
			break;
		default :
			System.out.println("4분기");
		
		}
		
		
	}
	
	public static void main(String[] args) {
		ex02();

	}

}
