package ex01_String;

public class MainClass {
	
	public static void ex01() {
		
		// 문자열 리터럴(Literal)
		String str1 = "hello";
		String str2 = "hello";
		
		// 문자열 리터럴은 Java에 의해서 최적화되기 때문에
		// 동일한 리터럴("hello")를 2번 이상 사용하면
		// 기존에 사용한 리터럴을 재사용한다.("hello"라는 리터럴이 2개 이상 만들어 지지 않는다.)
		
		
		/*
        |-------|
   str1 | 0x123 |─────┐
        |-------|          │
   str2 | 0x123 |          │
        |-------|          │
   a[0] |   0   | 0x123    │
        |-------|          │
   a[1] |   0   |          │
        |-------|          │
   a[2] |   0   |          │ 
        |-------|          │
   a[3] |   0   |          │
        |-------|          │
   a[4] |   0   |          │
        |-------|          │
        |  ...  |          │
        |-------|          │
      b | 0x123 |◀────┘
        |-------|
	*/
		// 참조갑이 같다는 의미이다. 저장된 문자열이 같다는 의미가 아니다.
		System.out.println((str1 == str2));
	}

	public static void main(String[] args) {
		ex01();

	}

}
