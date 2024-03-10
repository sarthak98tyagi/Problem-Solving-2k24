/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node i = head, tmp = null;
        while(i!=null){
            tmp = i.next;
            Node nw = new Node(i.val);
            i.next=nw;
            nw.next=tmp;
            i=tmp;
        }
        Node head2 = head.next;
        i=head;
        Node j;
        while(i!=null){
            j = i.next;
            j.random = (i.random==null)?null:(i.random.next);
            i = j.next;
        }
        i=head;
        while(i!=null){
            j=i.next;
            tmp = j.next;
            i.next=tmp;
            j.next = tmp==null?null:tmp.next;
            i=tmp;
        }
        return head2;
    }
}