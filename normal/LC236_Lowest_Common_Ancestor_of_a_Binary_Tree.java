package normal;

import java.util.LinkedList;
import java.util.List;

import data_structure.TreeNode;

/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

*/
public class LC236_Lowest_Common_Ancestor_of_a_Binary_Tree {
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//		if(root==null || root == p || root == q) return root;
//		TreeNode left = lowestCommonAncestor(root.left,p,q);
//		TreeNode right = lowestCommonAncestor(root.right,p,q);
//		if(left!=null && right!=null) return root;
//		return left!=null?left:right;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode l11 = new TreeNode(-1);
		TreeNode l21 = new TreeNode(0);
		TreeNode l22 = new TreeNode(3);
		TreeNode l31 = new TreeNode(-2);
		TreeNode l32 = new TreeNode(4);
		TreeNode l41 = new TreeNode(8);
		l11.left = l21;
		l11.right = l22;
		l21.left = l31;
		l21.right = l32;
		l31.left = l41;
		
		String tr = null;
		System.out.println(tr);
		
//		lowestCommonAncestor(l11,l32,l41);
	}
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode target = null;
        countOfChild(root, p, q, target);
        if(target == null) return root;
        else return target;
    }
    private static int countOfChild(final TreeNode root, final TreeNode p, final TreeNode q, TreeNode target) {
        if(target != null) return 0;
        if(root == null) return 0;
        int res = 0;
        if(root == p || root == q) res++;
        res += countOfChild(root.left, p, q, target);
        res += countOfChild(root.right, p, q, target);
        if(target == null && res == 2) target = root;
        return res;
    }

//    static List<TreeNode> pPath,qPath;
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        backtracking(root,p,q,new LinkedList<>());
//        if(pPath==null || qPath==null) return null;
//        for(int ppt = pPath.size()-1, qpt = qPath.size()-1; ppt >= 0 && qpt >= 0; ppt--,qpt--){
//            if(pPath.get(ppt)!=pPath.get(qpt)) pPath.get(ppt+1);
//        }
//        return null;
//        
//    }
//    
//    
//    public static void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
//        if(root==null) return;
//        if(pPath!=null && qPath!=null) return;
//        if(root==p){
//            path.add(p);
//            pPath = new LinkedList<TreeNode>(path);
//            path.remove(path.size()-1);
//        }
//        if(root==q){
//            path.add(q);
//            qPath = new LinkedList<TreeNode>(path);
//            path.remove(path.size()-1);
//        }
//        
//        path.add(root);
//        backtracking(root.left,p,q,new LinkedList<>(path));
//        backtracking(root.left,p,q,new LinkedList<>(path));
//        path.remove(path.size()-1);
//        return;
//    }    
}
