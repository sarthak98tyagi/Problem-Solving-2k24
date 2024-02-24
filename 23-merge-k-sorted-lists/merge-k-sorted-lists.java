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
    public ListNode mergeKLists(ListNode[] arr) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode el : arr){
            if(el!=null)
                pq.add(el);
        }
        ListNode front = new ListNode(-1);
        ListNode curr = front;
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            curr.next = new ListNode(tmp.val);
            curr=curr.next;
            if(tmp.next!=null)
                pq.add(tmp.next);
        }
        return front.next;
    }
}