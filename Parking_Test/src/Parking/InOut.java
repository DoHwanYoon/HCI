package Parking;

public class InOut {
   
   private int parkingLotFloor; //출차할 차량의 층
   private int carMoveCount; //출차할 차량이 움직여야 하는 횟수
   private String parkingState; //출차할 차량의 배열 위치 
   private String[][] parkingLotOne; // 1번 주차 배열 
   private String[][] parkingLotTwo; // 2번 주차 배열    
   
   public InOut() {
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
   
   public void setIn(String carNumber) {   // 입차를 위한 함수. 
      boolean isParking = false;
      for(int i=0; i<4; i++) {
         if(isParking==false) {
            if(parkingLotOne[i][0] == "xxxx") {
               for(int j=0; j<3; j++) {
                  parkingLotOne[i][j]=parkingLotOne[i][j+1];
               }
               parkingLotOne[i][3]=carNumber;
               isParking=true;
            }
            else if(parkingLotTwo[i][3] == "xxxx") {
               for(int k=2; k>=0; k--) {
                  parkingLotTwo[i][k+1]=parkingLotTwo[i][k];
               }
               parkingLotTwo[i][0]=carNumber;
               isParking=true;
            }
         }else break;
      }
   }
   
   /* 출차 시 이동이 필요한 차량을 재 주차시키는 함수.
    *  출차할 차량의 parkingState가 "one" 일 때 같은층의 parkingStateTwo에 빈자리가 있다면 주차.
    *  출차할 차량의 parkingState가 two" 일 때 같은층의 parkingStateOne에 빈자리가 있다면 주차.
    *  출차할 차량의 parkingLotFloor가 1층 또는 2층일 경우 parkingLotFloor를 제외하고 내림차순으로 주차자리 탐색 후 주차.
    *  출차할 차량의 parkingLotFloor가 3층 또는 4층일 경우 parkingLotFloor를 제외하고 오름차순으로 주차자리 탐색 후 주차.
    */
   public void setMoveCar(String carNumber) {
      boolean isParking = false;
      
      if(parkingState=="one" && parkingLotTwo[parkingLotFloor][3]=="xxxx") {
         for(int k=2; k>=0; k--) {
            parkingLotTwo[parkingLotFloor][k+1]=parkingLotTwo[parkingLotFloor][k];
         }
         parkingLotTwo[parkingLotFloor][0]=carNumber;
      }
      
      else if(parkingState=="two" && parkingLotOne[parkingLotFloor][0] == "xxxx") {
         for(int j=0; j<3; j++) {
            parkingLotOne[parkingLotFloor][j]=parkingLotOne[parkingLotFloor][j+1];
         }
         parkingLotOne[parkingLotFloor][3]=carNumber;
      }

      else if(parkingLotFloor == 0 || parkingLotFloor == 1) {
         for(int i = 0; i<=3; i++) {
            if(isParking==false) {
               if(parkingLotOne[i][0] == "xxxx" && i != parkingLotFloor ) {
                  for(int j=0; j<3; j++) {
                     parkingLotOne[i][j]=parkingLotOne[i][j+1];
                  }
                  parkingLotOne[i][3]=carNumber;
                  isParking=true;
               }
               else if(parkingLotTwo[i][3] == "xxxx" && i != parkingLotFloor) {
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
               if(parkingLotOne[i][0] == "xxxx" && i != parkingLotFloor ) {
                  for(int j=0; j<3; j++) {
                     parkingLotOne[i][j]=parkingLotOne[i][j+1];
                  }
                  parkingLotOne[i][3]=carNumber;
                  isParking=true;
               }
               else if(parkingLotTwo[i][3] == "xxxx" && i != parkingLotFloor) {
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

   public void setOut(String carNumber) {   // 출차를 위한 함수.
      String tempCarNumber = null;
      setCarLocation(carNumber);
      if(parkingState.equals("one")){
         for(int i=0; i<4-carMoveCount; i++) {
            if(i<3-carMoveCount) {      
               tempCarNumber = parkingLotOne[parkingLotFloor][3];
               setMoveCar(tempCarNumber);
            }
            for(int j=2; j>=0; j--) {
               parkingLotOne[parkingLotFloor][j+1] = parkingLotOne[parkingLotFloor][j];
            }
            parkingLotOne[parkingLotFloor][0] = "xxxx";
         }
      }
      else if(parkingState.equals("two")) {
         for(int i=0; i<= carMoveCount; i++) {
            if(i < carMoveCount) {
               tempCarNumber = parkingLotTwo[parkingLotFloor][0];
               setMoveCar(tempCarNumber);
            }
            for(int j=0; j<=2; j++) {
               parkingLotTwo[parkingLotFloor][j] = parkingLotTwo[parkingLotFloor][j+1];
            }
            parkingLotTwo[parkingLotFloor][3] = "xxxx";
         }
      }
   }
}