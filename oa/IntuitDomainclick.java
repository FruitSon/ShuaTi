package oa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class IntuitDomainclick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] input = {{"google.com", "60"},{"yahoo.com", "50"},
				{"sports.yahoo.com","80"},{"v.google.com","20"}};
		findDomainclick(input);
	}
	public static void findDomainclick(String[][] input){
		Arrays.sort(input,new Comparator<String[]>(){
			public int compare(String[] a, String[] b){
				return -a[0].split(".").length + b[0].split(".").length;
			}
		});
		Set<String> visited = new HashSet<>();
		for(int i = 0; i<input.length; i++){
			String[] temp = input[0][0].split(".");
//			dfs(temp,temp.length-1,i+1,visited);
		}
		return;
	}

}
