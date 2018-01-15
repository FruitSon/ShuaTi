package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import hard.*;

@RunWith(Parameterized.class)
public class LC685_Redundant_Connection_II_Test {

	private LC685_Redundant_Connection_II test; 
	private int[][] input;
	private int[] expectedResult;
	
	public LC685_Redundant_Connection_II_Test(int[][] input, int[] expectedResult){
		this.input = input;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC685_Redundant_Connection_II();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
			//duplicated parents, w/o cycle
			{new int[][]{{1,2},{1,3},{2,3}}, new int[]{2,3}},
			{new int[][]{{1,2},{2,3},{1,3},{3,5},{2,4}}, new int[]{1,3}},
			{new int[][]{{5,2},{5,1},{3,1},{3,4},{3,5}}, new int[]{3,1}},
			{new int[][]{{3,1},{3,4},{4,1},{4,2}}, new int[]{4,1}},
			{new int[][]{{3,1},{4,1},{3,4},{4,2}}, new int[]{4,1}},

			//duplicated parents, w cycle
			{new int[][]{{2,1},{3,1},{4,2},{1,4}}, new int[]{2,1}},
			//	*the parent node can have more than 2 child
			{new int[][]{{4,1},{1,5},{4,2},{5,1},{4,3}}, new int[]{5,1}},

			//no duplicated parents, w cycle
			{new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}}, new int[]{4,1}},
		});
	}
	
	@Test
	public void test() {
		assertArrayEquals(expectedResult,test.findRedundantDirectedConnection(input));
		assertArrayEquals(expectedResult,test.findRedundantDirectedConnection2(input));
	}

}

