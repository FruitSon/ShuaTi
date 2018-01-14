package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC741_Cherry_Picker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateTrees(3);
	}

	/**
	 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	 *
	 * For example,
	 * Given n = 3, your program should return all 5 unique BST's shown below.
	 *
	 * 1         3     3      2      1
	 * \       /     /      / \      \
	 * 3     2     1      1   3      2
	 * /     /       \                 \
	 * 2     1         2                 3
	 *
	 *
	 */

	    public static List<TreeNode> generateTrees(int n) {
	        List<List<TreeNode>> dp = new LinkedList<>();
	        
	        dp.add(null);
	        List<TreeNode> firstNode = new LinkedList<>();
	        firstNode.add(new TreeNode(1));
	        dp.add(firstNode);
	        
	        for(int i =2; i <= n; i++){
	            List<TreeNode> tmp = new LinkedList<>();
	            for(int j = 0 ; j < i; j ++){
	                List<TreeNode> lefts = dp.get(j);
	                List<TreeNode> rights = dp.get(i-1-j);
	                generateAllNode(lefts, rights, tmp, i);    
	            }
	            dp.add(tmp);
	        }
	        return dp.get(n);
	    }
	    
	    private static  void generateAllNode(List<TreeNode> lefts, List<TreeNode> rights, List<TreeNode> tmp, int delta){
	        if(lefts==null && rights!=null){
	            for(TreeNode tr : rights){
	                TreeNode node = new TreeNode(delta);
	                node.right = generateSubTree(delta,tr);
	                tmp.add(node);
	            }
	        }else if(rights==null && lefts != null){
	            for(TreeNode tl : lefts){
	                TreeNode node = new TreeNode(delta);
	                node.left = tl;
	                tmp.add(node);
	            }
	        }else if(rights!=null && lefts != null){
	            for(TreeNode tl : lefts){
	                for(TreeNode tr: rights){
	                    TreeNode node = new TreeNode(delta);
	                    node.left = tl;
	                    node.right = generateSubTree(delta,tr);
	                    tmp.add(node);
	                }
	            }
	        }
	        return ;        
	    }
	    
	    private static TreeNode generateSubTree(int delta, TreeNode n){
	        if(n==null) return null;
	        if( n.left==null && n.right==null) return new TreeNode(n.val + delta);
	        TreeNode root = new TreeNode(n.val);
	        root.left = generateSubTree(delta, n.left);
	        root.right = generateSubTree(delta, n.right);
	        return root;
	    }
	}
	
	    class TreeNode {
	        int val;
	        public TreeNode left;
	        public TreeNode right;
	        TreeNode(int x) { val = x; }
	    }
	



