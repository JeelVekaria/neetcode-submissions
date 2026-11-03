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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();

        if(root!= null) que.add(root);

        int level = 0;
        // bfs
        while(!que.isEmpty()) {
            int size = que.size();

            for(int i=0; i<size; i++) {
                TreeNode node = que.poll();
                if(node.left!=null)  {
                    que.add(node.left);
                }
                if(node.right!=null) {
                    que.add(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
