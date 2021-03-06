package Parking;

public class InOut {
	
	private final String EMPTY = "xxxx";
	private int parkingLotFloor; //출차할 차량의 층
	private int carMoveCount; //출차할 차량이 움직여야 하는 횟수
	//private String[] tempOutCar; //차량을 이동할 공간이 없을 경우 임시적으로 출차하여 저장할 주차 배열 
	private String parkingState; //출차할 차량의 배열 위치 
	private String[][] parkingLotOne; // 1번 주차 배열 
	private String[][] parkingLotTwo; // 2번 주차 배열 	
	
	public InOut() {
		//tempOutCar = new String[4];
		parkingLotOne = new String[4][4];
		parkingLotTwo = new String[4][4];
	}

	public String[][] getParkingLotOne() {
		return this.parkingLotOne;
	}
	
	public String[][] getParkingLotTwo() {
		return this.parkingLotTwo;
	}
	
	public void setParkingLotOne(String[][] parkingLotOne) {
		this.parkingLotOne=parkingLotOne;
		
	}
	public void setParkingLotTwo(String[][] parkingLotTwo){
		this.parkingLotTwo=parkingLotTwo;
	}
	
	public void setIn(String carNumber) {	// 입차를 위한 함수. 
		boolean isParking = false; // 주차 완료 여부 
		for(int i=0; i<4; i++) {
			if(isParking==false) {
				if(parkingLotOne[i][0] == EMPTY) {
					for(int j=0; j<3; j++) {
						parkingLotOne[i][j]=parkingLotOne[i][j+1];
					}
					parkingLotOne[i][3]=carNumber;
					isParking=true;
				}
				else if(parkingLotTwo[i][3] == EMPTY) {
					for(int k=2; k>=0; k--) {
						parkingLotTwo[i][k+1]=parkingLotTwo[i][k];
					}
					parkingLotTwo[i][0]=carNumber;
					isParking=true;
				}
			}else break;
		}
	}
	
