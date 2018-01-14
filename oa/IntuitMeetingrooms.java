package oa;

import java.util.Arrays;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class IntuitMeetingrooms {
    public static void main(String[] args) {
    	Interval[] input = {new Interval(0,30),new Interval(5,10),new Interval(15,20)};
    	boolean res = helper(input);
    	System.out.println(res);

    }
    
    public static boolean helper(Interval[] intervals){
        if(intervals.length==0) return true;
        Arrays.sort(intervals, (o1,o2)->o1.start-o2.start);
        
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i].start<intervals[i-1].end) return false;
        }
        return true;
    }
}
