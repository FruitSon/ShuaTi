package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import data_structure.TreeNode;
import normal.*;
import hard.*;

@RunWith(Parameterized.class)
public class LC155_Min_Stack_Test {

	private LC155_Min_Stack test; 
	private String[] operations;
	private String res;
	public LC155_Min_Stack_Test(String[] operations, String res){
		this.operations = operations;
		this.res = res;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC155_Min_Stack();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][] {
			{new String[]{},""},
			{new String[]{},""},
			{new String[]{},""},
			{new String[]{},""},
			{new String[]{},""},
			{new String[]{},""},
		});
	}
	 
	@Test
	public void test() {
		fail();
	}

}
