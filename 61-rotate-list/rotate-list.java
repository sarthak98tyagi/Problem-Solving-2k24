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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        if(head==null || head.next==null)
            return head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        k=k%len;
        if(k==0)
            return head;
        ListNode slow = null, fast = null;
        for(int i=0;i<k;i++){
            fast = fast == null?head:fast.next;
        }
        while(fast.next!=null){
            slow = slow==null?head:slow.next;
            fast = fast==null?head:fast.next;
        }
        ListNode tmp = slow.next,end =fast;
        slow.next=null;
        end.next= head;
        head=tmp;
        return head;
    }
}