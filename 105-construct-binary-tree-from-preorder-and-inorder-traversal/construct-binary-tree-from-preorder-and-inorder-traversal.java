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
        int el = pre[ps];
        int idx = mp.get(el);
        int count = idx-ins;
        TreeNode root = new TreeNode(el);
        root.left = build(pre,ps+1,ps+count,ino,ins,idx-1,mp);
        root.right = build(pre,ps+count+1,pe,ino,idx+1,ine,mp);
        return root;
    }
    public TreeNode buildTree(int[] pre, int[] ino) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<pre.length;i++){
            mp.put(ino[i],i);
        }
        return build(pre,0,pre.length-1,ino,0,ino.length-1,mp);
    }
}