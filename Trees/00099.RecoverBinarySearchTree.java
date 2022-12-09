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

    public TreeNode getRightMost(TreeNode head, TreeNode node){
        while(node.right!=null && node.right!=head){
            node = node.right;
        }

        return node;
    }

    public void recoverTree(TreeNode root) {
        TreeNode curr = root, a = null, b = null, prev = null;

        while(curr!=null){
            TreeNode left = curr.left;

            if(left == null){
                if(prev!=null && prev.val > curr.val){
                    if(a == null){
                        a = prev;
                    }

                    b = curr;
                }

                prev = curr;
                curr = curr.right;
            }else{
                TreeNode rightMost = getRightMost(curr,left);

                if(rightMost.right == null){
                    rightMost.right = curr;
                    curr = curr.left;
                }else{
                    rightMost.right = null;
                    if(prev!=null && prev.val > curr.val){
                        if(a == null){
                            a = prev;
                        }
                        
                        b = curr;
                    }

                    prev = curr;
                    curr = curr.right;    
                }
            }
        }

        int t = a.val;
        a.val = b.val;
        b.val = t;

    }
}
