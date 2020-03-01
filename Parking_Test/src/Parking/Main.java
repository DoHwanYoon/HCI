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
<<<<<<< HEAD
	public Scanner scan;
	public String carNumber;
	
	public Main() {
		scan = new Scanner(System.in);
		carNumber = null;
	}
	
	public void menu() {
	      //InOut inOut = new InOut();
	      ParkingLot parkingLot = new ParkingLot();
	      
	      boolean isRun = true;
	      
	      while(isRun) {
	    	 InOut inOut = new InOut();
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
=======
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
            System.out.println("1.�엯李�    2.異쒖감     3.二쇱감怨듦컙蹂닿린     4.醫낅즺");
            System.out.println();
            System.out.print("硫붾돱踰덊샇瑜� �엯�젰�븯�꽭�슂 : ");
            int sel = scan.nextInt();
            System.out.println();
            System.out.println("");
            
            switch(sel) {
            case 1:
              System.out.print("李⑤웾踰덊샇 4�옄由щ�� �엯�젰�븯�꽭�슂 : ");
                  carNumber = scan.next();
                  inOut.setParkingLotOne(parkingLot.getParkingLotOne());
                  inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
                  inOut.setIn(carNumber);
                  parkingLot.setParkingLotOne(inOut.getParkingLotOne());
                  parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
               System.out.println("二쇱감媛� �셿猷뚮릺�뿀�뒿�땲�떎. ");
               break;
                  
            case 2:
              System.out.print("李⑤웾踰덊샇 4�옄由щ�� �엯�젰�븯�꽭�슂 : ");
                carNumber = scan.next();
                  inOut.setParkingLotOne(parkingLot.getParkingLotOne());
                  inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
               inOut.setOut(carNumber);
                  parkingLot.setParkingLotOne(inOut.getParkingLotOne());
                  parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
               System.out.println("異쒖감媛� �셿猷뚮릺�뿀�뒿�땲�떎. ");
               break;
               
            case 3:
               parkingLot.showParkingLot();
               break;
               
            case 4:
               isRun = false;
               System.out.println("�봽濡쒓렇�옩�쓣 醫낅즺�빀�땲�떎.");
               break;
            }
         }
   }
   
   public static void main(String[] args) {
      Main main = new Main();
      main.menu();
   }
}

// xml 援ъ“ �솗�씤
// �뙆�떛 媛쒕뀗 �솗�씤 
>>>>>>> 094ee3a87aac10fc2690e2a0a5733dc27d74eb82
