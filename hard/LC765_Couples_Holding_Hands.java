package hard;

/*
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.
The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.
*/

//refer to LC 48 first missing positive
public class LC765_Couples_Holding_Hands {
    public int minSwapsCouples(int[] row) {
    	int res = 0;
    	int[] pos = new int[row.length];
    	for(int i = 0; i < pos.length; i++) pos[row[i]] = i;
    	
    	for(int i = 0; i < row.length; i += 2){
    		if((row[i]^row[i+1])==1) continue;
    		//paired: the value need to be filled in row[i+1]
    		//pos[paired]: the cur index of paired in row
    		//row[i+1]: the original value filled in row[i+1] (the index in pos)
    		//row[pos[paired]]: the value need to be swapped with row[i+1] (the index in pos)
    		int paired = row[i]%2==0?row[i]+1:row[i]-1;
    		//swap the second number in each pair to paired, whose initial index is pos[paired]
    		swap(row,i+1,pos[paired]);
    		//swap the index of the value of second number and the value of the value being swaped
    		swap(pos,row[i+1],row[pos[paired]]);
    		res++;
    	}
    	return res;
    }
    
    private void swap(int[] arr, int idx1, int idx2){
    	int tmp = arr[idx1];
    	arr[idx1] = arr[idx2];
    	arr[idx2] = tmp;
    }
    

}
