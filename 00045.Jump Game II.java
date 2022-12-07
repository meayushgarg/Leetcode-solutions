// 1st approach (not accepted due to bad complexity)
class Solution {

    public int jump_(int []nums, int idx){
        int n = nums.length;

        if(idx == n-1){
            return 0;
        }

        if(nums[idx] == 0){
            return (int)1e9;
        }

        int min = (int)1e9;

        for(int jumps=1; jumps<=nums[idx]; jumps++){
            if(idx + jumps < n){
                int recAns = jump_(nums,idx + jumps);
                min = Math.min(min,recAns);
            }
        }

        return min + 1;
    }

    public int jump(int[] nums) {
        return jump_(nums,0);
    }
}

// 2nd approach

class Solution {

    public int jump_(int []nums, int idx, int []dp){
        int n = nums.length;

        if(idx == n-1){
            return dp[idx] = 0;
        }

        if(nums[idx] == 0){
            return dp[idx] = (int)1e9;
        }

        if(dp[idx] != 0){
            return dp[idx];
        }

        int min = (int)1e9;

        for(int jumps=1; jumps<=nums[idx]; jumps++){
            if(idx + jumps < n){
                int recAns = jump_(nums,idx + jumps,dp);
                min = Math.min(min,recAns);
            }
        }

        return dp[idx] = min + 1;
    }

    public int jump(int[] nums) {
        int []dp = new int[nums.length];
        return jump_(nums,0,dp);
    }
}

// 3rd approach
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return 0;
        }

        int []dp = new int[n];
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            if(nums[i] == 0){
                dp[i] = (int)1e9;
                continue;
            }

            int min = (int)1e9;

            for(int jumps = 1; jumps <= nums[i]; jumps++){
                if(i + jumps < n){
                    min = Math.min(min, dp[i + jumps]);
                }
            }

            dp[i] = (min == (int)1e9? min: min + 1);
        }   

        return dp[0]; 
    }
}
