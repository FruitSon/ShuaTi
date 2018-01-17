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

@RunWith(Parameterized.class)
public class LC671_Second_Minimum_Node_in_a_Binary_Tree_Test {

	private LC671_Second_Minimum_Node_in_a_Binary_Tree test; 
	private TreeNode root;
	private int expectedRes;
	public LC671_Second_Minimum_Node_in_a_Binary_Tree_Test(TreeNode root,int expectedRes){
		this.root = root;
		this.expectedRes = expectedRes;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC671_Second_Minimum_Node_in_a_Binary_Tree();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		TreeNode root1 = new TreeNode(1);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(1);
		
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(1);
		root3.right = new TreeNode(1);
		root3.left.left = new TreeNode(3);
		root3.left.right = new TreeNode(1);
		root3.right.left = new TreeNode(4);
		root3.right.right = new TreeNode(1);
		
		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(1);
		root4.right = new TreeNode(1);
		root4.right.left = new TreeNode(4);
		root4.right.right = new TreeNode(1);
		
		return Arrays.asList(new Object[][] {
			{root1,-1},
			{root2,-1},
			{root3,3},
			{root4,4}
		});
	}
	 
	@Test
	public void test() {
		assertEquals(expectedRes,test.findSecondMinimumValue(root));
	}

}


