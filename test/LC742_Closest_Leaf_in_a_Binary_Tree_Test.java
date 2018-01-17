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
public class LC742_Closest_Leaf_in_a_Binary_Tree_Test {

	private LC742_Closest_Leaf_in_a_Binary_Tree test; 
	private TreeNode root;
	private int expectedRes;
	
	public LC742_Closest_Leaf_in_a_Binary_Tree_Test(TreeNode root, int expectedRes){
		this.root = root;
		this.expectedRes = expectedRes;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC742_Closest_Leaf_in_a_Binary_Tree();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		//case 1: single node
		TreeNode root1 = new TreeNode(1);
		
		//case 2: node.right == null
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.left.left = new TreeNode(3);
		root2.left.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.left.left = new TreeNode(3);
		root3.left.left.left = new TreeNode(4);
		root3.left.left.left.left = new TreeNode(5);

		//case 3
		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		root4.left.left = new TreeNode(3);
		root4.left.left.left = new TreeNode(4);
		root4.right = new TreeNode(5);
		
		return Arrays.asList(new Object[][] {
			{root1,1},
			{root2,5},
			{root3,5},
			{root4,5},
		});
	}
	 
	@Test
	public void test() {
		assertEquals(test.findCloestLeaf(root),expectedRes);
	}

}
