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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(qu.size()!=0){
            List<Integer> curr = new ArrayList<>();
            int size = qu.size();

            while(size-->0){
                TreeNode rn = qu.removeFirst();
                curr.add(rn.val);

                if(rn.left!=null){
                    qu.addLast(rn.left);
                }

                if(rn.right!=null){
                    qu.addLast(rn.right);
                }
            }

            ans.add(curr);
        }

        return ans;
    }
}
