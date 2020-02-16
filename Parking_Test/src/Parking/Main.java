package Parking;

import java.util.Scanner;

public class Main {
	Scanner scan;
	InOut inOut;
	String carNumber;
	
	public Main() {
		scan = new Scanner(System.in);
		inOut = new InOut();
		carNumber = null;
	}
	
	void menu() {
	      //InOut InOut = new InOut();
	      
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
	            //inputCarNumber();
	        	System.out.print("차량번호 4자리를 입력하세요 : ");
	   	      	carNumber = scan.next();
	            inOut.In(carNumber);
	            break;
	               
	         case 2:
	            //inputCarNumber();
		        System.out.print("차량번호 4자리를 입력하세요 : ");
		   	    carNumber = scan.next();
	            inOut.Out(carNumber);
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


// 클래스에 속성 추가해주기 -
// 함수 리턴값 지정해주기
// UI와 데이터 하나의 클래스로 합치기 -
// 근접한 자리로 차량이동 가능하게 기능 추가하기
// in, out 클래스 분리시켜보기 
// xml 구조 확인
// 파싱 개념 확인 
