package test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.LC231_Power_Of_Two;

@RunWith(Parameterized.class)
public class LC231_Power_Of_Two_Test {

	private LC231_Power_Of_Two test = new LC231_Power_Of_Two();
	private int input;
	private boolean expectedOutput;
	
	@Before
    public void initialize() {
		test = new LC231_Power_Of_Two();
    }
	
	public LC231_Power_Of_Two_Test (int input, boolean expectedOutput){
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameterized.Parameters
	public static List<Object[]> testCase(){
		return Arrays.asList(new Object[][] {
			//negative
	         { -1, false },
	        //true
	         { 1, true },
	         { 2, true },
	         { 32, true },
	         { 0x4000_0000, true },
	        //false
	         { 0, false },
	         { 3, false },
	         { 19, false },
	      });	
	}
   
	@Test
	public void test() {
		 System.out.println(" testcase: " + input + "; expected resuld: "+ expectedOutput + "; actual result: "+test.isPowerOfTwo(input));
	     assertEquals(expectedOutput, test.isPowerOfTwo(input));
	}
}

