package normal;

import data_structure.TreeNode;

/*Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:

    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.

Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
*/
class BST{
	int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, size = 0;
	public BST(int max, int min, int size){
		this.max = max;
		this.min = min;
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}	
}

public class LC333_Largest_BST_Subtree {

	static int max_size = 1;	
	public static int largestBSTSubtree(TreeNode node){
		if(node==null) return 0;
		findBST(node);
		return max_size;
	}
	
	private static BST findBST(TreeNode n){
		if(n==null) return new BST(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
		if(n.left == null && n.right == null) {
			max_size = Math.max(1, max_size);
			return new BST(n.val,n.val,1);
		}
		BST left = findBST(n.left);
		BST right = findBST(n.right);
		System.out.println(n.val+","+left.max+","+left.min+","+right.max+","+right.min);
		if(left.max < n.val && right.min > n.val){
			max_size = Math.max(1+right.size+left.size, max_size);
			return new BST(Math.max(right.max,n.val),Math.min(left.min,n.val),1+right.size+left.size);
		}
		else return new BST(Integer.MAX_VALUE,Integer.MIN_VALUE,-1);
	}

}
