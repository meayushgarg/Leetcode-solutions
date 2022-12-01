class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int num = x, y = 0;

        while(num!=0){
            int r = num % 10;
            y = (y * 10) + r;
            num = num / 10;
        }

        return x == y;
    }
}
