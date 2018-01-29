package normal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data_structure.TreeNode;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

// Method 1: level order 
// Time : O(n)
public class LC103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> buffer = new LinkedList<>();
        TreeNode tmp = null;
        boolean flag = false;
        buffer.add(root);
        while(buffer.size()!=0){
            int size = buffer.size();
            LinkedList<Integer> level = new LinkedList<>();
            if(!flag){
                for(int i = 0; i < size; i++){
                    tmp = buffer.poll();
                    level.addLast(tmp.val);
                    if(tmp.left!=null) buffer.offer(tmp.left);
                    if(tmp.right!=null) buffer.offer(tmp.right);                
                }
            }else{
                  for(int i = 0; i < size; i++){
                    tmp = buffer.poll();
                    level.addFirst(tmp.val);
                    if(tmp.left!=null) buffer.offer(tmp.left);
                    if(tmp.right!=null) buffer.offer(tmp.right);                
                }
            }
            flag = !flag;
            res.add(level);            
        }
        return res;
    }
}
