class Solution {

    public void solve(int []arr, int tar, int idx, List<Integer> curr, List<List<Integer>>ans){
        if(tar == 0){
            List<Integer> base = new ArrayList<>(curr);
            ans.add(base);
            return;
        }

        for(int i=idx; i<arr.length; i++){
            if(tar - arr[i] >= 0){
                curr.add(arr[i]);
                solve(arr,tar-arr[i],i,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates,target,0,curr,ans);
        return ans;
    }
}
