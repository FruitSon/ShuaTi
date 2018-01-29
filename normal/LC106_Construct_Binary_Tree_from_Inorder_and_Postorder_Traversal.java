package normal;

import data_structure.TreeNode;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

// Method 1: 
// - 1.the root is in len - 1 of postorder
// - 2.find the idx of the root value in inorder array.
// - 3.the node in left subtree is in 0 ~ idx - 1, in right subtree is in idx + 1 ~ len-1
// repeat 1,2,3 until reach the leaf node. 
// - 4.return the root node at last
public class LC106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null ) return null;
        TreeNode res = constructHelper(inorder, 0, inorder.length-1,postorder,inorder.length-1);
        return res;
    }
    
    private TreeNode constructHelper(int[] inorder, int start, int end, int[] postorder, int rootidx){
        if(rootidx < 0 || start > end) return null;
        int root_val = postorder[rootidx];
        TreeNode root = new TreeNode(root_val);
        int root_idx_inorder = findRootInInorder(root_val,inorder, start, end);
        int right_len = end - root_idx_inorder+1;

        root.left = constructHelper(inorder, start, root_idx_inorder-1, postorder, rootidx - right_len);
        root.right = constructHelper(inorder, root_idx_inorder+1, end, postorder, rootidx-1);
        return root;

    }
    
    private int findRootInInorder(int val, int[] inorder, int start, int end){
        for(int i = start; i <= end ; i++){
            if(inorder[i]==val) return i;
        }
        return -1;
    } 
}
