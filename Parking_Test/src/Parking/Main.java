package Parking;

import java.util.Scanner;

/* �������α׷�
 * 4x4 �迭 �� ���� ���������� �ְ�, �� ���� �����̾Ʈ ������ �����δ�. 
 * ���������� ��ġ�� ���α׷� ���� �� 3�� �޴��� Ȯ���ϸ� �ȴ�.
 * �����̾� ��Ʈ ������ ��ȯ�Ǵ� ������ �ƴϸ� (0,0) (0,1) (0,2) (0,3) �� ���,
 * (0,2)��ġ�� ������ �����ϱ� ���ؼ��� (0,3)��ġ�� ������ ���� ������ �� ���� �ִܰŸ��� ����ִ� ���������� ������Ų �� (0,2)������ �����Ѵ�. 
 * ������ �ִܰŸ�, ������������ ������Ų��.
 * �����Ϳ� UI�� ������ Ŭ������ �и���Ų��. 
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
	         System.out.println("1.����    2.����     3.������������     4.����");
	         System.out.println();
	         System.out.print("�޴���ȣ�� �Է��ϼ��� : ");
	         int sel = scan.nextInt();
	         System.out.println();
	         System.out.println("");
	         switch(sel) {
	         case 1:
	        	System.out.print("������ȣ 4�ڸ��� �Է��ϼ��� : ");
	   	      	carNumber = scan.next();
	   	      	inOut.setParkingLotOne(parkingLot.getParkingLotOne());
	   	      	inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
	   	      	inOut.setIn(carNumber);
	   	      	parkingLot.setParkingLotOne(inOut.getParkingLotOne());
	   	      	parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
	            System.out.println("������ �Ϸ�Ǿ����ϴ�. ");
	            break;
	               
	         case 2:
		        System.out.print("������ȣ 4�ڸ��� �Է��ϼ��� : ");
		   	    carNumber = scan.next();
	   	      	inOut.setParkingLotOne(parkingLot.getParkingLotOne());
	   	      	inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
	            inOut.setOut(carNumber);
	   	      	parkingLot.setParkingLotOne(inOut.getParkingLotOne());
	   	      	parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
	            System.out.println("������ �Ϸ�Ǿ����ϴ�. ");
	            break;
	            
	         case 3:
	            parkingLot.showParkingLot();
	            break;
	            
	         case 4:
	            isRun = false;
	            System.out.println("���α׷��� �����մϴ�.");
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
>>>>>>> 094ee3a87aac10fc2690e2a0a5733dc27d74eb82
