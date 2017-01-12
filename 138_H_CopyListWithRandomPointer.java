/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)    return null;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode old_pointer = head;
        RandomListNode new_pointer = dummy;
        
        while(old_pointer != null) {
            new_pointer.next = new RandomListNode(old_pointer.label);
            map.put(old_pointer, new_pointer.next);
            
            old_pointer = old_pointer.next;
            new_pointer = new_pointer.next;
        }
        
        old_pointer = head;
        new_pointer = dummy.next;
        
        while(old_pointer != null) {
            new_pointer.random = map.get(old_pointer.random);
            old_pointer = old_pointer.next;
            new_pointer = new_pointer.next;
        }
        
        return dummy.next;
    }
}
