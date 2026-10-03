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
     public int[] robTree(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[]left=robTree(root.left);
        int[]right=robTree(root.right);
        int notrob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        int rob=root.val+left[0]+right[0];
        return new int[]{notrob, rob};
    }
    public int rob(TreeNode root) {
        int[]result=robTree(root);
        return Math.max(result[0],result[1]);
    }
}