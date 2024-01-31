/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void fun(Node node, Node pr, boolean right){
        if(node==null)
            return;
        if(pr!=null){
            if(right){
                if(pr.next!=null)
                    node.next=pr.next.left;                    
            }
            else{
                node.next=pr.right;
            }
        }
        fun(node.left,node,false);
        fun(node.right,node,true);

    }
    public Node connect(Node root) {
        fun(root,null,false);
        return root;
    }
}