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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)    return res;
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for(String left : leftPaths) {
            res.add(root.val + "->" + left);
        }
        for(String right : rightPaths) {
            res.add(root.val + "->" + right);
        }
        
        if(res.size() == 0) {
            res.add(String.valueOf(root.val));
        }
        return res;
    }
}
