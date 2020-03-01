package Parking;

import java.util.Scanner;

/* ÁÖÂ÷ÇÁ·Î±×·¥
 * 4x4 ¹è¿­ µÎ °³ÀÇ ÁÖÂ÷°ø°£ÀÌ ÀÖ°í, °¢ ÃþÀº ÄÁº£ÀÌ¾îº§Æ® ±¸Á¶·Î ¿òÁ÷ÀÎ´Ù. 
 * ÁÖÂ÷°ø°£ÀÇ ¹èÄ¡´Â ÇÁ·Î±×·¥ ½ÇÇà ÈÄ 3¹ø ¸Þ´º¸¦ È®ÀÎÇÏ¸é µÈ´Ù.
 * ÄÁº£ÀÌ¾î º§Æ® ±¸Á¶´Â ¼øÈ¯µÇ´Â ±¸Á¶°¡ ¾Æ´Ï¸ç (0,0) (0,1) (0,2) (0,3) ÀÏ °æ¿ì,
 * (0,2)À§Ä¡ÀÇ Â÷·®À» ÃâÂ÷ÇÏ±â À§ÇØ¼­´Â (0,3)À§Ä¡ÀÇ Â÷·®À» ¸ÕÀú ÃâÂ÷ÇÑ ÈÄ °¡Àå ÃÖ´Ü°Å¸®ÀÇ ºñ¾îÀÖ´Â ÁÖÂ÷°ø°£¿¡ ÁÖÂ÷½ÃÅ² ÈÄ (0,2)Â÷·®À» ÃâÂ÷ÇÑ´Ù. 
 * ÀÔÂ÷´Â ÃÖ´Ü°Å¸®, ³»¸²Â÷¼øÀ¸·Î ÁÖÂ÷½ÃÅ²´Ù.
 * µ¥ÀÌÅÍ¿Í UI´Â °¢°¢ÀÇ Å¬·¡½º·Î ºÐ¸®½ÃÅ²´Ù. 
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
	         System.out.println("1.ÀÔÂ÷    2.ÃâÂ÷     3.ÁÖÂ÷°ø°£º¸±â     4.Á¾·á");
	         System.out.println();
	         System.out.print("¸Þ´º¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
	         int sel = scan.nextInt();
	         System.out.println();
	         System.out.println("");
	         switch(sel) {
	         case 1:
	        	System.out.print("Â÷·®¹øÈ£ 4ÀÚ¸®¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
	   	      	carNumber = scan.next();
	   	      	inOut.setParkingLotOne(parkingLot.getParkingLotOne());
	   	      	inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
	   	      	inOut.setIn(carNumber);
	   	      	parkingLot.setParkingLotOne(inOut.getParkingLotOne());
	   	      	parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
	            System.out.println("ÁÖÂ÷°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù. ");
	            break;
	               
	         case 2:
		        System.out.print("Â÷·®¹øÈ£ 4ÀÚ¸®¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
		   	    carNumber = scan.next();
	   	      	inOut.setParkingLotOne(parkingLot.getParkingLotOne());
	   	      	inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
	            inOut.setOut(carNumber);
	   	      	parkingLot.setParkingLotOne(inOut.getParkingLotOne());
	   	      	parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
	            System.out.println("ÃâÂ÷°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù. ");
	            break;
	            
	         case 3:
	            parkingLot.showParkingLot();
	            break;
	            
	         case 4:
	            isRun = false;
	            System.out.println("ÇÁ·Î±×·¥À» Á¾·áÇÕ´Ï´Ù.");
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
            System.out.println("1.ìž…ì°¨    2.ì¶œì°¨     3.ì£¼ì°¨ê³µê°„ë³´ê¸°     4.ì¢…ë£Œ");
            System.out.println();
            System.out.print("ë©”ë‰´ë²ˆí˜¸ë¥¼ ìž…ë ¥í•˜ì„¸ìš” : ");
            int sel = scan.nextInt();
            System.out.println();
            System.out.println("");
            
            switch(sel) {
            case 1:
              System.out.print("ì°¨ëŸ‰ë²ˆí˜¸ 4ìžë¦¬ë¥¼ ìž…ë ¥í•˜ì„¸ìš” : ");
                  carNumber = scan.next();
                  inOut.setParkingLotOne(parkingLot.getParkingLotOne());
                  inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
                  inOut.setIn(carNumber);
                  parkingLot.setParkingLotOne(inOut.getParkingLotOne());
                  parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
               System.out.println("ì£¼ì°¨ê°€ ì™„ë£Œë˜ì—ˆìŠµë‹ˆë‹¤. ");
               break;
                  
            case 2:
              System.out.print("ì°¨ëŸ‰ë²ˆí˜¸ 4ìžë¦¬ë¥¼ ìž…ë ¥í•˜ì„¸ìš” : ");
                carNumber = scan.next();
                  inOut.setParkingLotOne(parkingLot.getParkingLotOne());
                  inOut.setParkingLotTwo(parkingLot.getParkingLotTwo());
               inOut.setOut(carNumber);
                  parkingLot.setParkingLotOne(inOut.getParkingLotOne());
                  parkingLot.setParkingLotTwo(inOut.getParkingLotTwo());
               System.out.println("ì¶œì°¨ê°€ ì™„ë£Œë˜ì—ˆìŠµë‹ˆë‹¤. ");
               break;
               
            case 3:
               parkingLot.showParkingLot();
               break;
               
            case 4:
               isRun = false;
               System.out.println("í”„ë¡œê·¸ëž¨ì„ ì¢…ë£Œí•©ë‹ˆë‹¤.");
               break;
            }
         }
   }
   
   public static void main(String[] args) {
      Main main = new Main();
      main.menu();
   }
}

// xml êµ¬ì¡° í™•ì¸
// íŒŒì‹± ê°œë… í™•ì¸ 
>>>>>>> 094ee3a87aac10fc2690e2a0a5733dc27d74eb82
