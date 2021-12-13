package Day1_1;

public class Day1_1 {
	
	private static int countIncreases(String[] measures) {
		int incCount = 0;			
		String[] buffer = {measures[0],""};
		for(String s : measures) {
			buffer[1] = s;
			if (Integer.parseInt(buffer[1]) > Integer.parseInt(buffer[0])) incCount++;
			buffer[0] = s;
		}
		return incCount;
	}
	
	private static int countSumIncreases(String[] measures) {
		int incCount = 0;			
		String[] buffer = {measures[0],measures[1],measures[2]};
		int lastSum =  Integer.parseInt(buffer[0]) + Integer.parseInt(buffer[1]) + Integer.parseInt(buffer[2]);;
		for(int i = 3; i < measures.length; i++) {
			String[] newBuff = {buffer[1],buffer[2],measures[i]};
			int curSum = Integer.parseInt(newBuff[0]) + Integer.parseInt(newBuff[1]) + Integer.parseInt(newBuff[2]);
			if (curSum > lastSum) incCount++;
			lastSum = curSum;
			buffer = newBuff;
		}
		return incCount;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(countIncreases(args));
		System.out.println(countSumIncreases(args));
	}
}
