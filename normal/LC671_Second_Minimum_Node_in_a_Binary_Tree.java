package normal;

import data_structure.TreeNode;

/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

 */

// the rules of the input tree : 
// #1. have no child or two child
// #2. the value of parent equals to the smaller value in the children 
// According to #2, the Second_Minimum is the smallest value expect the root value
// So we can solve this problem by find the minimal value excepeting root value by recursion
public class LC671_Second_Minimum_Node_in_a_Binary_Tree {
	
	//Recursion, pass the root.val into recursion function
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        int candidate = findSmallest(root,root.val);
        return candidate== root.val? -1 : candidate;
    }
    
    private int findSmallest(TreeNode root, int val){
        if(root == null) return -1;
        if(root.left == null && root.right == null) return root.val;
        int left = findSmallest(root.left,val);
        int right = findSmallest(root.right, val);
        return left==val?right:right==val?left:Math.min(left,right);
    }
    
//		//wrong solution: 没有traverse到最底层就返回
//		//the case didn't pass: [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
//      public int findSecondMinimumValue(TreeNode root) {
//          if(root==null) return -1;
//          int res = helper(root);
//          return res == root.val? -1: res;
//      }
//      private int helper(TreeNode root){
//        // check if root is null
//         if(root.left==null && root.right == null) return root.val;
//        // root.left and root.right one is null
//         if(root.left.val==root.right.val){
//             return root.left.val == helper(root.left)? helper(root.right):helper(root.left);
//         }
//         return root.val == root.left.val ?root.right.val : root.left.val;
//      }

}
