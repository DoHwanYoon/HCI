package Parking;

public class InOut {
	
	private final String EMPTY = "xxxx";
	private int parkingLotFloor; //������ ������ ��
	private int carMoveCount; //������ ������ �������� �ϴ� Ƚ��
	//private String[] tempOutCar; //������ �̵��� ������ ���� ��� �ӽ������� �����Ͽ� ������ ���� �迭 
	private String parkingState; //������ ������ �迭 ��ġ 
	private String[][] parkingLotOne; // 1�� ���� �迭 
	private String[][] parkingLotTwo; // 2�� ���� �迭 	
	
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
	
	public void setIn(String carNumber) {	// ������ ���� �Լ�. 
		boolean isParking = false; // ���� �Ϸ� ���� 
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
	
	// ���� �ϰ��� �ϴ� ������ parkingState(�迭��ġ), parkingLotFloor(������ ��)�� carMoveCount(������ ���� ���������ϴ� Ƚ��)���� ����.
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
	
	/* ���� �� �̵��� �ʿ��� ������ �� ������Ű�� �Լ�.
	 *  ������ ������ parkingState�� "one" �� �� �������� parkingStateTwo�� ���ڸ��� �ִٸ� ����.
	 *  ������ ������ parkingState�� two" �� �� �������� parkingStateOne�� ���ڸ��� �ִٸ� ����.
	 *  ������ ������ parkingLotFloor�� 1�� �Ǵ� 2���� ��� parkingLotFloor�� �����ϰ� ������������ �����ڸ� Ž�� �� ����.
	 *  ������ ������ parkingLotFloor�� 3�� �Ǵ� 4���� ��� parkingLotFloor�� �����ϰ� ������������ �����ڸ� Ž�� �� ����.
	 */
	public void setMoveCar(String carNumber) {
		boolean isParking = false; // ���� �Ϸ� ����
		
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
	 * ������ ���� �Լ�
	 * parkingState�� "one" �Ǵ� "two"�� ���� �и�
	 * ���� ������ ���� �ٸ� ������ �̵����Ѿ� �ϴ� ����� ��,
	 * ���� �̵���ų �ڸ�(fullParkingLotOne�� fullParkingLotTwo�� �Ǻ�)�� ���ٸ� tempOutCar �迭�� �̵��� ������ ���������� ���� �� �ش� ������ ����. ���� setIN()�Լ��� �̵��� ������ �� ����.
	 * �̵���ų �ڸ��� �ִٸ� setMoveCar()�Լ��� ���ؼ� �ִ� ��η� ������ �̵�.
	 */
	public void setOut(String carNumber) {
		String tempCarNumber = null; // ���� �� �ӽ������� ������ ������ ����
		String[] tempOutCar = new String[4]; // ���� �� �̵��ؾ��� ������ �ڸ��� ���� �� ���� ��Ű�� �ӽ������� ������ ������ �迭
		int fullParkingLotOne; // ���� ����
		int fullParkingLotTwo; // ���� ����
		boolean isTempOutCar = false; // �ӽ��� ���� ������ �������� ����
		int tempCount = 0; // �ӽ������� �����ϴ� ������ ��� ī��Ʈ
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