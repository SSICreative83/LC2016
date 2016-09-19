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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return root;
        
        TreeNode small, big;
        
        if(p.val >= q.val) {
            small = q;
            big = p;
        } else {
            small = p;
            big = q;
        }
        if(small.val <= root.val && big.val >= root.val) {
            return root;
        } else if(small.val <= root.val && big.val <= root.val ) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
