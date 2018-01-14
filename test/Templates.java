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
public class Templates {

	private LC231_Power_Of_Two test; 
	
	public Templates(){
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
