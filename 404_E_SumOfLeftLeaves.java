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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = dfs(root);
        return res;
    }
    
    public int dfs(TreeNode root) {
        if(root == null)    return 0;
        if(root.left == null) {
            return dfs(root.right);
        }
        if(root.left.left == null && root.left.right == null) {
            return root.left.val + dfs(root.right);
        }
        
        return dfs(root.left) + dfs(root.right);
    }
}
