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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        ListNode x = head;
        int l=0;
        while(x!=null){
            x=x.next;
            l++;
        }
        if(l<k)
            return head;
        ListNode curr = head, pr=null,tmp=null;
        for(int i=0;i<k;i++){
            tmp = curr.next;
            curr.next = pr;
            pr=curr;
            curr=tmp;
        }
        head.next = reverseKGroup(curr,k);
        return pr;
    }
}