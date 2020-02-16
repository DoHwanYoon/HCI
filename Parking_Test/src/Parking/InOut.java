package Parking;

public class InOut {
	
	private int parkingLotFloor; //출차할 차량의 층
	private int carMoveCount; //출차할 차량이 움직여야 하는 횟수
	private String parkingState;
	ParkingLot parkingLot;
	private String[][] tempLotOne;
	private String[][] tempLotTwo;
	
	
	public InOut() {
		//scan = new Scanner(System.in);
		parkingLot = new ParkingLot();
		tempLotOne = new String[4][4];
		tempLotTwo = new String[4][4];
	}

	public void getParkingLot() {
		tempLotOne=parkingLot.getParkingLotOne();
		tempLotTwo=parkingLot.getParkingLotTwo();
	}
	public void setParkingLot() {
		parkingLot.setParkingLotOne(tempLotOne);
		parkingLot.setParkingLotTwo(tempLotTwo);
	}
	
	public void findCar(String carNumber) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(tempLotOne[i][j].equals(carNumber)) {
					parkingLotFloor = i;
					carMoveCount = j;
					parkingState = "one";
				}
				else if(tempLotTwo[i][j].equals(carNumber)) {
					parkingLotFloor = i;
					carMoveCount = j;
					parkingState = "two";
				}
			}
		}
	}
	
	public void In(String carNumber) {
		//inputCarNumber();
		boolean isParking = false;
		getParkingLot();
		for(int i=0; i<4; i++) {
			if(isParking==false) {
				if(tempLotOne[i][0] == "xxxx") {
					for(int j=0; j<3; j++) {
						tempLotOne[i][j]=tempLotOne[i][j+1];
					}
					tempLotOne[i][3]=carNumber;
					isParking=true;
				}
				else if(tempLotTwo[i][3] == "xxxx") {
					for(int k=2; k>=0; k--) {
						tempLotTwo[i][k+1]=tempLotTwo[i][k];
					}
					tempLotTwo[i][0]=carNumber;
					isParking=true;
				}
			}else break;
		}
		setParkingLot();
	}
	
	public void moveCar(String carNumber) {
		boolean isParking = false;
		for(int i=0; i<4; i++) {
			if(isParking==false) {
				if(tempLotOne[i][0] == "xxxx" && parkingState != "one" || i != parkingLotFloor ) {
					for(int j=0; j<3; j++) {
						tempLotOne[i][j]=tempLotOne[i][j+1];
					}
					tempLotOne[i][3]=carNumber;
					isParking=true;
				}
				else if(tempLotTwo[i][3] == "xxxx" && parkingState != "two" || i != parkingLotFloor) {
					for(int k=2; k>=0; k--) {
						tempLotTwo[i][k+1]=tempLotTwo[i][k];
					}
					tempLotTwo[i][0]=carNumber;
					isParking=true;
				}
			}else break;
		}
	}
	
	public void Out(String carNumber) {
		//inputCarNumber();
		//boolean isExit = false;
		String tempCarNumber = null;
		getParkingLot();
		findCar(carNumber);
		if(parkingState.equals("one")){
			for(int i=0; i<4-carMoveCount; i++) {
				if(i<3-carMoveCount) {		
					tempCarNumber = tempLotOne[parkingLotFloor][3];
					moveCar(tempCarNumber);
				}
				for(int j=2; j>=0; j--) {
					tempLotOne[parkingLotFloor][j+1] = tempLotOne[parkingLotFloor][j];
				}
				tempLotOne[parkingLotFloor][0] = "xxxx";
			}
		}
		else if(parkingState.equals("two")) {
			for(int i=0; i<= carMoveCount; i++) {
				if(i < carMoveCount) {
					tempCarNumber = tempLotTwo[parkingLotFloor][0];
					moveCar(tempCarNumber);
				}
				for(int j=0; j<=2; j++) {
					tempLotTwo[parkingLotFloor][j] = tempLotTwo[parkingLotFloor][j+1];
				}
				tempLotTwo[parkingLotFloor][3] = "xxxx";
			}
		}
		setParkingLot();
	}
}