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

    public TreeNode buildTree_(int []in, int []post, int isi, int iei, int psi, int pei){
        if(isi > iei){
            return null;
        }

        int num = post[pei], idx = -1;

        for(int i=isi; i<=iei; i++){
            if(in[i] == num){
                idx = i;
                break;
            }
        }

        int ele = iei - idx;

        TreeNode root = new TreeNode(num);
        root.right = buildTree_(in,post,idx+1,iei,pei-ele,pei-1);
        root.left = buildTree_(in,post,isi,idx-1,psi,pei-ele-1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree_(inorder,postorder,0,n-1,0,n-1);
    }
}
