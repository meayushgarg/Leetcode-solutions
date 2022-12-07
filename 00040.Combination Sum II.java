class Solution {

    public void solve(int []arr, int tar, int idx, List<Integer> curr, List<List<Integer>>ans){
        if(tar == 0){
            List<Integer> base = new ArrayList<>(curr);
            ans.add(base);
            return;
        }

        int prev = -1;

        for(int i=idx; i<arr.length; i++){
            if(prev!=arr[i] && tar - arr[i] >= 0){
                prev = arr[i];
                curr.add(arr[i]);
                solve(arr,tar-arr[i],i+1,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates,target,0,curr,ans);
        return ans;
    }
}
