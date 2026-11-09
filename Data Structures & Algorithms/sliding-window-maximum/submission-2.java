class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int[] result = new int[nums.length - (k - 1)];
        for(int i = 0; i <= nums.length - k; i++){
            int m = -1001;
            for(int j = i; j < i + k; j++){
                if(nums[j] > m){
                   m = nums[j]; 
                }
            }
            result[i] = m;
        }
        return result;
    }
}
