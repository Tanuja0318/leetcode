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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode pnode=queue.poll();
            TreeNode qnode=queue.poll();
            if((pnode==null)&&(qnode==null)){
                continue;
            }
            if(pnode==null || qnode==null || pnode.val!=qnode.val){
                return false;
            }
            queue.add(pnode.left);
            queue.add(qnode.left);
            queue.add(pnode.right);
            queue.add(qnode.right);
        }
        return true;
    }
}