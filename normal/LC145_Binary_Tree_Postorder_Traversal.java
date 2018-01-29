package normal;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3
 

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */

public class LC145_Binary_Tree_Postorder_Traversal {
    //recursion
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postOrder(root,res);
        return res;
    }
    
    private void postOrder(TreeNode node, List<Integer> res ){
        if(node == null) return;
        postOrder(node.left, res);
        postOrder(node.right,res);
        res.add(node.val);
        return;
    }
    
    //iteration    
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = null, p = root;
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        
        while(!stack.empty()){
            while(root!=null){
                stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == stack.peek()){
                stack.pop();
                root.
            }
            
            
        }
        return res;
    }
    
}
