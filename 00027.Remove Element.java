class Solution {

    public void swap(int []arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int si  = 0, ei = n-1;

        while(si <= ei){
            if(nums[si] == val){
                swap(nums,si,ei);
                ei--;
            }else{
                si++;
            }
        }

        return si;
    }
}
