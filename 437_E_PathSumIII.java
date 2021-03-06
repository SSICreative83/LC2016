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
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null)    return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int findPath(TreeNode root, int sum) {
        int res = 0;
        if(root == null) {
            return res;
        }
        if(root.val == sum) {
            res++;
        }
        int left = findPath(root.left, sum - root.val);
        int right = findPath(root.right, sum - root.val);
        return res + left + right;
    }
 
}
