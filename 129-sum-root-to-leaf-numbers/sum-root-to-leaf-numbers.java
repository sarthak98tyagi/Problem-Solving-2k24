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
    public int fn(TreeNode root, int num){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return num*10+root.val;
        }
        int x = num*10+root.val;
        return fn(root.left,x)+fn(root.right,x);
    }
    public int sumNumbers(TreeNode root) {
        return fn(root,0);
    }
}