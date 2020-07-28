
public class Project017 {
	/**
	 * If the numbers 1 to 5 are written out in words: one, two, three, four, 
	 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
	 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
	 * how many letters would be used?
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int j = 1; j <= 1000; j++) {
			System.out.println("on number:" + j);
			int i = j;
			while (i != 0) {
				if (i == 1000) {// one thousand
					sum = sum + 11;
					i = i - 1000;
				}
				if( i >= 900) {//nine hundred [and]
					sum = sum + 11;
					i = i - 900;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 800) {//eight hundred [and]
					sum = sum + 12;
					i = i - 800;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 700) {//seven hundred [and]
					sum = sum + 12;
					i = i - 700;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 600) {//nine hundred [and]
					sum = sum + 10;
					i = i - 600;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 500) {//five hundred [and]
					sum = sum + 11;
					i = i - 500;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 400) {//four hundred [and]
					sum = sum + 11;
					i = i - 400;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 300) {//three hundred [and]
					sum = sum + 12;
					i = i - 300;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 200) {//two hundred [and]
					sum = sum + 10;
					i = i - 200;
					if(i != 0) { sum = sum + 3;}
				}
				if( i >= 100) {//one hundred [and]
					sum = sum + 10;
					i = i - 100;
					if(i != 0) { sum = sum + 3;}
				}
				//tens digit
				if(i >= 90) {//ninety
					sum = sum + 6;
					i = i - 90;
				}
				if(i >= 80) {//eighty
					sum = sum + 6;
					i = i - 80;
				}
				if(i >= 70) {//seventy
					sum = sum + 7;
					i = i - 70;
				}
				if(i >= 60) {//sixty
					sum = sum + 5;
					i = i - 60;
				}
				if(i >= 50) {//fifty
					sum = sum + 5;
					i = i - 50;
				}
				if(i >= 40) {//forty
					sum = sum + 5;
					i = i - 40;
				}
				if(i >= 30) {//thirty
					sum = sum + 6;
					i = i - 30;
				}
				if(i >= 20) {//twenty
					sum = sum + 6;
					i = i - 20;
				}
				
				//teens
				if(i == 19) {//nineteen
					sum = sum + 8;
					i = i -19;
				}
				if(i == 18) {//eighteen
					sum = sum + 8;
					i = i -18;
				}
				if(i == 17) {//seventeen
					sum = sum + 9;
					i = i -17;
				}
				if(i == 16) {//sixteen
					sum = sum + 7;
					i = i -16;
				}
				if(i == 15) {//fifteen
					sum = sum + 7;
					i = i -15;
				}
				if(i == 14) {//fourteen
					sum = sum + 8;
					i = i -14;
				}
				if(i == 13) {//thirteen
					sum = sum + 8;
					i = i -13;
				}
				if(i == 12) {//twelve
					sum = sum + 6;
					i = i -12;
				}
				if(i == 11) {//eleven
					sum = sum + 6;
					i = i -11;
				}
				if(i == 10) {
					sum = sum +3;
					i = i - 10;
				}
				
				//ones
				if(i == 9) {//nine
					sum = sum + 4;
					i = 0;
				}
				if(i == 8) {//eight
					sum = sum + 5;
					i = 0;
				}
				if(i == 7) {//seven
					sum = sum + 5;
					i = 0;
				}
				if(i == 6) {//six
					sum = sum + 3;
					i = 0;
				}
				if(i == 5) {//five
					sum = sum + 4;
					i = 0;
				}
				if(i == 4) {//four
					sum = sum + 4;
					i = 0;
				}
				if(i == 3) {//three
					sum = sum + 5;
					i = 0;
				}
				if(i == 2) {//two
					sum = sum + 3;
					i = 0;
				}
				if(i == 1) {//one
					sum = sum + 3;
					i = 0;
				}
				
			}
		}
		System.out.println(sum);
		//21124 is the correct answer.
	}

}
