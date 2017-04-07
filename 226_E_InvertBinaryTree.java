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
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        TreeNode r = invertTree(root.right);
        TreeNode l = invertTree(root.left);
        root.left = r;
        root.right = l;
        return root;
    }
}
