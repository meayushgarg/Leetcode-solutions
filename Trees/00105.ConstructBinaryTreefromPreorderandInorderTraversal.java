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

    public TreeNode buildTree_(int []pre, int []in, int psi, int pei, int isi, int iei){
        if(isi > iei){
            return null;
        }

        int num = pre[psi], idx = -1;

        for(int i=isi; i<=iei; i++){
            if(in[i] == num){
                idx = i;
                break;
            }
        }

        int noe = idx - isi;

        TreeNode root = new TreeNode(num);
        root.left = buildTree_(pre,in,psi+1,psi+noe,isi,idx-1);
        root.right = buildTree_(pre,in,psi+noe+1,pei,idx+1,iei);
        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree_(preorder,inorder,0,n-1,0,n-1);
    }
}
