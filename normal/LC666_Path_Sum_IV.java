package normal;

import java.util.Arrays;

/*If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:

The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

Example 1:

Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:

Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.
*/

//Method 1: top down, global val for record, recursion function return the #path of each child
//Method 2: bottom up, iterative
public class LC666_Path_Sum_IV {
	//Method 1
	int sum = 0;
	public int pathSum1(int[] nums){
		int[][] matrix = new int[6][17];
		for(int[] line : matrix) Arrays.fill(line, -1);
		for(int i  : nums) fillMatrix(i,matrix);
		cntPath(matrix, 1, 1);	
		System.out.println(sum);
		return sum;
	}
	//return the number of path of left & right 
	private int cntPath(int[][] matrix, int layer, int pos){
		if(layer>4 || pos > 16 || matrix[layer][pos]==-1) return 0;
		int left = cntPath(matrix,layer+1,pos*2-1);
		int right = cntPath(matrix,layer+1,pos*2);
		int cnt = 0;
		if(left==0 && right==0) cnt = 1;
		else if(left != 0 && right != 0) cnt = left + right;
		else cnt = left==0?right:left;
		sum += (cnt)*matrix[layer][pos];
		return cnt;
	}

	
	//Method 2: bottom up
	public static int pathSum(int[] nums){
		int[][] matrix = new int[5][9];
		for(int[] line : matrix) Arrays.fill(line, -1);
		for(int i  : nums) fillMatrix(i,matrix);

		int sum = 0;
		int max_layer = nums[nums.length-1]/100;

		for(int layer = max_layer; layer >= 1; layer--){
			for(int pos = 1 ; pos <= Math.pow(2,layer-1) ; pos ++){
				if(matrix[layer][pos]!=-1){
					int pathCnt = getPathCnt(layer,pos,matrix);
					sum += pathCnt * matrix[layer][pos];
					matrix[layer][pos] = pathCnt;
				}
			}
		}
		System.out.println(sum);
		return sum;
	}
	
	private static void fillMatrix(int i, int[][] matrix){
		matrix[i / 100][i / 10 % 10] = i % 10;
		return;
	}
	
	private static int getPathCnt(int layer, int pos, int[][] matrix){
		if(layer+1==matrix.length) return 1;
		int left = matrix[layer+1][pos*2-1]==-1?0:matrix[layer+1][pos*2-1];
		int right = matrix[layer+1][pos*2]==-1?0:matrix[layer+1][pos*2];
		return (left+right==0)?1:(left+right);
	}
}
