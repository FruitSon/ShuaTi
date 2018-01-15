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
public class _Test {

	private LC231_Power_Of_Two test; 
	
	public _Test(){
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC231_Power_Of_Two();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
		});
	}
	
	@Test
	public void test() {
		fail();
	}

}
