package normal;
/*
In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.
An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.
Examples of Axis-Aligned Plus Signs of Order k:

Order 1:
000
010
000

Order 2:
00000
00100
01110
00100
00000

Order 3:
0000000
0001000
0001000
0111110
0001000
0001000
0000000
Example 1:

Input: N = 5, mines = [[4, 2]]
Output: 2
Explanation:
11111
11111
11111
11111
11011
In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
Example 2:

Input: N = 2, mines = []
Output: 1
Explanation:
There is no plus sign of order 2, but there is of order 1.
Example 3:

Input: N = 1, mines = [[0, 0]]
Output: 0
Explanation:
There is no plus sign, so return 0.
Note:

N will be an integer in the range [1, 500].
mines will have length at most 5000.
mines[i] will be length 2 and consist of integers in the range [0, N-1].
(Additionally, programs submitted in C, C++, or C# will be judged with a slightly smaller time limit.)

*/

public class LC764_Largest_Plus_Sign {
	//Method 1: 
	//use dp to calculate the maximum arm length of each direction
	//one more loop to get the maximum size of plus sign
	//Time:3*O(N^2) = O(N^2)
	//Space: 5*O(N^2) = O(N^2)
	public int orderOfLargestPlusSign(int N, int[][] mines) {
        int res = 0;
        int[][] field = new int[N+1][N+1];
        for(int[] mine : mines){
            field[mine[0]+1][mine[1]+1] = 1;
        }
        
        int[][] t = new int[N+2][N+2];
        int[][] l = new int[N+2][N+2];
        int[][] d = new int[N+2][N+2];
        int[][] r = new int[N+2][N+2];

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j ++){
                if(field[i][j]==0){
                    t[i][j] = 1 + t[i-1][j];
                    l[i][j] = 1 + l[i][j-1];
                }
            }
        }
        
        for(int i = N; i >0 ; i--){
            for(int j = N; j > 0 ; j --){
                if(field[i][j]==0){
                    d[i][j] = 1 + d[i+1][j];
                    r[i][j] = 1 + r[i][j+1];
                }
            }
        }
        
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                res = Math.max ( res, Math.min(Math.min(t[i][j],d[i][j]),Math.min(l[i][j],r[i][j])));
            }
        }
        return res;
    }
}
