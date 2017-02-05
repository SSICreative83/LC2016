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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(root, res);
        return res;
    }
    
    public int dfs(TreeNode root, List<List<Integer>> res) {
        if(root == null)    return -1;
        
        int heightL = dfs(root.left, res);
        int heightR = dfs(root.right, res);
        int height = Math.max(heightL, heightR) + 1;
        
        if(res.size() < height + 1) {
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(root.val);
        return height;
    }

}
