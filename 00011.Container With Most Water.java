// 1st approach but not accepted due to bad complexity but it is a brute force 

class Solution {
    public int maxArea(int[] height) {
        int n = height.length, max = 0;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int h = Math.min(height[i],height[j]);
                int w = j - i;
                int area = h * w;
                max = Math.max(max,area);
            }
        }

        return max;
    }
}

// 2nd aproach 

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, max = 0;

        while(i<j){
            int w = j - i;
            max = Math.max(max, w * (height[i] > height[j]? height[j--]: height[i++]));
        }

        return max;
    }
}
