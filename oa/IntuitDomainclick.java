package oa;

import java.util.Arrays;
import java.util.Comparator;

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

		//to be finished
		return;
	}

}
