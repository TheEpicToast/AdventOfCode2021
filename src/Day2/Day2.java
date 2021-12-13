package Day2;

public class Day2 {
	
	private static void updatePos(int[] pos,String dir, int distance) {		
		if (dir.contentEquals("forward")) {
			pos[0] += distance;
			pos[1] += pos[2] * distance;
		}
		else if (dir.contentEquals("down")) {
			pos[2] += distance;
		}
		else if (dir.contentEquals("up")) {
			pos[2] -= distance;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] subPos = {0,0,0};
		for (int i = 0; i < args.length; i+=2) {
			updatePos(subPos,args[i],Integer.valueOf(args[i+1]));
		}
		System.out.println("Horizontal pos: " + subPos[0] + " Depth: " + subPos[1]);
		System.out.println(subPos[0] * subPos[1]);
		
	}

}
