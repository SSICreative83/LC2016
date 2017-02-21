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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res ;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                res.add(p.val);
                p = p.right;
            } else {
                TreeNode cur = stack.pop();
                p = cur.left;
            }
 
        }
        Collections.reverse(res);
        return res;
    }
}
