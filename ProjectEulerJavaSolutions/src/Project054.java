
public class Project054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(checkFlush("AC KC 9C JC TC"));
		int[] test = handEval("AC 2C 7C JC TH");
		
	}

	// 29 royal flush - check
	// 28 straight flush - check
	// 27 four kind - check
	// 26 full house - check
	// 25 flush - check
	// 24 straight - check
	// 23 3 kind - check
	// 22 two pair - check
	// 21 one pair - check
	// 20 high card - check
	public static int[] handEval(String A) {
		// return [cat from above, next high cards]
		// check for flush
		String backup = A;
		int[] ret;
		if (checkFlush(A)) {
			A = backup;
			if (checkStraight(A)) {
				A = backup;
				if(getHighCard(A) == 14) {
					//has royal flush (beats everything)
					ret = new int[]{29};
					return ret;
				}
				//has straight flush(code, then high card)
				ret = new int[] {28, getHighCard(A)};
				return ret;
			}
			//has a normal flush
			ret = new int[6];
			ret[0] = 25; //code for flush
			for(int i = 1; i < 6; i++) {
				ret[i] = getHighCard(A);
				//System.out.println(getHighCard(A) + "at pos: "+ i);
				int tempInd = getCardPos(ret[i], A);
				if(i != 5) {
					A = swap(A, tempInd);
				}
			}
			return ret;
			
		}
		char fourKindCheck = checkFourKind(A);
		if(fourKindCheck != '0') {
			//user has four of a kind
			for(int i = 0; i < A.length(); i = i + 3) {
				if(A.charAt(i) == fourKindCheck) {
					A = swap(A,i);
				}
			}
			int temp = getHighCard(A);
			ret = new int[3];
			ret[0] = 27; //code for 4kind
			ret[1] = charToNum(fourKindCheck); //what four kind
			ret[2] = temp; //remaining highcard
			return ret;
		}
		if(checkStraight(A)) {
			//user has a straight
			int temp = getHighCard(A);
			ret = new int[2];
			ret[0] = 24; //code for straight
			ret[1] = temp; //the high card for the straight
			return ret;
		}
		char threePairCheck = checkThreePair(A);
		if(threePairCheck != '0') {
			//user has four of a kind
			for(int i = 0; i < A.length(); i = i + 3) {
				if(A.charAt(i) == threePairCheck) {
					A = swap(A,i);
				}
			}
			//check two pair
			char singlePairCheck = checkSinglePair(A);
			if(singlePairCheck != '0') {
				//user has a full house
				ret = new int[3];
				ret[0] = 26; //code for full house
				ret[1] = charToNum(threePairCheck); //num three pair
				ret[2] = charToNum(singlePairCheck); //num single pair
				return ret;
			}
			int temp = getHighCard(A);
			ret = new int[3];
			ret[0] = 23; //code for 3kind
			ret[1] = temp; //remaining highcard 1
			A = swap(A, getCardPos(temp,A));
			ret[2] = getHighCard(A); //remaing highcard 2
			return ret;
		}
		//two pair and one pair left
		char singlePairCheck = checkSinglePair(A);
		if(singlePairCheck != '0') {
			for(int i = 0; i < A.length(); i++) {
				if(A.charAt(i) == singlePairCheck) {
					A = swap(A,i);
				}
			}
			char secondPairCheck = checkSinglePair(A);
			if(secondPairCheck != '0') {
				//user has two pair
				for(int i = 0; i < A.length(); i++) {
					if(A.charAt(i) == secondPairCheck) {
						A = swap(A,i);
					}
				}
				ret = new int[4];
				ret[0] = 22; //code for two pair
				//get higher of two pair
				ret[1] = Math.max(charToNum(singlePairCheck), charToNum(secondPairCheck));
				//get lower of two pair
				ret[2] = Math.min(charToNum(singlePairCheck), charToNum(secondPairCheck));
				ret[3] = getHighCard(A); //gets remaing highcard
				return ret;
			}
			//user has a single pair
			ret = new int[5];
			ret[0] = 21; //code for one pair
			ret[1] = charToNum(singlePairCheck);
			ret[2] = getHighCard(A); //get first HC
			A = swap(A,getCardPos(ret[2],A)); //replace HC
			ret[3] = getHighCard(A); //second HC
			A = swap(A,getCardPos(ret[3],A)); //replace HC
			ret[4] = getHighCard(A); //final HC
			return ret;	
		}
		//user just has highcards
		A = backup; //just incase i screwed up
		ret = new int[6];
		ret[0] = 20; //code for nada
		ret[1] = getHighCard(A);//1 HC
		A = swap(A,getCardPos(ret[1],A));
		ret[2] = getHighCard(A); //2HC
		A = swap(A,getCardPos(ret[2],A));
		ret[3] = getHighCard(A);
		A = swap(A,getCardPos(ret[3],A));
		ret[4] = getHighCard(A);
		A = swap(A,getCardPos(ret[4],A));
		ret[5] = getHighCard(A);
		return ret;
	}
	public static boolean checkFlush(String A) {
		//check for a flush
		boolean flushCheck = true;
		for (int i = 4; i < A.length(); i = i + 3) {
			if (A.charAt(1) != A.charAt(i)) {
				flushCheck = false;
				break;
			}
		}
		return flushCheck;
	}
	public static char checkSinglePair(String A) {
		//checks for single pair
		//if yes, returns the num
		//if not, returns 0
		char first = A.charAt(0);
		char second = A.charAt(3);
		char third = A.charAt(6);
		char fourth = A.charAt(9);
		int frCount = 0;
		int scCount = 0;
		int treCount = 0;
		int fourCount = 0;
		for(int i = 0; i < A.length(); i = i +3) {
			if(A.charAt(i) == first) {
				frCount++;
			}
			if(A.charAt(i) == second) {
				scCount++;
			}
			if(A.charAt(i) == third) {
				treCount++;
			}
			if(A.charAt(i) == fourth) {
				fourCount++;
			}
		}
		if(frCount == 2 && first != '0') {
			return first;
		}
		if(scCount == 2 && second != '0') {
			return second;
		}
		if(treCount == 2 && third != '0') {
			return third;
		}
		if(fourCount == 2 && fourth != '0') {
			return fourth;
		}
		return '0';
	}
	public static char checkThreePair(String A) {
		//checks for three of a kind
		//if yes, returns the num
		//if not, returns 0
		char first = A.charAt(0);
		char second = A.charAt(3);
		char third = A.charAt(6);
		int frCount = 0;
		int scCount = 0;
		int treCount = 0;
		for(int i = 0; i < A.length(); i = i +3) {
			if(A.charAt(i) == first) {
				frCount++;
			}
			if(A.charAt(i) == second) {
				scCount++;
			}
			if(A.charAt(i) == third) {
				treCount++;
			}
		}
		if(frCount == 3) {
			return first;
		}
		if(scCount == 3) {
			return second;
		}
		if(treCount == 3) {
			return third;
		}
		return '0';
	}
	public static char checkFourKind(String A) {
		//checks for four of a kind
		//if yes, returns the num
		//if not, returns 0
		char first = A.charAt(0);
		char second = A.charAt(3);
		int frCount = 0;
		int scCount = 0;
		for(int i = 0; i < A.length(); i = i +3) {
			if(A.charAt(i) == first) {
				frCount++;
			}
			if(A.charAt(i) == second) {
				scCount++;
			}
		}
		if(frCount == 4) {
			return first;
		}
		if(scCount == 4) {
			return second;
		}
		return '0';
	}

	public static int getHighCard(String A) {
		//gets the highest card from the hand
		int res = 0;
		for (int i = 0; i < A.length(); i = i + 3) {
			if (A.charAt(i) == 'A') {
				res = 14;
			} else if (A.charAt(i) == 'K') {
				res = Math.max(res, 13);
			} else if (A.charAt(i) == 'Q') {
				res = Math.max(res, 12);
			} else if (A.charAt(i) == 'J') {
				res = Math.max(res, 11);
			} else if (A.charAt(i) == 'T') {
				res = Math.max(res, 10);
			} else {
				res = Math.max(res, Integer.parseInt(A.charAt(i) + ""));
			}
		}
		return res;
	}

	public static boolean checkStraight(String A) {
		int curr = getHighCard(A);
		int hiPos = getCardPos(curr, A);
		A = swap(A, hiPos);
		for (int i = 0; i < 4; i++) {
			if(getHighCard(A) !=  curr -1) {
				return false;
			}
			curr = getHighCard(A);
			hiPos = getCardPos(curr, A);
			if(hiPos != -1) {
				A = swap(A, hiPos);
			}
		}
		return true;
	}

	public static int getCardPos(int a, String A) {
		char look = 'p';
		if (a == 14) {
			look = 'A';
		} else if (a == 13) {
			look = 'K';
		} else if (a == 12) {
			look = 'Q';
		} else if (a == 11) {
			look = 'J';
		} else if (a == 10) {
			look = 'T';
		} else {
			String temp = a + "";
			look = temp.charAt(0);
		}
		return A.indexOf(look);
	}
	public static int charToNum(char a) {
		if(a == 'A') {return 14;}
		if(a == 'K') {return 13;}
		if(a == 'Q') {return 12;}
		if(a == 'J') {return 11;}
		if(a == 'T') {return 10;}
		else {
			return Integer.parseInt(a + "");
		}
	}

	public static String swap(String str, int i) {
		//swap in a 0 at the index
		if(i == 0) {
			return '0' + str.substring(i + 1);
		}
		return str.substring(0, i) + '0' + str.substring(i + 1);
	}

}
