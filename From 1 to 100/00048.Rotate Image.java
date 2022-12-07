class Solution {

    public void transpose(int [][]arr){
        int n = arr.length;

        for(int i=0; i<n; i++){
            int l = i + 1, d = i + 1;

            while(l<n){
                int t = arr[i][l];
                arr[i][l] = arr[d][i];
                arr[d][i] = t; 
                l++;
                d++;
            }
        }
    }

    public void reverse(int [][]arr){
        int n = arr.length;

        for(int i=0; i<n; i++){
            int l = 0, r = n-1;

            while(l < r){
                int t = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = t;
                l++;
                r--;
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}
