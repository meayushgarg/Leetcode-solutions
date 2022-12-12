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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<TreeNode> st = new LinkedList<>();
        LinkedList<TreeNode> child = new LinkedList<>();
        st.addLast(root);

        int level = 0;

        while(st.size()!=0){
            List<Integer> curr = new ArrayList<>();
            int size = st.size();

            while(size-->0){
                TreeNode rn = st.removeLast();
                curr.add(rn.val);

                if(level % 2 == 0){
                    if(rn.left!=null){
                        child.addLast(rn.left);
                    }

                    if(rn.right!=null){
                        child.addLast(rn.right);
                    }
                }else{
                    if(rn.right!=null){
                        child.addLast(rn.right);
                    }   

                    if(rn.left!=null){
                        child.addLast(rn.left);
                    }
                }
            }

            ans.add(curr);
            LinkedList<TreeNode> temp = st;
            st = child;
            child = temp;
            level++;
        }

        return ans;
    }
}
