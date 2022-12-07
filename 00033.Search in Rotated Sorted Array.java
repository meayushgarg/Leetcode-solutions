class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int si = 0, ei = n-1;

        while(si<=ei){
            int mid = (si + ei) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[si]){
                if(target >= nums[si] && target < nums[mid]){
                    ei = mid - 1;
                }else{
                    si = mid + 1;
                }
            }else if(nums[ei] >= nums[mid]){
                if(target > nums[mid] && target <= nums[ei]){
                    si = mid + 1;
                }else{
                    ei = mid - 1;
                }
            }
        }

        return -1;
    }
}
