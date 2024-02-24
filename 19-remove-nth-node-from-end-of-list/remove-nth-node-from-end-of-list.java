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
        while(fast!=null){
            fast = (fast==null)?head:fast.next;
            if(fast==null)
                break;
            slow = (slow==null)?head:slow.next;
        }
        if(slow==null)
            return head.next;
        else{
            slow.next = slow.next==null?null:slow.next.next;
            return head;
        }
    }
}