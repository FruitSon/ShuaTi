package normal;

//	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//	Note: You can only move either down or right at any point in time.
//
//	Example 1:
//	[[1,3,1],
//	 [1,5,1],
//	 [4,2,1]]
//	Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
public class LC64_Minimum_Path_Sum {

	//时间复杂度 O(M*N)
    public int minPathSum(int[][] grid) {
        if(grid==null||grid[0].length==0) return 0;
        int h = grid.length, w = grid[0].length;
        
        int[] line = new int[w+1];
        for(int i = 1; i<line.length; i++) line[i] = line[i-1] + grid[0][i-1];
        for(int i = 1; i < h; i++){
            for(int j = 1; j<line.length; j++){
                //但是j==0要判断m*n次
                line[j] = grid[i][j-1]+ Math.min(line[j],j>1?line[j-1]:Integer.MAX_VALUE);
            }
        }
        return line[line.length-1];
    }
    
}
