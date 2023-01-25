package parking;

public class ParkingException extends Exception{
	
	
	
		private String exceptionCode;
		
		public ParkingException(String message, String exceptionCode) {
			super(message);
			this.exceptionCode = exceptionCode;
		}
	

	public static void main(String[] args) {
		
		
		

	}

}
