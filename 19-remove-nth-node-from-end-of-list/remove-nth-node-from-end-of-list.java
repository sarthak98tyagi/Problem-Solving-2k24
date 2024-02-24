/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = null, fast = null;
        for(int i=0;i<n;i++){
            fast = (fast==null)?head:fast.next;
        }
        if(fast.next==null)
            return head.next;
        while(fast.next!=null){
            fast = (fast==null)?head:fast.next;
            slow = (slow==null)?head:slow.next;
        }
        slow.next = slow.next.next;
        return head;
        
    }
}