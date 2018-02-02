package normal;
import java.util.Arrays;
import data_structure.Interval;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 */

/*
252.meeting rooms
253.meeting rooms II
56.Merge Intervals
57.Insert Intervals
*/

// Method 1: brute force
// - sort all intervals by start time. Compare the end time and the start time of next interval
// - Time : O(nlogn)
// Method 2 (扫描线)
// - store the start / end time into two array seperately
// - sort the array
// - check if two interval overlaps (the next start time smaller than current end time)
// 	 - start[i+1] < end[i]
// - Time : < O(nlogn)
// - ref : https://www.youtube.com/watch?v=6tLHjei-f0I

public class LC252_Meeting_Rooms {
	// Method 2
    public boolean canAttendMeetings(Interval[] intervals) {
    	if(intervals==null || intervals.length == 0) return false;
    	int len = intervals.length;
    	int[] start = new int[len], end = new int[len];
    	for(int i = 0; i < len ; i++){
    		start[i] = intervals[i].start;
    		end[i] = intervals[i].end;
    	}
    	Arrays.sort(start);
    	Arrays.sort(end);
    	
    	for(int i = 0; i < len; i++){
    		if(start[i+1] < end[i]) return false;
    	}
    	return true;
    }
}
