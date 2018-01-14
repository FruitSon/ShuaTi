package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import normal.LC763_Partition_Labels;

@RunWith(Parameterized.class)
public class LC763_Partition_Labels_Test {

	private LC763_Partition_Labels test;
	String str;
	List<?>output;
	
	public LC763_Partition_Labels_Test(String str,List<Integer> output){
		this.str = str;
		this.output = output;
	}
	
	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		return Arrays.asList(new Object[][]{
			{"aaaaaa",Arrays.asList(6)},
			{"ababcbacadefegdehijhklij",Arrays.asList(9,7,8)},
			{"abcccb",Arrays.asList(1,5)},
			{"",new LinkedList<Integer>()},
		});
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC763_Partition_Labels();
	}

	@Test
	public void test() {
		assertEquals(output,test.partitionLabels(str));
	}

}
