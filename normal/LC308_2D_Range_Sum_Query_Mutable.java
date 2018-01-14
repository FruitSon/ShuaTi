package normal;	

public class LC308_2D_Range_Sum_Query_Mutable {

	//public static void main(String[] args) {
		//test case 1
//		int[][] arr = {{1,2}};
//		NumMatrix mat = new NumMatrix(arr);
//		System.out.println(mat.sumRegion(0,0,0,0));
//		System.out.println(mat.sumRegion(0,1,0,1));
//		System.out.println(mat.sumRegion(0,0,0,1));
//
//		mat.update(0,0,3);
//		mat.update(0,1,5);
//		System.out.println(mat.sumRegion(0,0,0,1));	
//		//test case 2
//		int[][] arr = {{2,4},{-3,5}};
//		NumMatrix mat = new NumMatrix(arr);
//		mat.update(0,1,3);
//		mat.update(1,1,-3);
//		mat.update(0,1,1);
//		System.out.println(mat.sumRegion(0,0,1,1));
		//test case 3
	//}
	
	int[][] tree;
	int[][] orig;
	int height, width;
    public LC308_2D_Range_Sum_Query_Mutable(int[][] matrix) {
    	if(matrix==null||matrix.length==0 || matrix[0].length==0) return;
    	height = matrix.length;
    	width = matrix[0].length;
    	
    	orig = matrix;
    	tree = new int[height+1][width+1];
    	//initialize
    	for(int i = 0; i < height; i++){
    		for(int j = 0; j < width; j++){
    			initialize(i,j,matrix[i][j]);
    		}
    	}
    }
    
    public int lowbit(int i){
    	return i&(-i);
    }
    
    public void initialize(int r, int c, int val){
    	for(int i = r+1; i < height+1; i += lowbit(i))  
            for(int j = c+1; j < width+1; j += lowbit(j))  
                tree[i][j] += val; 
    }
    
    public void update(int r, int c, int val) {
    	int diff = val - orig[r][c];
    	printMatrix(orig);

    	orig[r][c] = val;
    	printMatrix(orig);
        for(int i = r+1; i < height+1; i += lowbit(i))  
            for(int j = c+1; j < width+1; j += lowbit(j))  
                tree[i][j] += diff;  
    }
    
    public int getSum(int r, int c) {
        int res = 0;
        for (int i = r; i > 0; i -= lowbit(i)) {
            for (int j = c; j > 0; j -= lowbit(j)) {
                res += tree[i][j];
            }
        }
        return res;
    } 
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
		return getSum(row2+1,col2+1)+getSum(row1,col1)-getSum(row1,col2+1)-getSum(row2+1,col1);
    }
    
    public void printMatrix(int[][] m){
    	for(int i = 0; i < m.length; i++){
    		for(int j = 0; j < m[0].length; j++){
    			System.out.print(m[i][j]+" ");
    		}
    		System.out.print("\n");
    	}
		System.out.print("\n");
    }

	
	//Implemented with BIT

//	//Implemented with 2D array , Nigel
//	    int[][] matrix;
//	    int[][] sumij;
//	    Map<Double, Integer> map = new HashMap<>();
//	    final int divider = 100000;
//	    public LC308_2D_Range_Sum_Query_Mutable(int[][] matrix) {
//	        this.matrix = matrix;
//	        if(matrix == null || matrix.length == 0) return;
//	        this.sumij = new int[matrix.length+1][matrix[0].length+1];
//	        for(int i = 1; i <= matrix.length; i++){
//	            for(int j = 1; j <= matrix[0].length; j++) {
//	                sumij[i][j] = matrix[i - 1][j - 1] + sumij[i-1][j] + sumij[i][j-1] - sumij[i-1][j-1];
//	            }
//	        }
//	    }
//
//	    public void update(int row, int col, int val) {
//	        double key = row + (double) col / divider;
//	        map.put(key, val);
//	    }

//	
//	public Integer sumRegion(int row1, int col1, int row2, int col2) {
////      return (row1 <= row2 && col1 <= col2 && this.matrix != null && row2 < this.matrix.length && col2 < this.matrix[0].length)
////              ? this.sumij[row2+1][col2+1] - this.sumij[row1][col2+1] - this.sumij[row2+1][col1] + this.sumij[row1][col1] : null;
//      if(!(row1 <= row2 && col1 <= col2 && this.matrix != null && row2 < this.matrix.length && col2 < this.matrix[0].length)) 
//    	  return null;
//      else{
//          int res = this.sumij[row2+1][col2+1] - this.sumij[row1][col2+1] - this.sumij[row2+1][col1] + this.sumij[row1][col1];
//          for (Map.Entry<Double, Integer> entry : map.entrySet()
//               ) {
//              int x =  (int) entry.getKey().doubleValue();
//              int y =  (int) ((entry.getKey().doubleValue() - x) * divider);
//              if(x >= row1 && x <= row2 && y >= col1 && y <= col2) {
//                  res += entry.getValue() - this.matrix[x][y];
//              }
//          }
//          return res;
//      }
//	}
//	}
}
	
