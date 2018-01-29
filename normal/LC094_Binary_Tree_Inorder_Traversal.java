package normal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import data_structure.TreeNode;

/*
 * 
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

// Method 1: Recursion
// Method 2: Iteration
public class LC094_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inOrder(root,res);
        return res;
    }
    
    private void inOrder(TreeNode node, List<Integer> res ){
        if(node == null) return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right,res);
        return;
    }
    
    //Iteration
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;
        TreeNode tmp = root;
        while(tmp!=null || !stack.empty()){
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            res.add(tmp.val);
            tmp = tmp.right;                  
        }
        return res;
    }
}
