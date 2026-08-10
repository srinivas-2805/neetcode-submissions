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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        helper(root, sb);

        return sb.toString();
    }

    public void helper(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("#,");
            return;
        }

        sb.append(node.val).append(",");

        helper(node.left, sb);
        helper(node.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        int[] index = {0};

        return helper2(values, index);
    }

    public TreeNode helper2(String[] values, int[] index) {

        if (values[index[0]].equals("#")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(
            Integer.parseInt(values[index[0]])
        );

        index[0]++;

        node.left = helper2(values, index);
        node.right = helper2(values, index);

        return node;
    }
}