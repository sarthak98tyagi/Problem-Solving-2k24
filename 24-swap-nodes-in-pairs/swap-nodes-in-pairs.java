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
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head, pr =null, tmp;
        while(curr!=null && curr.next!=null){
            tmp = curr.next.next;
            if(pr!=null){
                pr.next=curr.next;
            }
            else{
                head = curr.next;
            }
            curr.next.next = curr;
            curr.next = tmp;
            pr=curr;
            curr = tmp;
        }
        return head;
    }
}