class Solution {
    public int numTrees(int n) {
        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            int si = 0, ei = i-1;

            while(si < i){
                dp[i]+= (dp[si] * dp[ei]);
                si++;
                ei--;
            }
        }

        return dp[n];
    }
}
