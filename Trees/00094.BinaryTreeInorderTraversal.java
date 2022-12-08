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

// 1st approach

class Solution {

    public void fill(TreeNode node, LinkedList<TreeNode> st){
        while(node!=null){
            st.addLast(node);
            node = node.left;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        LinkedList<TreeNode> st = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        fill(root,st);

        while(st.size()!=0){
            TreeNode rn = st.removeLast();
            ans.add(rn.val);

            if(rn.right!=null){
                fill(rn.right,st);
            }
        }

        return ans;
    }
}

class Solution {

    public TreeNode getRightMost(TreeNode head, TreeNode node){
        while(node.right!=null && node.right!=head){
            node = node.right;
        }

        return node;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        while(curr!=null){
            TreeNode left = curr.left;

            if(left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode rightMost = getRightMost(curr,left);

                if(rightMost.right == null){
                    rightMost.right = curr;
                    curr = curr.left;
                }else{
                    rightMost.right = null;
                    ans.add(curr.val);
                    curr = curr.right;    
                }
            }
        }

        return ans;
    }
}
