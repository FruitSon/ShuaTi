package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.LC764_Largest_Plus_Sign;
@RunWith(Parameterized.class)
public class LC764_Largest_Plus_Sign_Test {

	private LC764_Largest_Plus_Sign test = new LC764_Largest_Plus_Sign();
	private int size;
	private int[][] mines;
	private int expectedResult;
	
	public LC764_Largest_Plus_Sign_Test(int size, int[][] mines, int expectedResult){
		this.size = size;
		this.mines = mines;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][]{
			{5,new int[][]{{4,2}},2},
			{2,new int[][]{},1},
			{1,new int[][]{{0,0}},0}
		});
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(expectedResult, test.orderOfLargestPlusSign(size, mines));
	}

}