	// 출차 하고자 하는 차량의 parkingState(배열위치), parkingLotFloor(차량의 층)와 carMoveCount(출차를 위해 움직여야하는 횟수)값을 세팅.
	public void setCarLocation(String carNumber) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(parkingLotOne[i][j].equals(carNumber)) {
					parkingLotFloor = i;
					carMoveCount = j;
					parkingState = "one";
				}
				else if(parkingLotTwo[i][j].equals(carNumber)) {
					parkingLotFloor = i;
					carMoveCount = j;
					parkingState = "two";
				}
			}
		}
	}
	
	/* 출차 시 이동이 필요한 차량을 재 주차시키는 함수.
	 *  출차할 차량의 parkingState가 "one" 일 때 같은층의 parkingStateTwo에 빈자리가 있다면 주차.
	 *  출차할 차량의 parkingState가 two" 일 때 같은층의 parkingStateOne에 빈자리가 있다면 주차.
	 *  출차할 차량의 parkingLotFloor가 1층 또는 2층일 경우 parkingLotFloor를 제외하고 내림차순으로 주차자리 탐색 후 주차.
	 *  출차할 차량의 parkingLotFloor가 3층 또는 4층일 경우 parkingLotFloor를 제외하고 오름차순으로 주차자리 탐색 후 주차.
	 */
	public void setMoveCar(String carNumber) {
		boolean isParking = false; // 주차 완료 여부
		
		if(parkingState=="one" && parkingLotTwo[parkingLotFloor][3]==EMPTY) {
			for(int k=2; k>=0; k--) {
				parkingLotTwo[parkingLotFloor][k+1]=parkingLotTwo[parkingLotFloor][k];
			}
			parkingLotTwo[parkingLotFloor][0]=carNumber;
		}
		
		else if(parkingState=="two" && parkingLotOne[parkingLotFloor][0] == EMPTY) {
			for(int j=0; j<3; j++) {
				parkingLotOne[parkingLotFloor][j]=parkingLotOne[parkingLotFloor][j+1];
			}
			parkingLotOne[parkingLotFloor][3]=carNumber;
		}

		else if(parkingLotFloor == 0 || parkingLotFloor == 1) {
			for(int i = 0; i<=3; i++) {
				if(isParking==false) {
					if(parkingLotOne[i][0] == EMPTY && i != parkingLotFloor ) {
						for(int j=0; j<3; j++) {
							parkingLotOne[i][j]=parkingLotOne[i][j+1];
						}
						parkingLotOne[i][3]=carNumber;
						isParking=true;
					}
					else if(parkingLotTwo[i][3] == EMPTY && i != parkingLotFloor) {
						for(int k=2; k>=0; k--) {
							parkingLotTwo[i][k+1]=parkingLotTwo[i][k];
						}
						parkingLotTwo[i][0]=carNumber;
						isParking=true;
					}
				}
			}
		}

		else if(parkingLotFloor == 2 || parkingLotFloor == 3) {
			for(int i= 3; i>=0; i--) {
				if(isParking==false) {
					if(parkingLotOne[i][0] == EMPTY && i != parkingLotFloor ) {
						for(int j=0; j<3; j++) {
							parkingLotOne[i][j]=parkingLotOne[i][j+1];
						}
						parkingLotOne[i][3]=carNumber;
						isParking=true;
					}
					else if(parkingLotTwo[i][3] == EMPTY && i != parkingLotFloor) {
						for(int k=2; k>=0; k--) {
							parkingLotTwo[i][k+1]=parkingLotTwo[i][k];
						}
						parkingLotTwo[i][0]=carNumber;
						isParking=true;
					}
				}
			}
		}
	}

	/*
	 * 출차를 위한 함수
	 * parkingState가 "one" 또는 "two"일 경우로 분리
	 * 차량 출차를 위해 다른 차량을 이동시켜야 하는 경우일 때,
	 * 만일 이동시킬 자리(fullParkingLotOne과 fullParkingLotTwo로 판별)가 없다면 tempOutCar 배열에 이동할 차량을 순차적으로 저장 후 해당 차량을 출차. 이후 setIN()함수로 이동할 차량을 재 입차.
	 * 이동시킬 자리가 있다면 setMoveCar()함수를 통해서 최단 경로로 차량을 이동.
	 */
	public void setOut(String carNumber) {
		String tempCarNumber = null; // 출차 시 임시적으로 차량을 저장할 변수
		String[] tempOutCar = new String[4]; // 출차 시 이동해야할 차량의 자리가 없을 때 출차 시키고 임시적으로 차량을 저장할 배열
		int fullParkingLotOne; // 만차 여부
		int fullParkingLotTwo; // 만차 여부
		boolean isTempOutCar = false; // 임시적 차량 저장이 끝났는지 여부
		int tempCount = 0; // 임시적으로 저장하는 차량의 댓수 카운트
		setCarLocation(carNumber);
		if(parkingState.equals("one")){
			for(int i=0; i<4-carMoveCount; i++) {
				fullParkingLotOne = 0;
				fullParkingLotTwo = 0;
				for(int j=0; j<4; j++) {
					if(parkingLotOne[j][0]!=EMPTY) {
						fullParkingLotOne++;
					}
					if(parkingLotTwo[j][3]!=EMPTY) {
						fullParkingLotTwo++;
					}
				}
				if(i<3-carMoveCount) {
					if(fullParkingLotOne==3 && fullParkingLotTwo==4||fullParkingLotOne==4 && fullParkingLotTwo==4) {
						tempOutCar[tempCount]=parkingLotOne[parkingLotFloor][3];
						tempCount++;
					}
					else {
						tempCarNumber = parkingLotOne[parkingLotFloor][3];
						setMoveCar(tempCarNumber);
					}
				}
				for(int j=2; j>=0; j--) {
					parkingLotOne[parkingLotFloor][j+1] = parkingLotOne[parkingLotFloor][j];
				}
				parkingLotOne[parkingLotFloor][0] = EMPTY;
				
				if(i==2-carMoveCount&&tempCount!=0) {
					isTempOutCar=true;
				}
			}
			if(isTempOutCar==true) {
				for(int k=0; k<tempCount; k++) {
					setIn(tempOutCar[k]);
				}
			}
		}
		else if(parkingState.equals("two")) {
			for(int i=0; i<= carMoveCount; i++) {
				fullParkingLotOne = 0;
				fullParkingLotTwo = 0;
				for(int j=0; j<4; j++) {
					if(parkingLotOne[j][0]!=EMPTY) {
						fullParkingLotOne++;
					}
					if(parkingLotTwo[j][3]!=EMPTY) {
						fullParkingLotTwo++;
					}
				}
				if(i < carMoveCount) {
					if(fullParkingLotOne==4 && fullParkingLotTwo==3||fullParkingLotOne==4 && fullParkingLotTwo==4) {
						tempOutCar[tempCount]= parkingLotTwo[parkingLotFloor][0];
						tempCount++;
					}
					else {
						tempCarNumber = parkingLotTwo[parkingLotFloor][0];
						setMoveCar(tempCarNumber);
					}
				}
				for(int j=0; j<=2; j++) {
					parkingLotTwo[parkingLotFloor][j] = parkingLotTwo[parkingLotFloor][j+1];
				}
				parkingLotTwo[parkingLotFloor][3] = EMPTY;
				
				if(i==carMoveCount&&tempCount!=0) {
					isTempOutCar=true;
				}
			}
			if(isTempOutCar==true) {
				for(int k=0; k<tempCount; k++) {
					setIn(tempOutCar[k]);
				}
			}
		}
	}
}