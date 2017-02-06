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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    
    public void dfs(TreeNode root, List<Integer> res, int level) {
        if(root == null)    return;
        
        if(level == res.size()) {
            res.add(root.val);
        }

        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
        
    }
}
