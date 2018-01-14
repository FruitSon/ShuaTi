package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.LC684_Redundant_Connection;

class TestCase{
	int[] res;
	int[][] input;
	public TestCase(int[] res, int[][] input){
		this.res = res;
		this.input = input;
	}
}

@RunWith(Parameterized.class)
public class LC684_Redundant_Connection_Test {
	
	private LC684_Redundant_Connection test;
	private int[] expectedOutput;
	private int[][] input;
	
	public LC684_Redundant_Connection_Test(int[] res, int[][] testcase){
		this.input = testcase;
		this.expectedOutput = res;
	}
	

	
	@Before
	public void setUp() throws Exception {
		test = new LC684_Redundant_Connection();
	}
	
	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return  Arrays.asList(new Object[][]{
			{new int[]{1,4}, new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}}},
			{new int[]{1,3}, new int[][]{{1,4},{3,4},{1,3},{1,2},{4,5}}},
			{new int[]{4,5},new int[][]{{1,5},{3,4},{3,5},{4,5},{2,4}}},
			{new int[]{4,10},new int[][]{{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}}}
		});
	}
	
	@Test
	public void test() {
		assertArrayEquals(expectedOutput,test.findRedundantConnection2(input));
		assertTrue(Arrays.equals(expectedOutput, test.findRedundantConnection2(input)));

	}
}
