package ex04_throws;

public class Gun {
	
	private int bullet;
	private final int MAX_BULLET = 10;
	
	// 총알 넣기
	public void reload(int bullet) throws RuntimeException { 	// reload 메소드를 호출하는 곳으로 예외를 던지겠다.
		if(this.bullet + bullet > MAX_BULLET) {
			throw new RuntimeException("장전 불가능");
		}
		this.bullet += bullet;
		System.out.println(this.bullet + "발 장전 완료");
	}
	
	
	// 총 쏘기
	public void shoot() throws RuntimeException {
		if(bullet == 0) {
			throw new RuntimeException("총알 부족");
			
		}
		bullet--;
		System.out.println("빵! " + bullet + "발 장전 완료");
	}


	public int getBullet() {
		return bullet;
	}


	public void setBullet(int bullet) {
		this.bullet = bullet;
	}


	public int getMAX_BULLET() {
		return MAX_BULLET;
	}
	

}
