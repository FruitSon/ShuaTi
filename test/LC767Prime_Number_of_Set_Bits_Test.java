package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.LC762_Prime_Number_of_Set_Bits;

@RunWith(Parameterized.class)
public class LC767Prime_Number_of_Set_Bits_Test {

	private LC762_Prime_Number_of_Set_Bits test; 
	private int start, end, res;
	
	public LC767Prime_Number_of_Set_Bits_Test(int start, int end, int res){
		this.start = start;
		this.end = end;
		this.res = res;
		
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC762_Prime_Number_of_Set_Bits();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
			{10,15, 5}, 
			{6, 10, 4 }
		});
	}
	
	@Test
	public void test() {
	    assertEquals(res, test.countPrimeSetBits(start,end));
	}

}
