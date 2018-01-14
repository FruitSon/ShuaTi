package oa;
import java.util.*;

public class PocketGemsReachingPoints {
	public static void main(String[] args) {
		List<int[]> input = new LinkedList<>();
		input.add(new int[]{1,2,2,1});
		input.add(new int[]{1,4,5,9});
		for(int[] t : input){
			System.out.println("reachable? "+ (helper(t)?"Yes":"No"));
		}
	}
	
	private static boolean helper(int[] pos){
		if((pos[0]+pos[1] == pos[2] && pos[1]==pos[3]) 
				|| (pos[0] == pos[2] && pos[1]+pos[0]==pos[3])){
			return true;
		}else if((pos[0]+pos[1] > pos[2] && pos[1]+pos[0]>pos[3])){
			return false;
		}
		return helper(new int[]{pos[0]+pos[1],pos[1],pos[2],pos[3]}) ||
				helper(new int[]{pos[0],pos[0]+pos[1],pos[2],pos[3]});
	}
}
