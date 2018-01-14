package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.*;

@RunWith(Parameterized.class)
public class LC264_Ugly_Number_II_Test {

	private LC264_Ugly_Number_II test; 
	private int n, expectedRes;
	
	public LC264_Ugly_Number_II_Test(int n, int expectedRes){
		this.n = n;
		this.expectedRes = expectedRes;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC264_Ugly_Number_II();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
			{1,1},
			{2,2},
			{3,3},
			{4,4},
			{5,5}
		});
	}
	
	@Test
	public void test() {
		assertEquals(test.nthUglyNumber(n),expectedRes);
	}

}
