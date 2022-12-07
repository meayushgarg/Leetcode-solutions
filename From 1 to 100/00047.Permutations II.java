class Solution {

    public void solve(int []nums, int cb, List<Integer> curr, List<List<Integer>>ans){
        if(cb == nums.length){
            List<Integer> base = new ArrayList<>(curr);
            ans.add(base);
            return;
        }

        int prev = (int)1e9;

        for(int i=0; i<nums.length; i++){
            if(prev!= nums[i] && nums[i] != -11){
                prev = nums[i];
                int ele = nums[i];
                nums[i] = -11;
                curr.add(ele);

                solve(nums,cb+1,curr,ans);

                curr.remove(curr.size()-1);
                nums[i] = ele;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,0,curr,ans);
        return ans;
    }
}
