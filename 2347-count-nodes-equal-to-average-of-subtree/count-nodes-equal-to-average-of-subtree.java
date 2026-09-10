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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
        

        
    }
    void dfs(TreeNode root){
        if(root==null)return ;

        int count=nodes(root);
        int sum=sum(root);
        int avg=sum/count;

        if(root.val==avg){
            ans++;
        }
         dfs(root.left);
    dfs(root.right);
    }
    public int nodes(TreeNode node){
        if(node==null)return 0;
        return 1+ nodes(node.left)+nodes(node.right);
       

    }
    public int sum(TreeNode node){
        if(node==null){
            return 0;}

           return node.val +sum(node.left) +sum(node.right);
        
    }
}