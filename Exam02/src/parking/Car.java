package parking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//1. 다음 구성요소를 가지는 Car 클래스를 구현하시오.

	// 1) field

public class Car {
	private String carNo;
	private String model;
	
	// 2) constructor
	
	public Car(String carNo, String model) {
		super();
		this.carNo = carNo;
		this.model = model;
	}
	
	// 3) method

	public String getCarNo() {
		return carNo;
	}


	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [carNo=" + carNo + ", model=" + model + "]";
	}
}




	
	
	
	
	
	
	
	
	
	


