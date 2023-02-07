package practice02;

import java.util.Scanner;

public class MainClass {

	// 문제1. 통장(balance)에 최초 5000원이 있다.
	// 1원부터 통장 잔고 사이의 난수를 발생시켜서 해당 난수만큼 출금 처리하시오.
	// 더 이상 출금이 불가능한 상황이면 출금을 멈추시오.
	// 예시)
	// 출금 전 5000원, 1회 출금액 2917원, 출금 후 2083원
	// 출금 전 2083원, 2회 출금액 1961원, 출금 후 122원
	// 출금 전 122원, 3회 출금액 102원, 출금 후 20원
	// 출금 전 20원, 4회 출금액 2원, 출금 후 18원
	// 출금 전 18원, 5회 출금액 17원, 출금 후 1원
	// 출금 전 1원, 6회 출금액 1원, 출금 후 0원
	public static void ex01() {
		
		int balance = 5000;
		int count = 0;
		while(balance > 0) {
			count++;
			int withdraw = (int)(Math.random() * balance) + 1;
			System.out.println("출금 전 " + balance + "원 ," + count + "회 출금액 " + withdraw + "원, 출금 후 " + (balance -= withdraw) + "원");
		}
		
	}
	
	// 문제2. UpDown 게임
	// 1 ~ 10000 사이의 난수를 발생시키고 해당 난수를 사용자가 맞히는 게임이다.
	// 입력마다 "Up!", "Down!" 메시지를 출력하시오.
	// 예시)
	// 입력 >>> 5000
	// Down!
	// 입력 >>> 2500
	// Up!
	// ...
	// 입력 >>> 4500
	// 정답. 총 5번만에 성공.
	public static void ex02() {
		
		Scanner sc = new Scanner(System.in);
		int Num = (int)(Math.random() * 10000) + 1;
		int guess;
		int times = 0;
		do {
			System.out.print("입력 >>> ");
			guess = sc.nextInt();
			times++;
			if(guess == Num) {
				System.out.println("정답. 총 " + times + "번 만에 성공");
			} else if(guess > Num) {
				System.out.println("Up!");
				
			} else
				System.out.println("Down!");
			
		} while(guess != Num);
		sc.close();
		
	}
	
	// 문제3. 자동으로 진행되는 윷 던지기를 구현하시오. 윷이나 모가 나오면 추가로 던지시오.
	// 예시)
	// "도", 1칸 이동한다.
	// "개", 2칸 이동한다.
	// "걸", 3칸 이동한다.
	// "윷", "도", 5칸 이동한다.
	// "모", "윷", "도", 10칸 이동한다.
	public static void ex03() {
		
		
		String[] yut = {"", "도", "개", "걸", "윷", "모"};
		int totalMove = 0;
		while (true) {
			int move = (int)(Math.random() * 5) + 1;
			System.out.print("\"" + yut[move] + "\"");
			totalMove += move;
			if (move <= 3) {
				System.out.println("," + totalMove + "칸 이동한다.");
				break;
			} else {
				System.out.print(", ");
			}
		}
	}
	
