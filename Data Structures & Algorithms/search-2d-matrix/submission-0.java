class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length; 
        int n = r * c;
        int l = 0, h = n - 1;
        while(l <= h){
            int m = l + (h - l)/2;
            int i = m / c;
            int j = m % c;
            int v = matrix[i][j];
            if(v == target){
                return true;
            }
            if(v < target){
                l = m + 1;
            }else{
                h = m - 1;
            }
        }
        return false;
    }
}
