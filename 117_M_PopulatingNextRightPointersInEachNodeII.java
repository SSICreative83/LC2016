/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
       if (root == null) 
            return;  
  
        TreeLinkNode p = root.next;  
        
        //find the valid next
        while (p != null) {  
            if (p.left != null) {  
                p = p.left;  
                break;  
            }  
            if (p.right != null) {  
                p = p.right;  
                break;  
            }  
            p = p.next;  
        }  
  
        if (root.right != null) {  
            root.right.next = p;  
        }  
  
        if (root.left != null) {
            if(root.right!=null)
                root.left.next = root.right;
            else
                root.left.next = p;
        }  
  
        connect(root.right);
        connect(root.left);
    }
    

}
