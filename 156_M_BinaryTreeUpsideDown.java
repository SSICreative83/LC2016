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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return helper(root, null);
    }
    
    private TreeNode helper(TreeNode p, TreeNode parent) {
        if(p == null) {
            return parent;
        }
        
        TreeNode newRoot = helper(p.left, p);
        p.left = parent == null ? null : parent.right;
        p.right = parent;
        
        return newRoot;
    }
}
