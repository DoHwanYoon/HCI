package Parking;

public class ParkingLot {

	private String[][] parkingLotOne; // 1번 주차 배열 
	private String[][] parkingLotTwo; // 2번 주차 배열 
	
	public ParkingLot() {
		
		parkingLotOne = new String[4][4];
		parkingLotTwo = new String[4][4];
		
		for(int i=0; i<4; i++) { //주차장 배열 초기화 
			for(int j=0; j<4; j++) {
				parkingLotOne[i][j]="xxxx";
				parkingLotTwo[i][j]="xxxx";
			}
		}
	}
	
	public String[][] getParkingLotOne() {
		return this.parkingLotOne;
	}
	
	public void setParkingLotOne(String[][] parkingLotOne) {
		this.parkingLotOne = parkingLotOne;
	}
	
	public String[][] getParkingLotTwo() {
		return this.parkingLotTwo;
	}
	
	public void setParkingLotTwo(String[][] parkingLotTwo) {
		this.parkingLotTwo = parkingLotTwo;
	}
	
	public void showParkingLot() { // 주차장 출력 
		for(int i=0; i<4; i++) {
			System.out.print(" B"+(i+1)+" ");
			for(int j=0; j<4; j++) {
				System.out.print(" [ "+parkingLotOne[i][j]+" ] ");
			}System.out.print("|    |");
			for(int k=0; k<4; k++) {
				System.out.print(" [ "+parkingLotTwo[i][k]+" ] ");
			}System.out.println();
		}
	}
}
