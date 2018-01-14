package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.*;

////test case 2


//test case 3
//int[][] arr = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
//NumMatrix mat = new NumMatrix(arr);
//System.out.println(mat.sumRegion(2,1,4,3));
//mat.update(3,2,2);
//System.out.println(mat.sumRegion(2,1,4,3));
//}
//
@RunWith(Parameterized.class)
public class LC308_2D_Range_Sum_Query_Mutable_Test {

	private LC308_2D_Range_Sum_Query_Mutable test; 
	int[][] matrix;
	int[][] operations;
	int[] expectedRes;
	
	public LC308_2D_Range_Sum_Query_Mutable_Test(int[][] matrix, int[][] operations, int[] expectedRes){
		this.matrix = matrix;
		this.operations = operations;
		this.expectedRes = expectedRes;
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
			{new int[][]{{1,2}},new int[][]{{0,0,0,0},{0,1,0,1},{0,0,0,1},{0,0,3},{0,1,5},{0,0,0,1}},new int[]{1,2,3,0,0,8}},
			{new int[][]{{2,4},{-3,5}},new int[][]{{0,1,3},{1,1,-3},{0,1,1},{0,0,3},{0,0,1,1}},new int[]{0,0,0,0,-2}},
			{new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}},new int[][]{{2,1,4,3},{3,2,2},{2,1,4,3}},new int[]{8,0,10}}
		});
	}
		
	@Test
	public void test() {
		test = new LC308_2D_Range_Sum_Query_Mutable(matrix);
		for(int i = 0; i < operations.length; i++ ){
			int[] o = operations[i];
			if(o.length==3){
				test.update(o[0], o[1], o[2]);
			}else if(o.length==4){
				assertEquals(expectedRes[i],test.sumRegion(o[0], o[1], o[2], o[3]));
			}
		}
	}

}
