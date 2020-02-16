package Parking;

import java.util.Scanner;

public class Main {
	public Scanner scan;
	public String carNumber;
	
	public Main() {
		scan = new Scanner(System.in);
		carNumber = null;
	}
	
	void menu() {
	      InOut inOut = new InOut();
	      
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
	            inOut.setIn(carNumber);
	            System.out.println("주차가 완료되었습니다. ");
	            break;
	               
	         case 2:
		        System.out.print("차량번호 4자리를 입력하세요 : ");
		   	    carNumber = scan.next();
	            inOut.setOut(carNumber);
	            System.out.println("출차가 완료되었습니다. ");
	            break;
	            
	         case 3:
	            inOut.parkingLot.showParkingLot();
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
