// 1st approach - Not accepted due to bad complexity but it is brute force solution

class Solution {
    public boolean isPalindrome(String str){
        int i = 0, j = str.length()-1;

        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length(), max = 0;
        String ans = "";

        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                String str = s.substring(i,j);
                if(isPalindrome(str) && str.length() > max){
                    max = str.length();
                    ans = str;
                }
            }
        }

        return ans;
    }
}


// 2nd approach using dp gap strategy

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), len = 0, si = 0;
        boolean [][]dp = new boolean[n][n];

        for(int gap=0; gap<n; gap++){
            for(int i=0, j = gap; j<n; i++,j++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1]));
                }

                if(dp[i][j] && (j-i+1) > len){
                    len = j - i + 1;
                    si = i;
                }
            }
        }

        return s.substring(si,si+len);
    }
}
