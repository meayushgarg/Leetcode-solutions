class Solution {

    public int fi(int []nums, int tar, int n){
        int si = 0, ei = n - 1, idx = -1;

        while(si<=ei){
            int mid = (si + ei) / 2;

            if(nums[mid] == tar){
                idx = mid;
                ei = mid - 1;
            }else if(nums[mid] > tar){
                ei = mid - 1;
            }else{
                si = mid + 1;
            }
        }

        return idx;
    }

    public int li(int []nums, int tar, int n){
        int si = 0, ei = n - 1, idx = -1;

        while(si<=ei){
            int mid = (si + ei) / 2;

            if(nums[mid] == tar){
                idx = mid;
                si = mid + 1;
            }else if(nums[mid] > tar){
                ei = mid - 1;
            }else{
                si = mid + 1;
            }
        }

        return idx;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        int n = nums.length;
        int firstIdx = fi(nums,target,n);
        int lastIdx = li(nums,target,n);
        return new int[]{firstIdx,lastIdx};
    }
}
