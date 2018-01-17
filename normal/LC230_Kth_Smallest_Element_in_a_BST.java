package normal;

import data_structure.TreeNode;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */

//In order travel and use a counter to count the node visited
//Time: O(n)
//Space: O(1)

//follow up:
//for each node, add a extra int to record the number of its left child 
public class LC230_Kth_Smallest_Element_in_a_BST {
    
    private int cnt = 0;
    private int res = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return res;
    }
    
    private void inOrder(TreeNode node, int k){
        if(node==null) return;
        inOrder(node.left,k);
        cnt++;
        if(cnt==k){
            res = node.val;
            return;
        }
        inOrder(node.right,k);
    }
}
