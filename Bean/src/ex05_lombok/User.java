package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder	// 에러시 애너테이션 지웠다 다시 입력
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	private String id;
	private String pw;

}
