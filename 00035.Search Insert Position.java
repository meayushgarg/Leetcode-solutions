class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        
        int si = 0, ei = n-1;

        while(si<=ei){
            int mid = (si + ei) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                ei = mid - 1;
            }else if(nums[mid] < target){
                si = mid + 1;
            }
        }

        return si;
    }
}