	// 문제4. 0~9 사이 난수를 100개 생성하시오.
	// 발생한 0~9 사이의 각 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하시오.
	// 예시)
	// 0 : #### 4
	// 1 : ############ 12
	// 2 : ############ 12
	// 3 : ##### 5
	// 4 : ######## 8
	// 5 : ########### 11
	// 6 : ############ 12
	// 7 : ################## 18
	// 8 : ####### 7
	// 9 : ########### 11
	public static void ex04() {
		
		int arr[] = new int[100];
		int count[] = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
			count[arr[i]]++;
		}
		for (int i = 0; i < count.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < count[i]; j++) {
				sb.append("#");
			}
			String graph = sb.toString();
			System.out.println(i + ":" + graph + " " + count[i]);
		}
	}
	
	// 문제5. 간단한 성적 관리 프로그램을 구현하시오.
	// 학생은 3명, 과목은 3과목으로 가정한다.
	// 학생 이름 : "정숙", "미희", "상철"
	// 과목 이름 : "국어", "영어", "수학"
	// 입력 받은 성적과 각 성적의 합계를 함께 출력하시오.
	// 예시)
	// 정숙의 국어 점수 >>> 50
	// 정숙의 영어 점수 >>> 51
	// 정숙의 수학 점수 >>> 53
	// 미희의 국어 점수 >>> 60
	// 미희의 영어 점수 >>> 61
	// 미희의 수학 점수 >>> 63
	// 상철의 국어 점수 >>> 70
	// 상철의 영어 점수 >>> 71
	// 상철의 수학 점수 >>> 73
	//
	// 	    국어 영어 수학 총점	
	// 정숙 50   51   53   154	
	// 미희 60   61   63   184	
	// 상철 70   71   73   214	
	// 합계 180  183  189  552	
	public static void ex05() {
		
		Scanner sc = new Scanner(System.in);
		
		 String[] name = {"정숙", "미희", "상철",  "합계"};
		 String[] sub = {"국어", "영어", "수학", "총점"};
		 int [][] score = new int[name.length][sub.length];
		 for(int i = 0; i < score.length -1; i++) {
			 for(int j = 0; j < score[i].length; j++) {
				 System.out.print(name[i] + "의 " + sub[j] + "점수 >>> ");
				 score[i][j] = sc.nextInt();
				 score[i][sub.length - 1] += score[i][j];
				 
			 }
		 }
		
	}
	
	// 문제6. 4계절이 저장되어 있는 영한 사전(2차원 배열)을 이용하여 문제를 해결하시오.
	// 예시)
	// 봄을 영어로 하면? >>> spring
	// 정답
	// 여름을 영어로 하면? >>> sumer
	// 오답
	// 가을을 영어로 하면? >>> fall
	// 정답
	// 겨울을 영어로 하면? >>> win
	// 오답
	public static void ex06() {
		
		Scanner sc = new Scanner(System.in);
		
		String[][] dictionary = {
			{"봄", "spring"},
			{"여름", "summer"},
			{"가을", "fall"},
			{"겨울", "winter"}
		
	};
		for(int i = 0; i < dictionary.length; i++) {
			System.out.print(dictionary[i][0]+ "을 영어로 하면? >>>");
			String answer = sc.next();
		if(answer.equalsIgnoreCase(dictionary[i][1])) {
			System.out.println("정답");
		} else
			System.out.println("오답");
		} 
		
			sc.close();
		} 

			
	
	// 문제7. 다음 순서에 따라서 5 x 5 형태의 숫자 빙고판을 자동으로 생성하시오.
	// 지시사항)
	//   1. 1 ~ 25 사이 정수를 2차원 배열 bingo 에 순차적으로 넣는다.
	//   2. 섞는다.
	//        총 25번의 교환이 랜덤하게 발생된다.
	//        교환 예시)
	//        순서대로    <-> 임의로
	//        bingo[0][0] <-> bingo[1][4]
	//        bingo[0][1] <-> bingo[0][2]
	//        bingo[0][2] <-> bingo[2][1]
	//        ...
	//        bingo[4][4] <-> bingo[3][1]
	// 예시)
	//  10  9  4 25  2
	//  15  3 13 21  1
	//  14 20 11 19  6
	//   8 17  5 12  7
	//  16 22 18 24 23
	
	public static void ex07() {
		
	}
	
	// 문제8. 대문자와 소문자와 숫자로 구성된 인증번호를 만드시오.
	// 사용자로부터 몇 자리의 인증번호를 만들것인지 입력 받아서 처리하시오.
	// 대문자와 소문자와 숫자는 임의로 섞으시오.
	// 예시)
	// 몇 자리의 인증번호를 생성할까요? >>> 6
	// 생성된 6자리 인증번호는 Fa013b입니다.
	public static void ex08() {
		
	}
	
	// 문제9. 다음 지시시항에 따라 요일을 계산하는 프로그램을 구현하시오.
	// 지시사항)
	//   1. AD 1년 1월 1일은 월요일이다.
	//   2. 평년은 1년이 365일이다.(2월 28일까지 있다.)
	//   3. 윤년은 1년이 366일이다.(2월 29일까지 있다.)
	//   4. 윤년이란?
	//      1) 4로 나눠 나머지가 0인 년도는 윤년이다.
	//      2) 이 중 100으로 나눠 나머지가 0인 년도는 평년이다.
	//      3) 이 중 400으로 나눠 나머지가 0인 년도는 윤년이다.
	// 힌트)
	//   1년 1월 1일부터 입력한 날짜까지 며칠이 지났는지 계산한다.
	//   계산된 일수와 요일의 관계는 다음과 같다.
	//     일 : 계산된 일수를 7로 나눈 나머지가 0이다.
	//     월 : 계산된 일수를 7로 나눈 나머지가 1이다.
	//     화 : 계산된 일수를 7로 나눈 나머지가 2이다.
	//     수 : 계산된 일수를 7로 나눈 나머지가 3이다.
	//     목 : 계산된 일수를 7로 나눈 나머지가 4이다.
	//     금 : 계산된 일수를 7로 나눈 나머지가 5이다.
	//     토 : 계산된 일수를 7로 나눈 나머지가 6이다.
	// 예시)
	// 년-월-일 입력(2000-01-01) >>> 2023-01-19
	// 입력된 2023-01-19는 목요일입니다.
	public static void ex09() {
		
	}
	
	// 문제10. 사용자가 입력한 금액만큼 로또를 구매한다고 가정하고, 완성된 로또 용지를 출력하시오.
	// 금액은 1000원 단위로 입력하고 100원 이하 단위 입력은 무시하시오.
	// 로또 용지 1개에는 최대 5개의 로또 게임 기록이 가능하다.
	// 예시)
	// 얼마나 구입하시겠습니까? >>> 16000
	// 01 :   24  20  15  39  41  35
	// 02 :   14  43  23  26   4  38
	// 03 :   21  13  38   1  34  42
	// 04 :    1   2  41  33  43  14
	// 05 :   28  24  27  21  23  37
	// ------------------------------
	// 01 :   12  23  42  30  41  43
	// 02 :   38  37  42  31  13  19
	// 03 :   44  18  35  26   3  41
	// 04 :   30  40   5   2  10  22
	// 05 :   45  13   6  39  30  19
	// ------------------------------
	// 01 :   12  15  29  45  28  39
	// 02 :   25  39  20  43  34  27
	// 03 :   30   4  38   9   2  22
	// 04 :    9  39  22  20  21  35
	// 05 :    6  43  40   4  14  31
	// ------------------------------
	// 01 :   13  10  42  34  32  21
	// ------------------------------
	public static void ex10() {
		
	}
	public static void main(String[] args) {
		ex02();

	}

}