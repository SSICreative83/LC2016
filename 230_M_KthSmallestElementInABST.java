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
    //Recursive
    public int kthSmallest1(TreeNode root, int k) {
        if(root == null)    return 0;
        int left = countNode(root.left);
        if(k == left + 1) {
            return root.val;
        } else if(k < left + 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - left - 1);
        }
    }
    
    public int countNode(TreeNode root) {
        if(root == null)    return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
    
    //Iterative
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)    return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            k--;
            if(k == 0) {
                //current node is kth smallest
                return cur.val;
            }
            
            TreeNode r = cur.right;
            while(r != null) {
                stack.push(r);
                r = r.left;
            }
        }
        
        return -1;
    }
}
