class Solution {

    public void solve(int []nums, int cb, List<Integer> curr, List<List<Integer>>ans){
        if(cb == nums.length){
            List<Integer> base = new ArrayList<>(curr);
            ans.add(base);
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != -11){
                int ele = nums[i];
                nums[i] = -11;
                curr.add(ele);

                solve(nums,cb+1,curr,ans);

                curr.remove(curr.size()-1);
                nums[i] = ele;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,0,curr,ans);
        return ans;
    }
}
