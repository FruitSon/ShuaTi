package normal;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import data_structure.TreeNode;

/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 

return its vertical order traversal as:

[
  [9],
  [3,15],
  [20],
  [7]
]
 

Given binary tree [3,9,20,4,5,2,7],

    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
 

return its vertical order traversal as:

[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
*/

// Method 1: wrap class + level traverse ( pq)
// Wrapper class to record the id of col it belongs to
// Time: O(n)
// Space: O(n)

//can't use recursive as it reverese the order of value which are in the right subtree

public class LC314_Binary_Tree_Vertical_Order_Traversal {
	// Method 1: LEVEL ORDER
	public List<List<Integer>> verticalOrder(TreeNode root) {    
    	List<List<Integer>> res = new LinkedList<>();
    	if(root==null) return res;
    	Map<Integer, List<Integer>> map = new TreeMap<>();
    	LinkedList<wrapNode> q = new LinkedList<>();
    	q.add(new wrapNode(root,0));
    	while(!q.isEmpty()){
    		int size = q.size();
    		for(int i = 0; i<size; i++){
    			wrapNode tmp = q.removeFirst();
    			if(!map.containsKey(tmp.getCol())) map.put(tmp.getCol(),new LinkedList<Integer>());
    			map.get(tmp.getCol()).add(tmp.getNode().val);
    			if(tmp.getNode().left!=null) q.addLast(new wrapNode(tmp.getNode().left,tmp.getCol()-1));
    			if(tmp.getNode().right!=null) q.addLast(new wrapNode(tmp.getNode().right,tmp.getCol()+1)); 
    		}
    	}
    	for(List<Integer> list : map.values()) res.add(list);
    	return res;    
    }
	
//  public List<List<Integer>> verticalOrder(TreeNode root) {    
//	Map<Integer, List<Integer>> map = new TreeMap<>();
//	inOrder(root, map, 0);
//	List<List<Integer>> res = new LinkedList<>();
//	for(List<Integer> list : map.values()) res.add(list);
//	return res;    	
//}
//
//private void inOrder(TreeNode root, Map<Integer, List<Integer>> map, int col){
//	if(root==null) return;
//	if(!map.containsKey(col)) map.put(col, new LinkedList<Integer>());
//	if(col > 0) map.get(col).add(root.val);
//	if(root.left!=null)  inOrder(root.left, map, col-1);
//	if(root.right!=null) inOrder(root.right, map, col+1);
//	return;
//}
}

class wrapNode {  
    private TreeNode node;  
    private int col;  
    
    public wrapNode(TreeNode node, int col) {  
        this.node = node;  
        this.col = col;  
    }  
    
    public TreeNode getNode(){
      return node;
    }
    
    public int getCol(){
      return col;
    }
}  