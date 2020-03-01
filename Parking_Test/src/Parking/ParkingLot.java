package Parking;

public class ParkingLot {

	private final String EMPTY = "xxxx";
	private String[][] parkingLotOne; // 1번 주차 배열 
	private String[][] parkingLotTwo; // 2번 주차 배열 
	
	public ParkingLot() {
		
		parkingLotOne = new String[4][4];
		parkingLotTwo = new String[4][4];
		
		for(int i=0; i<4; i++) { //주차장 배열 초기화 
			for(int j=0; j<3; j++) {
				parkingLotOne[i][j]=EMPTY;
				parkingLotTwo[i][j]=EMPTY;
			}
		}
		
		/*test용
		parkingLotOne[0][0] = "1111";
		parkingLotOne[0][1] = "2222";
		parkingLotOne[0][2] = "3333";
		parkingLotOne[0][3] = "4444";
		parkingLotOne[1][0] = "5555";
		parkingLotOne[1][1] = "6666";
		parkingLotOne[1][2] = "7777";
		parkingLotOne[1][3] = "8888";
		parkingLotOne[2][0] = "1212";
		parkingLotOne[2][1] = "2121";
		parkingLotOne[2][2] = "2323";
		parkingLotOne[2][3] = "3232";
		
		parkingLotTwo[0][0] = "3434";
		parkingLotTwo[0][1] = "4343";
		parkingLotTwo[0][2] = "4545";
		parkingLotTwo[0][3] = "5454";
		parkingLotTwo[1][0] = "5656";
		parkingLotTwo[1][1] = "6565";
		parkingLotTwo[1][2] = "6767";
		parkingLotTwo[1][3] = "7676";
		parkingLotTwo[2][0] = "7878";
		parkingLotTwo[2][1] = "8787";
		parkingLotTwo[2][2] = "8989";
		parkingLotTwo[2][3] = "9898";
		
		for(int i=0; i<4; i++) {
			parkingLotOne[3][i]=EMPTY;
			parkingLotTwo[3][i]=EMPTY;
		}*/
	}
	
	public String[][] getParkingLotOne() {
		return this.parkingLotOne;
	}
		
	public String[][] getParkingLotTwo() {
		return this.parkingLotTwo;
	}
	
	public void setParkingLotOne(String[][] parkingLotOne) {
		this.parkingLotOne = parkingLotOne;
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
