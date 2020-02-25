package Parking;

import java.util.Scanner;

/* 주차프로그램
 * 4x4 배열 두 개의 주차공간이 있고, 각 층은 컨베이어벨트 구조로 움직인다. 
 * 주차공간의 배치는 프로그램 실행 후 3번 메뉴를 확인하면 된다.
 * 컨베이어 벨트 구조는 순환되는 구조가 아니며 (0,0) (0,1) (0,2) (0,3) 일 경우,
 * (0,2)위치의 차량을 출차하기 위해서는 (0,3)위치의 차량을 먼저 출차한 후 가장 최단거리의 비어있는 주차공간에 주차시킨 후 (0,2)차량을 출차한다. 
 * 입차는 최단거리, 내림차순으로 주차시킨다.
 * 데이터와 UI는 각각의 클래스로 분리시킨다. 
*/

public class Main {
   public Scanner scan;
   public String carNumber;
   
   public Main() {
      scan = new Scanner(System.in);
      carNumber = null;
   }
   
   void menu() {
         InOut inOut = new InOut();
         ParkingLot parkingLot = new ParkingLot();
         
         boolean isRun = true;
         
         while(isRun) {
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println();
            System.out.println("1.입차    2.출차     3.주차공간보기     4.종료");
            System.out.println();
            System.out.print("메뉴번호를 입력하세요 : ");
            int sel = scan.nextInt();
            System.out.println();
            System.out.println("");
            
            switch(sel) {
            case 1:
              System.out.print("차량번호 4자리를 입력하세요 : ");
                  carNumber = scan.next();
                  inOut.setParkingLotOne(parkingLot.getParkingLotOne());
                  inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
                  inOut.setIn(carNumber);
                  parkingLot.setParkingLotOne(inOut.getParkingLotOne());
                  parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
               System.out.println("주차가 완료되었습니다. ");
               break;
                  
            case 2:
              System.out.print("차량번호 4자리를 입력하세요 : ");
                carNumber = scan.next();
                  inOut.setParkingLotOne(parkingLot.getParkingLotOne());
                  inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
               inOut.setOut(carNumber);
                  parkingLot.setParkingLotOne(inOut.getParkingLotOne());
                  parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
               System.out.println("출차가 완료되었습니다. ");
               break;
               
            case 3:
               parkingLot.showParkingLot();
               break;
               
            case 4:
               isRun = false;
               System.out.println("프로그램을 종료합니다.");
               break;
            }
         }
   }
   
   public static void main(String[] args) {
      Main main = new Main();
      main.menu();
   }
}

// xml 구조 확인
// 파싱 개념 확인 