package normal;

//Given a binary tree, find the length of the longest path where each node in the path has the same value. 
//This path may or may not pass through the root.
//
//Note: The length of path between two nodes is represented by the number of edges between them.
public class LC687_Longest_Univalue_Path {
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
//		//Method 1: recursion
//	     int maxNode = Integer.MIN_VALUE;
//	     public int longestUnivaluePath(TreeNode root) {
//	         if(root==null) return 0;
//	         helper(root);
//	         return Math.max(maxNode,1)-1;
//	     }
	    
//	     private int helper(TreeNode root){
//	         if(root==null) return 0;
//	         int left = helper(root.left);
//	         int right = helper(root.right);
	        
//	         boolean leftInclude = root.left==null || root.left.val!=root.val ? false : true;
//	         boolean rightInclude = root.right==null || root.right.val!=root.val ? false : true;
	        
//	         maxNode = Math.max(1+ (leftInclude&&rightInclude? left + right: leftInclude ? left : rightInclude ? right : 0), maxNode);
//	         return Math.max(leftInclude?left:0, rightInclude?right:0) +1;    
//	     }

	//Method2: more organized but re-travel?
	public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int longestIncludeRoot = longestUnivaluePathIncludeNode(root.left, root.val) + longestUnivaluePathIncludeNode(root.right, root.val);
	    int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        return Math.max(Math.max(longestIncludeRoot, left), right);
	}

    private int longestUnivaluePathIncludeNode(final TreeNode node, final int val) {
    	if(node == null || node.val != val) return 0;
	    int left = longestUnivaluePathIncludeNode(node.left, val);
	    int right = longestUnivaluePathIncludeNode(node.right, val);
        return Math.max(left, right) + 1;
    }
}
