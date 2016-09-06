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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)    return 0;
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root) {
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int sum = root.val;
        if(left > 0)    sum += left;
        if(right > 0)   sum += right;
        
        max = Math.max(max, sum);
        return Math.max(left, right) > 0 ? Math.max(left, right) + root.val : root.val;
        
    }
}
