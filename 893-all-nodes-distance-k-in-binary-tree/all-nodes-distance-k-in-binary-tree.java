/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> mp;
    public void ino(TreeNode root, TreeNode parent){
        if(root==null)
            return;
        mp.put(root,parent);
        ino(root.left,root);
        ino(root.right,root);
    }
    public void addNodes(TreeNode root, TreeNode target, List<Integer> ans, int k, boolean prcheck){
        if(root==target || root==null || k<0)
            return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        addNodes(root.left,target,ans,k-1,false);
        addNodes(root.right,target,ans,k-1,false);
        if(prcheck){
            addNodes(mp.get(root),root,ans,k-1,true);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        mp = new HashMap<>();
        ino(root,null);
        TreeNode pr = mp.get(target);
        List<Integer> ans = new ArrayList<>();
        if(k==0){
            ans.add(target.val);
            return ans;
        }
        addNodes(target.left,target,ans,k-1,false);
        addNodes(target.right,target,ans,k-1,false);
        addNodes(pr,target,ans,k-1,true);
        return ans;
    }
}