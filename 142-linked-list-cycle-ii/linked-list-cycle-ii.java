/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }
        if(!cycle)
            return null;
        fast=head;
        while(true){
            if(slow==fast) 
                return slow;
            slow=slow.next;                
            fast=fast.next;
        }
    }
}