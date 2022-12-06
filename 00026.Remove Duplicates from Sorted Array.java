class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0, k = 0, n = nums.length;

        while(i < n){
            nums[k] = nums[i]; 
            k++;

            int j = i + 1;
            while(j<n && (nums[i] == nums[j])){
                j++;
            }

            i = j;
        }

        return k;
    }
}
