// 1st approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, i = 0, j = 0, k = 0;
        int []arr = new int[n + m];

        while(i < n && j < m){
            if(nums1[i] > nums2[j]){
                arr[k++] = nums2[j++];
            }else{
                arr[k++] = nums1[i++];
            }
        }

        while(j<m){
            arr[k++] = nums2[j++];
        }

        while(i<n){
            arr[k++] = nums1[i++];
        }

        int size = arr.length;
        double a = (double)(arr[size/2]);
        double b = (size%2==0? (double)(arr[(size/2) - 1]): a);
        System.out.println(a + " " + b);
        return (a + b)/2;

    }
}
