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
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    
    public TreeNode flattenHelper(TreeNode root) {
        if(root == null)    return root;
        
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        
        root.left = null;
        root.right = connect(left, right);
        return root;
    }
    
    public TreeNode connect(TreeNode left, TreeNode right) {
        if(left == null)    return right;
        TreeNode p = left;
        while(p.right != null) {
            p = p.right;
        }
        p.right = right;
        
        return left;
    }
}
