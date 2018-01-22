package normal;
/*A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 

Example 1:

Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: True
Explanation:
1234
5123
9512

In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
Example 2:

Input: matrix = [[1,2],[2,2]]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
Note:

matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].
*/

//compare each line with the line above it
//Time: O(n*m)
//Space: O(1)
public class LC766_Toeplitz_Matrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
	    if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
	    int h = matrix.length, w = matrix[0].length;
	    for(int i = 1; i < h; i ++){
	        for(int j = 1; j < w; j++){
	            if(matrix[i][j]!=matrix[i-1][j-1]) return false;
	        }
	    }
	    return true;
	}
}
