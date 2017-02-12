/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //solution 1 iterative
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        if(root.left == null && root.right == null) return null;
        
        TreeNode succ = null;
        while(root != null) {
            if(root.val <= p.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
    
    //solution 2 dfs
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root==null || p==null) { return null; }
        if (p.right != null) {  // first try to find it in p's right subtree 
            TreeNode q = p.right;
            while (q.left!=null) { q = q.left; }
            return q;
        }  // if not found, next go upwards
        TreeNode succ = dfs(root, p);
        return succ==p ? null : succ;
    }
    
    private TreeNode dfs(TreeNode node, TreeNode p) {
        if (node==null || node==p) { return node; }
        TreeNode left = dfs(node.left, p);
        TreeNode right = dfs(node.right, p);
        if (right == p) { return p; }
        if (left == p) { return node; }
        return left==null? right : left;
    }
    
    //solution 3 recursion
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
    
    //same solution as above, predecessor
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
        return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
    
}
