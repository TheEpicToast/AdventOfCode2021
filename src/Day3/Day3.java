package Day3;

import java.util.ArrayList;

public class Day3 {
	
	private static char[] getGamma(String[] strList) {
		int[] sums = new int[strList[0].length()];
		for (String s : strList) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					sums[i]++;
				}
			}
		}
		int half = strList.length/2;
		char[] gamma = new char[strList[0].length()];
		for (int j = 0; j < sums.length; j++) {
			if (sums[j] >= half) gamma[j] = '1';
			else gamma[j] = '0';
		}
		return gamma;
	}
	
	//1 for ox
	//0 for c02
	private static char[] getRating(String[] strList,int type) {
		ArrayList<String> validNums = new ArrayList<String>();
		
		for (String s : strList) {
			validNums.add(s);
		}
		
		int i = 0;
		int sumi = 0;
		double half = (double)(validNums.size())/2;
		int j = 0;
		
		if(type == 1) {
			while (validNums.size() > 1) {
				
				if (j == 0) {
					sumi = 0;
					for (String s : validNums) {
						if (s.charAt(i) == '1') {
							sumi++;
						}
					}
					
				}
				if (sumi >= half) {
					if (validNums.get(j).charAt(i) == '0') validNums.remove(j); 
					else j++;
				}
				else {
					if (validNums.get(j).charAt(i) == '1') validNums.remove(j);
					else j++;
				}
				
				if (j == validNums.size()) { 
					i++; 
					j = 0;
					half = (double)(validNums.size())/2;
				}
			}
		}
		else {
			while (validNums.size() > 1) {
				if (j == 0) {
					sumi = 0;
					for (String s : validNums) {
						if (s.charAt(i) == '1') {
							sumi++;
						}
					}
				}
				if (sumi >= half) {
					if (validNums.get(j).charAt(i) == '1') validNums.remove(j); 
					else j++;
				}
				else {
					if (validNums.get(j).charAt(i) == '0') validNums.remove(j);
					else j++;
				}
				
				if (j == validNums.size()) { 
					i++; 
					j = 0;
					half = (double)(validNums.size())/2;
				}
			}
		}
		char[] ratio = new char[strList[0].length()];
		ratio = validNums.get(0).toCharArray();
		return ratio;
	}
	
	private static char[] flipTheBits(char[] gamma) {
		char[] epsilon = new char[gamma.length];
		for (int i = 0; i < gamma.length; i++) {
			epsilon[i] = Character.forDigit((Character.getNumericValue(gamma[i]) + 1) % 2,16);
		}
		return epsilon;
	}
	
	private static int binaryToInt(char[] binary) {
		int value = 0;
		for (int i=0; i< binary.length; i++)  // for every character in the string  strlen(s) returns the length of a char array
		{
		  value *= 2; // double the result so far
		  if (binary[i] == '1') value++;  //add 1 if needed
		}
		
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] gamma = new char[args[0].length()];
		char[] epsilon = new char[gamma.length];
		
		gamma = getGamma(args);
		epsilon = flipTheBits(gamma);
		
		int gammaVal = binaryToInt(gamma);
		int epsilonVal = binaryToInt(epsilon);
		
		System.out.println("gamma: " + gammaVal + " epsilon: " + epsilonVal + " total: " + gammaVal * epsilonVal);
		
		char[] ogr = new char[gamma.length];
		char[] csr = new char[gamma.length];
		
		ogr = getRating(args,1);
		csr = getRating(args,0);
		
		int ogrVal = binaryToInt(ogr);
		int csrVal = binaryToInt(csr);
		
		System.out.println("ogr: " + ogrVal + " csr: " + csrVal + " total: " + ogrVal * csrVal);
	}

}
