package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.*;
import hard.*;

@RunWith(Parameterized.class)
public class  LC005_Longest_Palindromic_Substring_Test {

	private  LC005_Longest_Palindromic_Substring test; 
	private String input, expectedRes;
	
	public  LC005_Longest_Palindromic_Substring_Test(String input, String expectedRes){
		this.input = input;
		this.expectedRes = expectedRes;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new  LC005_Longest_Palindromic_Substring();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
			{"cc","cc"},
			{"aabaa","aabaa"},
			{"baab","baab"},
			{"",""}
		});
	}
	 
	@Test
	public void test() {
		assertEquals(expectedRes,test.longestPalindrome(input));
	}

}
