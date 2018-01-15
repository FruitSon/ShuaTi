package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import hard.*;
//import normal.*;

@RunWith(Parameterized.class)
public class LC765_Couples_Holding_Hands_Test {

	private LC765_Couples_Holding_Hands test; 
	private int[] arr;
	private int expectedRes;
	
	public LC765_Couples_Holding_Hands_Test(int[] arr, int expectedRes){
		this.arr = arr;
		this.expectedRes = expectedRes;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC765_Couples_Holding_Hands();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
			{new int[]{0,1},0},
			{new int[]{1,2,0,3},1},
			{new int[]{0,2,4,6,7,1,3,5},3},
			{new int[]{0,1,3,4,2,5,6,7},1}
		});
	}
	
	@Test
	public void test() {
		assertEquals(test.minSwapsCouples(arr),expectedRes);
	}

}
