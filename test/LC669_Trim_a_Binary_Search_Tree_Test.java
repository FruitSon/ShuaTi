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
public class LC669_Trim_a_Binary_Search_Tree_Test {

	private LC669_Trim_a_Binary_Search_Tree test; 
	private TreeNode root;
	private TreeNode res;
	private int L,R;
	public LC669_Trim_a_Binary_Search_Tree_Test(TreeNode root, TreeNode res, int L, int R){
		this.root = root;
		this.res = res;
		this.L = L;
		this.R = R;
	}
	
	@Before
	public void setUp() throws Exception {
		test = new LC669_Trim_a_Binary_Search_Tree();
	}

	@Parameterized.Parameters
	public static List<Object[]> testcase(){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		return Arrays.asList(new Object[][] {
		});
	}
	 
	@Test
	//too complicated
	public void test() {
		fail();
	}

}
