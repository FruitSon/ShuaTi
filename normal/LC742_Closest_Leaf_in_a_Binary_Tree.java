package normal;

import java.util.LinkedList;
import java.util.Queue;

import data_structure.TreeNode;

/*
A node is called a leaf if it has no children.
In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
Example 1:
Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)
Explanation: Either 2 or 3 is the closest leaf node to 1.

Example 2:
Input:
root = [1], k = 1
Output: 1
Explanation: The closest leaf node is the root node itself.

Example 3:
Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is closest to the node with value 2.
Note:

root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.
*/
public class LC742_Closest_Leaf_in_a_Binary_Tree {
	//Method1: BFS, level order traverse
	//Time: O(Tree.size) = O(N)
	//Space: O(Tree.size/2) = O(N)
	public int findCloestLeaf(TreeNode root){
		Queue<TreeNode> levelTraverse = new LinkedList<>();
		levelTraverse.add(root);
		while(!levelTraverse.isEmpty()){
			int size = levelTraverse.size();
			for(int i = 0; i < size ; i++){
				TreeNode tmp = levelTraverse.poll();
				if(tmp.left==null && tmp.right==null) return tmp.val;
				if(tmp.left!=null) levelTraverse.add(tmp.left);
				if(tmp.right!=null) levelTraverse.add(tmp.right);
			}
		}
		return 0;
	}
}
