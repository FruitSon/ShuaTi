package normal;
/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */

import java.util.Stack;

import data_structure.TreeNode;

// Method 1: Recursion
// Method 2: Iteration
public class LC098_Validate_BST {
    // Method 1: recursion 
	// 边界用long
	public boolean isValidBST1(TreeNode root) {
		if(root==null) return true;
		return checkSubtree(root,Long.MAX_VALUE, Long.MIN_VALUE);
	}
 
	private boolean checkSubtree(TreeNode n, long max, long min){
		if(n==null) return true;
		//要等号
		if(n.val >= max || n.val <= min) return false;
		return checkSubtree(n.left,Math.min(n.val,max),min) && checkSubtree(n.right,max, Math.max(min,n.val));
	}
 
	//Method 2: iteration
	public boolean isValidBST2(TreeNode root){
		if(root==null) return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = root;
		while(root!=null || !stack.empty()){
			while(root!=null){
				stack.push(root);
				root=root.left;
			}
			root = stack.pop();
			if(pre!=null && root.val <= pre.val) return false;
			pre = root;
			root = root.right;
		}
		return true;
	}
}
