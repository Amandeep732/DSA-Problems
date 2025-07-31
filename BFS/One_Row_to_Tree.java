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

   // problem number 623 on leetcode
   // topics = Binary tree, Breath First Search and Depth First Search
   // Approach I used =>  Breath First Serach 




class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
       if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;

        // Traverse until we reach level depth - 1
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (currentDepth == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    // Save original children
                    TreeNode tempLeft = node.left;
                    TreeNode tempRight = node.right;

                    // Insert new nodes
                    node.left = new TreeNode(val);
                    node.left.left = tempLeft;

                    node.right = new TreeNode(val);
                    node.right.right = tempRight;
                }
                break; // done adding, no need to go deeper
            }

            // Normal BFS level traversal
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            currentDepth++;
        }

        return root;
    }
}