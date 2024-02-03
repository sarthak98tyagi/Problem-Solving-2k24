/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode build(int[] pre, int ps, int pe, int[] ino, int ins, int ine, Map<Integer,Integer> mp){
        if(ps>pe || ins>ine)
            return null;
        int el = pre[pe];
        int idx = mp.get(el);
        int count = ine-idx;
        TreeNode root = new TreeNode(el);
        root.left = build(pre,ps,pe-1-count,ino,ins,idx-1,mp);
        root.right = build(pre,pe-count,pe-1,ino,idx+1,ine,mp);

        return root;
    }
    public TreeNode buildTree(int[] ino, int[] pos) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<pos.length;i++){
            mp.put(ino[i],i);
        }
        return build(pos,0,pos.length-1,ino,0,ino.length-1,mp);
    }
}