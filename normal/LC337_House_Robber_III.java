package normal;
/*The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

import data_structure.TreeNode;

/*
337	House Robber III    		
213	House Robber II
198	House Robber 
*/

//tree
//post order traversal.  

// Method 1: brute force
// Method 2: bottom up, state machine. 
// - For each node, return the max sum of rob or not rob this node individually
// - if rob: val = left.not_rob + right.not_rob + node.val
// - if not rob: val = max(left.not_rob,left.rob) + max(right.rob,right.not_rob)
public class LC337_House_Robber_III {
	//Method 1: brute force
    public int rob1(TreeNode root) {
        if(root == null) return 0;
        int left = root.left==null?0:(rob(root.left.left)  + rob(root.left.right));
        int right = root.right==null?0:(rob(root.right.left)  + rob(root.right.right));
        int l = root.left==null?0:rob(root.left);
        int r = root.right==null?0:rob(root.right);
        return Math.max((root.val+left+right), l+r);
    }
    
    //Method 2: bottom up
    public int rob(TreeNode root) {     
        decision res = helper(root);
        return Math.max(res.rob,res.not_rob);
    }
    
    private decision helper(TreeNode root){
        if(root == null) return new decision(0,0);
        decision left = helper(root.left);
        decision right = helper(root.right);
        // int not_rob = Math.max(Math.max(left.rob + right.rob, left.not_rob + right.not_rob),  
        // Math.max(left.rob + right.not_rob, left.not_rob + right.rob));
        int not_rob = Math.max(left.rob,left.not_rob)+Math.max(right.rob,right.not_rob);
        int rob = left.not_rob + right.not_rob + root.val;
        return new decision(rob,not_rob);
    }
}

class decision{
    int rob;
    int not_rob;
    public decision(int rob, int not_rob){
        this.not_rob = not_rob;
        this.rob = rob;
    }
}
