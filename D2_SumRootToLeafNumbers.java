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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    public int sum(TreeNode root, int preSum) {
        if(root == null)    return preSum;
        
        int curSum = preSum * 10 + root.val;
        if(root.left == null && root.right == null) return curSum;
        
        int res = 0;
        if(root.left != null) res += sum(root.left, curSum);
        if(root.right != null) res += sum(root.right, curSum);
        return res;
    }
}
