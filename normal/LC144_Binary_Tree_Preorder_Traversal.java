package normal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import data_structure.TreeNode;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */

//Method 1: Recursion
//Method 2: Iteration
public class LC144_Binary_Tree_Preorder_Traversal {
	 //recursion
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preOrder(root,res);
        return res;
    }
    
    private void preOrder(TreeNode node, List<Integer> res ){
        if(node == null) return;
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right,res);
        return;
    }
    
    //Iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.empty()){
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if(tmp.right!=null) stack.push(tmp.right);
            if(tmp.left!=null) stack.push(tmp.left);            
        }
        return res;
    }
}
