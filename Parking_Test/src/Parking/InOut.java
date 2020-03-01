package Parking;

public class InOut {
<<<<<<< HEAD
	
	private final String EMPTY = "xxxx";
	private int parkingLotFloor; //ÃâÂ÷ÇÒ Â÷·®ÀÇ Ãş
	private int carMoveCount; //ÃâÂ÷ÇÒ Â÷·®ÀÌ ¿òÁ÷¿©¾ß ÇÏ´Â È½¼ö
	//private String[] tempOutCar; //Â÷·®À» ÀÌµ¿ÇÒ °ø°£ÀÌ ¾øÀ» °æ¿ì ÀÓ½ÃÀûÀ¸·Î ÃâÂ÷ÇÏ¿© ÀúÀåÇÒ ÁÖÂ÷ ¹è¿­ 
	private String parkingState; //ÃâÂ÷ÇÒ Â÷·®ÀÇ ¹è¿­ À§Ä¡ 
	private String[][] parkingLotOne; // 1¹ø ÁÖÂ÷ ¹è¿­ 
	private String[][] parkingLotTwo; // 2¹ø ÁÖÂ÷ ¹è¿­ 	
	
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
	
	public void setIn(String carNumber) {	// ÀÔÂ÷¸¦ À§ÇÑ ÇÔ¼ö. 
		boolean isParking = false; // ÁÖÂ÷ ¿Ï·á ¿©ºÎ 
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
	
	// ÃâÂ÷ ÇÏ°íÀÚ ÇÏ´Â Â÷·®ÀÇ parkingState(¹è¿­À§Ä¡), parkingLotFloor(Â÷·®ÀÇ Ãş)¿Í carMoveCount(ÃâÂ÷¸¦ À§ÇØ ¿òÁ÷¿©¾ßÇÏ´Â È½¼ö)°ªÀ» ¼¼ÆÃ.
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
	
	/* ÃâÂ÷ ½Ã ÀÌµ¿ÀÌ ÇÊ¿äÇÑ Â÷·®À» Àç ÁÖÂ÷½ÃÅ°´Â ÇÔ¼ö.
	 *  ÃâÂ÷ÇÒ Â÷·®ÀÇ parkingState°¡ "one" ÀÏ ¶§ °°ÀºÃşÀÇ parkingStateTwo¿¡ ºóÀÚ¸®°¡ ÀÖ´Ù¸é ÁÖÂ÷.
	 *  ÃâÂ÷ÇÒ Â÷·®ÀÇ parkingState°¡ two" ÀÏ ¶§ °°ÀºÃşÀÇ parkingStateOne¿¡ ºóÀÚ¸®°¡ ÀÖ´Ù¸é ÁÖÂ÷.
	 *  ÃâÂ÷ÇÒ Â÷·®ÀÇ parkingLotFloor°¡ 1Ãş ¶Ç´Â 2ÃşÀÏ °æ¿ì parkingLotFloor¸¦ Á¦¿ÜÇÏ°í ³»¸²Â÷¼øÀ¸·Î ÁÖÂ÷ÀÚ¸® Å½»ö ÈÄ ÁÖÂ÷.
	 *  ÃâÂ÷ÇÒ Â÷·®ÀÇ parkingLotFloor°¡ 3Ãş ¶Ç´Â 4ÃşÀÏ °æ¿ì parkingLotFloor¸¦ Á¦¿ÜÇÏ°í ¿À¸§Â÷¼øÀ¸·Î ÁÖÂ÷ÀÚ¸® Å½»ö ÈÄ ÁÖÂ÷.
	 */
	public void setMoveCar(String carNumber) {
		boolean isParking = false; // ÁÖÂ÷ ¿Ï·á ¿©ºÎ
		
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
	 * ÃâÂ÷¸¦ À§ÇÑ ÇÔ¼ö
	 * parkingState°¡ "one" ¶Ç´Â "two"ÀÏ °æ¿ì·Î ºĞ¸®
	 * Â÷·® ÃâÂ÷¸¦ À§ÇØ ´Ù¸¥ Â÷·®À» ÀÌµ¿½ÃÄÑ¾ß ÇÏ´Â °æ¿ìÀÏ ¶§,
	 * ¸¸ÀÏ ÀÌµ¿½ÃÅ³ ÀÚ¸®(fullParkingLotOne°ú fullParkingLotTwo·Î ÆÇº°)°¡ ¾ø´Ù¸é tempOutCar ¹è¿­¿¡ ÀÌµ¿ÇÒ Â÷·®À» ¼øÂ÷ÀûÀ¸·Î ÀúÀå ÈÄ ÇØ´ç Â÷·®À» ÃâÂ÷. ÀÌÈÄ setIN()ÇÔ¼ö·Î ÀÌµ¿ÇÒ Â÷·®À» Àç ÀÔÂ÷.
	 * ÀÌµ¿½ÃÅ³ ÀÚ¸®°¡ ÀÖ´Ù¸é setMoveCar()ÇÔ¼ö¸¦ ÅëÇØ¼­ ÃÖ´Ü °æ·Î·Î Â÷·®À» ÀÌµ¿.
	 */
	public void setOut(String carNumber) {
		String tempCarNumber = null; // ÃâÂ÷ ½Ã ÀÓ½ÃÀûÀ¸·Î Â÷·®À» ÀúÀåÇÒ º¯¼ö
		String[] tempOutCar = new String[4]; // ÃâÂ÷ ½Ã ÀÌµ¿ÇØ¾ßÇÒ Â÷·®ÀÇ ÀÚ¸®°¡ ¾øÀ» ¶§ ÃâÂ÷ ½ÃÅ°°í ÀÓ½ÃÀûÀ¸·Î Â÷·®À» ÀúÀåÇÒ ¹è¿­
		int fullParkingLotOne; // ¸¸Â÷ ¿©ºÎ
		int fullParkingLotTwo; // ¸¸Â÷ ¿©ºÎ
		boolean isTempOutCar = false; // ÀÓ½ÃÀû Â÷·® ÀúÀåÀÌ ³¡³µ´ÂÁö ¿©ºÎ
		int tempCount = 0; // ÀÓ½ÃÀûÀ¸·Î ÀúÀåÇÏ´Â Â÷·®ÀÇ ´ñ¼ö Ä«¿îÆ®
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
=======
   
   private int parkingLotFloor; //ì¶œì°¨í•  ì°¨ëŸ‰ì˜ ì¸µ
   private int carMoveCount; //ì¶œì°¨í•  ì°¨ëŸ‰ì´ ì›€ì§ì—¬ì•¼ í•˜ëŠ” íšŸìˆ˜
   private String parkingState; //ì¶œì°¨í•  ì°¨ëŸ‰ì˜ ë°°ì—´ ìœ„ì¹˜ 
   private String[][] parkingLotOne; // 1ë²ˆ ì£¼ì°¨ ë°°ì—´ 
   private String[][] parkingLotTwo; // 2ë²ˆ ì£¼ì°¨ ë°°ì—´    
   
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
   
   // ì¶œì°¨ í•˜ê³ ì í•˜ëŠ” ì°¨ëŸ‰ì˜ parkingState(ë°°ì—´ìœ„ì¹˜), parkingLotFloor(ì°¨ëŸ‰ì˜ ì¸µ)ì™€ carMoveCount(ì¶œì°¨ë¥¼ ìœ„í•´ ì›€ì§ì—¬ì•¼í•˜ëŠ” íšŸìˆ˜)ê°’ì„ ì„¸íŒ….
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
   
   public void setIn(String carNumber) {   // ì…ì°¨ë¥¼ ìœ„í•œ í•¨ìˆ˜. 
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
   
   /* ì¶œì°¨ ì‹œ ì´ë™ì´ í•„ìš”í•œ ì°¨ëŸ‰ì„ ì¬ ì£¼ì°¨ì‹œí‚¤ëŠ” í•¨ìˆ˜.
    *  ì¶œì°¨í•  ì°¨ëŸ‰ì˜ parkingStateê°€ "one" ì¼ ë•Œ ê°™ì€ì¸µì˜ parkingStateTwoì— ë¹ˆìë¦¬ê°€ ìˆë‹¤ë©´ ì£¼ì°¨.
    *  ì¶œì°¨í•  ì°¨ëŸ‰ì˜ parkingStateê°€ two" ì¼ ë•Œ ê°™ì€ì¸µì˜ parkingStateOneì— ë¹ˆìë¦¬ê°€ ìˆë‹¤ë©´ ì£¼ì°¨.
    *  ì¶œì°¨í•  ì°¨ëŸ‰ì˜ parkingLotFloorê°€ 1ì¸µ ë˜ëŠ” 2ì¸µì¼ ê²½ìš° parkingLotFloorë¥¼ ì œì™¸í•˜ê³  ë‚´ë¦¼ì°¨ìˆœìœ¼ë¡œ ì£¼ì°¨ìë¦¬ íƒìƒ‰ í›„ ì£¼ì°¨.
    *  ì¶œì°¨í•  ì°¨ëŸ‰ì˜ parkingLotFloorê°€ 3ì¸µ ë˜ëŠ” 4ì¸µì¼ ê²½ìš° parkingLotFloorë¥¼ ì œì™¸í•˜ê³  ì˜¤ë¦„ì°¨ìˆœìœ¼ë¡œ ì£¼ì°¨ìë¦¬ íƒìƒ‰ í›„ ì£¼ì°¨.
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

   public void setOut(String carNumber) {   // ì¶œì°¨ë¥¼ ìœ„í•œ í•¨ìˆ˜.
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
>>>>>>> 094ee3a87aac10fc2690e2a0a5733dc27d74eb82
}