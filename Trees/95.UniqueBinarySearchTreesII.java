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

    public List<TreeNode> generateTrees_(int lr, int rr){
        if((lr > rr) || (lr == rr)){
            List<TreeNode> base = new ArrayList<>();
            base.add(lr > rr? null: new TreeNode(lr));
            return base;
        }

        int sp = lr, ep = rr;

        List<TreeNode> myAns = new ArrayList<>();

        for(int i=lr; i<=rr; i++){
            List<TreeNode> left = generateTrees_(sp,i-1);
            List<TreeNode> right = generateTrees_(i+1,ep);

            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode nn = new TreeNode(i);
                    nn.left = l;
                    nn.right = r;
                    myAns.add(nn);
                }
            }
        }

        return myAns;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees_(1,n);
    }
}
