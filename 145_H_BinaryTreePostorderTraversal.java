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
    //self
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res ;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while(p != null) {
            stack.push(p); 
            res.add(p.val);
            p = p.right;
        }
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.left != null) {
                p = cur.left;
                while(p != null) {
                    stack.push(p);
                    res.add(p.val);
                    p = p.right;
                }
            }
        }

        Collections.reverse(res);
        return res;
    }
    
    //more concise solution using 1 while loop
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
