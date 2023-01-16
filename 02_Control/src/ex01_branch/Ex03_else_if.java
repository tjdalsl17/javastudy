package ex01_branch;

public class Ex03_else_if {
	
	public static void ex01() {
		
		// 80 이상 : 상
		// 60 이상 : 중
		// 나머지  : 하
		
		int score = 80;
		
		if(score >= 80) {
			System.out.println("상");
		}
		else if(score >= 60) {
			System.out.println("중");
		}
		else {
			System.out.println("하");
		}
			
	}

	public static void ex02() { // 연습
		// 수,우,미,양,가,잘못된 점수
		int score = 70;
		
		if (score < 0 || score > 100) {
			System.out.println("잘못 입력 하셨습니다.");
		}
		else if (score >= 90) {
			System.out.println("수");
		}
		else if (score >= 80) {
			System.out.println("우");
		}
		else if (score >= 70) {
			System.out.println("미");
		}
		else if (score >= 60) {
			System.out.println("양");
		}
		else if (score < 60) {
			System.out.println("가");
		}
		
	}
	
	public static void ex03() { // 연습
		
		// 겨울 : 12, 1, 2 봄 : 3, 4, 5 ~~~~
		
		int month = 11;
		
		int mod = month % 12; // 12로 나누면 나머지로 구분 (연속되는 수는 나누기 연산으로 가능)
		
		if (mod <= 2) {
			System.out.println("겨울");
		}
		else if (mod <= 5) {
			System.out.println("봄");
		}
		else if (mod <= 8) {
			System.out.println("여름");
		}
		else if (mod <= 11) {
			System.out.println("가을");
		}
	}
	
	public static void ex04() { // 연습
		
		int day = 9;
		int nDay = 10; // 10일 후
		
		String weekname;
		
		day += nDay; // day = day + nDay
		int mod = day % 7;
		
		if (mod == 0) {
			weekname = ("토");
		}
		else if(mod == 1) {
			weekname = ("일");
		}
		else if(mod == 2) {
			weekname = ("월");
		}
		else if(mod == 3) {
			weekname = ("화");
		}
		else if(mod == 4) {
			weekname = ("수");
		}
		else if(mod == 5) {
			weekname = ("목");
		}
		else {
			weekname = ("금");
		}
		System.out.println("1월" + day + "일은 "
				+ "" + weekname + "요일 입니다.");
		
	}
	public static void main(String[] args) {
		ex04();

	}

}
